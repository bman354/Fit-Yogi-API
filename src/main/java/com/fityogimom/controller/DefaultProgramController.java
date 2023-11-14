package com.fityogimom.controller;

import com.fityogimom.entities.Program;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class DefaultProgramController implements ProgramController{

    // TODO: 9/1/2023 implement program class and create controller
    
    /**
     * @param program
     * @return
     */
    @Override
    public ResponseEntity<String> createProgram(Program program) {
        return null;
    }

    /**
     * @param client_id
     * @return
     */
    @Override
    public ResponseEntity<Program> getProgramById(int client_id) {
        return null;
    }

    /**
     * @param program
     * @return
     */
    @Override
    public ResponseEntity<String> updateProgram(Program program) {
        return null;
    }

    /**
     * @param program
     * @return
     */
    @Override
    public ResponseEntity<String> deleteProgram(Program program) {
        return null;
    }
}
