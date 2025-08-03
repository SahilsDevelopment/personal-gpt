package com.syndrome.personal_gpt.controller;

import com.syndrome.personal_gpt.dto.Answer;
import com.syndrome.personal_gpt.dto.Question;
import com.syndrome.personal_gpt.service.Personal_GPT_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ask-ai")
@CrossOrigin(origins = "http://localhost:3000")
public class Personal_GPT_Controller {

    @Autowired
    private Personal_GPT_Service personalGptService;

    @PostMapping("")
    public ResponseEntity<Answer> fetch_response(@RequestBody Question question){
        return ResponseEntity.ok(personalGptService.fetchPersonal_GPT_response(question));
    }
}
