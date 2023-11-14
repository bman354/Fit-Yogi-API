package com.fityogimom.dao;

import com.fityogimom.entities.Client;
import com.fityogimom.entities.Program;
import com.fityogimom.entities.ProgramType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ClientDao.class);

    private String buildWhereClause(Integer id, String name, String phone, String email, Integer age, Date accountCreationDate) {
        List<String> conditions = new ArrayList<>();

        if (id != null) {
            conditions.add("id = " + id);
        }

        if (name != null && !name.isEmpty()) {
            conditions.add("name = '" + name + "'");
        }

        if (phone != null && !phone.isEmpty()) {
            conditions.add("phone = '" + phone + "'");
        }

        if (phone != null && !phone.isEmpty()) {
            conditions.add("email = '" + email + "'");
        }

        if (age != null && age > 0) {

            conditions.add("age = " + age);
        }

        if (accountCreationDate != null) {
            conditions.add("account_creation_date = '" + accountCreationDate + "'");
        }

        return String.join(" AND ", conditions);
    }

    private List<Client> queryClients(String fetchString) {

       logger.debug("Querying database with statement: " + fetchString);

        return jdbcTemplate.query(fetchString, (rs, rowNum) -> {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setPhone(rs.getString("phone"));
            client.setEmail(rs.getString("email"));
            client.setAge(rs.getInt("age"));
            client.setAccountCreationDate(rs.getDate("accountCreationDate"));
            client.setClientNote(rs.getString("clientNote"));
            client.setAdminNote(rs.getString("adminNote"));


            return client;
        });
    }



    public List<Client> getClientsByTags(Integer id, String name, String phone, String email, Integer age, Date accountCreationDate) {
        String fetchString = "SELECT * FROM Client WHERE " + buildWhereClause(id, name, phone, email, age, accountCreationDate);
        System.out.println("Generated SQL Query: " + fetchString);
        return queryClients(fetchString);
    }

    public Client getClient(Integer id, String name, String email, String phone, Integer age, Date accountCreationDate) {
        String fetchString = "SELECT * FROM Client WHERE " + buildWhereClause(id, name, phone, email, age, accountCreationDate);


        List<Client> returnClient = queryClients(fetchString);
        return returnClient.get(0);
    }

    public Client getClient(Client client) {
        String fetchString = "SELECT * FROM Client WHERE " + buildWhereClause(client.getId(), client.getName(), client.getPhone(), client.getEmail(), client.getAge(), client.getAccountCreationDate());

        List<Client> returnClient = queryClients(fetchString);
        return returnClient.get(0);
    }

    public boolean createClient(Client client) {
        String statement = "INSERT INTO Client (name, email, phone, age, accountCreationDate, adminNote, clientNote) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Date now = Date.valueOf(LocalDate.now());

            jdbcTemplate.update(statement,
                    client.getName(), // Name (required)
                    client.getEmail(), // Email (required)
                    client.getPhone(), // Phone (nullable)
                    client.getAge(), // Age (nullable)
                    now, // AccountCreationDate
                    client.getAdminNote(), // AdminNote (nullable)
                    client.getClientNote() // ClientNote (nullable)
            );

            return true;
        } catch (DataAccessException e) {
            logger.error("Client Create Database Exception: ", e);
            return false;
        }
    }
    public boolean updateClient(Client client) {
        String updateString = "UPDATE Client SET " + buildWhereClause(
                client.getId(),
                client.getName(),
                client.getPhone(),
                client.getEmail(),
                client.getAge(),
                client.getAccountCreationDate()
        ) + " WHERE id = " + client.getId();

        if (!updateString.contains("=")) {
            // No updates to perform
            return false;
        }

        try {
            jdbcTemplate.execute(updateString);
            return true;
        } catch (DataAccessException e) {
            logger.error("Database Exception: ", e);
            return false;
        }
    }

    public boolean deleteClient(Integer id) {
        String deleteString = "DELETE FROM Client WHERE id = " + id;

        try {
            jdbcTemplate.execute(deleteString);
            return true;
        } catch (DataAccessException e) {
            logger.error("Database Exception: ", e);
            return false;
        }
    }


    public List<Client> getAllClients() {
        String fetchString = "SELECT * FROM Client";

        return jdbcTemplate.query(fetchString, ((rs, rowNum) -> {
            Client client = new Client();

            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setPhone(rs.getString("phone"));
            client.setEmail(rs.getString("email"));
            client.setAge(rs.getInt("age"));
            client.setAccountCreationDate(rs.getDate("accountCreationDate"));
            client.setClientNote(rs.getString("clientNote"));
            client.setAdminNote(rs.getString("adminNote"));


            return client;
        }));

    }
}