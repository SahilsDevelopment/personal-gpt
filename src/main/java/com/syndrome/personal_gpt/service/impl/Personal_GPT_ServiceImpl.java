package com.syndrome.personal_gpt.service.impl;

import com.syndrome.personal_gpt.dto.Answer;
import com.syndrome.personal_gpt.dto.Question;
import com.syndrome.personal_gpt.service.Personal_GPT_Service;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Personal_GPT_ServiceImpl implements Personal_GPT_Service {

    private final ChatModel chatModel;

    @Autowired
    public Personal_GPT_ServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public Answer fetchPersonal_GPT_response(Question question){
        Prompt prompt = new PromptTemplate(question.getQuestion()).create();
        ChatResponse response = chatModel.call(prompt);

        if(response != null && !response.getResults().isEmpty()){
            String text = response.getResults().getFirst().getOutput().getText();
            if(text!=null && !text.trim().isEmpty()){
                return new Answer(text);
            }
        }

        return new Answer("No response received from the Personal_GPT.");
    }
}
