package com.fityogimom.controller;

import com.fityogimom.entities.Prompt;
import com.fityogimom.service.PromptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prompt")
public class DefaultPromptController implements PromptController{

    // TODO: 9/1/2023 implement prompt controller and service component

    @Autowired
    PromptService promptService;
    /**
     * @param prompt 
     * @return
     */
    @Override
    public ResponseEntity<String> createPrompt(Prompt prompt) {
        if(prompt.getClientId() == 0){
            return new ResponseEntity<>("Prompt was not assigned a client Id. Please try again with a valid client ID"
                    , HttpStatus.BAD_REQUEST);
        }
        //// TODO: 10/1/2023 this doesnt return the prompt 4head
        if (promptService.createPrompt(prompt)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public ResponseEntity<Prompt> getPromptById(int id) {
        return null;
    }

    /**
     * @return 
     */
    @Override
    public ResponseEntity<List<Prompt>> getAllPrompts() {
        List<Prompt> returnedPrompts = promptService.getAllPrompts();



        return ResponseEntity.ok(returnedPrompts);
    }

    /**
     * @param prompt 
     * @return
     */
    @Override
    public ResponseEntity<String> updatePrompt(Prompt prompt) {
        return null;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public ResponseEntity<String> deletePrompt(int id) {
        return null;
    }
}
