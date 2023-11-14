package com.fityogimom.controller;


import com.fityogimom.entities.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/client")
public interface ClientController {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Client>> getAllClients();


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Client>> getClientsByCriteria(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Date accountCreationDate
    );


    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Client> getClient(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Date accountCreationDate
    );




    @PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<String> createClient(@RequestBody Client client);

    @PostMapping("/update")
    ResponseEntity<String> updateClient(@RequestBody Client client);

    @PostMapping("/delete")
    ResponseEntity<String> deleteClient(@RequestBody Client client);

//end of controller
}