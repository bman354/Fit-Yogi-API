package com.fityogimom.service;

import com.fityogimom.dao.ClientDao;
import com.fityogimom.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDao clientDao;

    public List<Client> getClientsByCriteria(Integer id, String name, String email, String phone, Integer age, Date accountCreationDate) {

        return clientDao.getClientsByTags(id, name, email, phone, age, accountCreationDate);
    }


    public Client getClient(Integer id, String name, String email, String phone, Integer age, Date accountCreationDate) {

        return clientDao.getClient(id, name, email, phone, age, accountCreationDate);

    }

    public boolean createClient(Client client) {

        return clientDao.createClient(client);
    }

    public boolean updateClient(Client client) {

        return clientDao.updateClient(client);
    }

    public boolean deleteClient(Client client) {

        return clientDao.deleteClient(client.getId());
    }

    public List<Client> getAllClients() {

        return clientDao.getAllClients();
    }
}
