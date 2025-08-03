package com.syndrome.personal_gpt.service;

import com.syndrome.personal_gpt.dto.Answer;
import com.syndrome.personal_gpt.dto.Question;

public interface Personal_GPT_Service {
    Answer fetchPersonal_GPT_response(Question question);
}
