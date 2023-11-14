package com.fityogimom.controller;

import com.fityogimom.entities.Prompt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/prompt")
public interface PromptController {

    /*
    Create Prompt
     */
    @PostMapping("/create")
    ResponseEntity<String> createPrompt(@RequestBody Prompt prompt);

    /*
    Read Prompt
     */

    @GetMapping("/get")
    ResponseEntity<Prompt> getPromptById(@RequestParam int id);


    @GetMapping("")
    ResponseEntity<List<Prompt>> getAllPrompts();

    /*
    Update Prompt
     */
    @PostMapping("/update")
    ResponseEntity<String> updatePrompt(@RequestBody Prompt prompt);

    /*
    Delete Prompt
     */
    @DeleteMapping("/delete")
    ResponseEntity<String> deletePrompt(@RequestParam int id);
}

