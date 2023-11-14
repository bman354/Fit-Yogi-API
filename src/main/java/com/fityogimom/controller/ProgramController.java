package com.fityogimom.controller;

import com.fityogimom.entities.Program;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/programs")
public interface ProgramController {

    /*
    Create Programs
     */
    @PostMapping("/create")
    ResponseEntity<String> createProgram(@RequestBody Program program);

    /*
    Read Programs
     */

    @GetMapping("/get")
    ResponseEntity<Program> getProgramById(@RequestParam int client_id);

    /*
    Update Programs
     */
    @PostMapping("/update")
    ResponseEntity<String> updateProgram(@RequestBody Program program);

    /*
    Delete Programs
     */

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteProgram(@RequestBody Program program);

}
