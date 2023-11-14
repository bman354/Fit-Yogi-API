package com.fityogimom.controller;

import com.fityogimom.dao.ClientDao;
import com.fityogimom.entities.Client;
import com.fityogimom.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class DefaultClientController implements ClientController{

    @Autowired
    ClientService clientService;

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Override
    public ResponseEntity<List<Client>> getClientsByCriteria(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Date accountCreationDate
    ){
        logger.debug("getClientsByCriteria Called");
        List<Client> clients = clientService.getClientsByCriteria(id, name, email, phone, age, accountCreationDate);

        if (clients.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clients);
        }
    }
    @Override
    public ResponseEntity<List<Client>> getAllClients(){

        List<Client> clients = clientService.getAllClients();

        if (clients.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clients);
        }
    }

    @Override
    public ResponseEntity<Client> getClient(Integer id, String name, String email, String phone, Integer age, Date accountCreationDate) {
        logger.debug("getClient Called");
        Client client = clientService.getClient(id, name, email, phone, age, accountCreationDate);

        if(client != null){
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<String> createClient(Client client) {
        if(clientService.createClient(client)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Client Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<String> updateClient(Client client) {
        if(clientService.updateClient(client)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Client Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> deleteClient(Client client) {
        if(clientService.deleteClient(client)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Client Deletion Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
