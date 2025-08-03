package com.syndrome.personal_gpt.service;

import com.syndrome.personal_gpt.dto.Answer;
import com.syndrome.personal_gpt.dto.Question;
import com.syndrome.personal_gpt.service.impl.Personal_GPT_ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PersonalGptTest {

    @Mock
    private ChatModel chatModel;
    private Personal_GPT_Service personal_gpt_service;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        personal_gpt_service = new Personal_GPT_ServiceImpl(chatModel);
    }

    @DisplayName("Test Personal_GPT success response")
    @Test
    public void testPersonal_GPT_SuccessResponse(){
        Question question = Question.builder()
                .question("Who is Max Verstappen?")
                .build();

        Generation message = new Generation(new AssistantMessage("Max Verstappen is a World Class Formulae 1 driver"));
        ChatResponse chatResponse = new ChatResponse(Collections.singletonList(message));

        Prompt prompt = new PromptTemplate(question.getQuestion()).create();
        when(chatModel.call(prompt)).thenReturn(chatResponse);

        Answer personal_gpt_response = personal_gpt_service.fetchPersonal_GPT_response(question);

        assertEquals("Max Verstappen is a World Class Formulae 1 driver", personal_gpt_response.getGpt_says());
    }

    @DisplayName("Test Personal_GPT empty or no response")
    @Test
    public void testPersonal_GPT_emptyOrNoResponse(){
        Question question = Question.builder()
                .question("What is the Capital of France?")
                .build();

        Generation generation = new Generation(new AssistantMessage(""));
        ChatResponse chatResponse = new ChatResponse(Collections.singletonList(generation));

        Prompt prompt = new PromptTemplate(question.getQuestion()).create();
        when(chatModel.call(prompt)).thenReturn(chatResponse);

        Answer answer = personal_gpt_service.fetchPersonal_GPT_response(question);

        assertEquals("No response received from the Personal_GPT.", answer.getGpt_says());
    }
}
