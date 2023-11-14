package com.fityogimom.service;

import com.fityogimom.dao.PromptDao;
import com.fityogimom.entities.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptService {

    @Autowired
    PromptDao promptDao;

    public boolean createPrompt(Prompt prompt){

        return promptDao.createPrompt(prompt, prompt.getClientId());

    }

    //get based on Prompt ID
    public Prompt getPromptById(int id){
            return promptDao.getPromptById(id);
    }

    public Prompt getPromptByClientId(int clientId){
        return promptDao.getPromptByClientId(clientId);
    }

    public List<Prompt> getAllPrompts(){
        return promptDao.getAllPrompts();
    }

    public boolean updatePrompt(Prompt prompt){
        return promptDao.updatePrompt(prompt);
    }

    public boolean deletePrompt(int id){
        return promptDao.deletePrompt(id);
    }
}
