package com.fityogimom.dao;

import com.fityogimom.entities.Prompt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PromptDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ClientDao.class);


    public boolean createPrompt(Prompt prompt, int clientId) {
        String fetchString = "INSERT INTO Prompt " +
                "(ClientFk, prompt, creationDate) " +
                "VALUES (?, ?, ?)";


        try {
            jdbcTemplate.update(fetchString,
                    prompt.getClientId(), // Name (required)
                    prompt.getPrompt(), // Email (required)
                    Date.valueOf(LocalDate.now()) // PromptCreationDate
            );

            return true;
        } catch (Exception e){
            logger.error("Exception on createPrompt: ", e);
            return false;
        }


    }

    public Prompt getPromptById(int id) {

        String fetchString = "SELECT * FROM Prompt WHERE id = " + id;
        try {
            return jdbcTemplate.query(fetchString, (rs, rowNum) -> {
                Prompt prompt = new Prompt();
                prompt.setId(rs.getInt("id"));
                prompt.setClientId(rs.getInt("ClientFK"));
                prompt.setPrompt(rs.getString("prompt"));
                prompt.setCreationDate(rs.getDate("creationDate"));

                return prompt;
            }).get(0);
        } catch (Exception e){
            return null;
        }
    }
    public Prompt getPromptByClientId(int id) {

        String fetchString = "SELECT * FROM Prompt WHERE ClientFK = " + id;
        try {
            return jdbcTemplate.query(fetchString, (rs, rowNum) -> {
                Prompt prompt = new Prompt();
                prompt.setId(rs.getInt("id"));
                prompt.setClientId(id);
                prompt.setPrompt(rs.getString("prompt"));
                prompt.setCreationDate(rs.getDate("creationDate"));

                return prompt;
            }).get(0);
        } catch (Exception e){
            return null;
        }
    }

    public List<Prompt> getAllPrompts() {
        String fetchString = "SELECT * FROM Prompt";

        return jdbcTemplate.query(fetchString, (rs, rowNum) -> {
            Prompt prompt = new Prompt();
            prompt.setId(rs.getInt("id"));
            prompt.setPrompt(rs.getString("prompt"));
            prompt.setCreationDate(rs.getDate("creationDate"));
            return prompt;
        });
    }

    public boolean updatePrompt(Prompt prompt) {
        String fetchString = "UPDATE Prompt SET";



        try {
            jdbcTemplate.execute(fetchString);
            return true;
        } catch (DataAccessException e) {
            logger.error("Database Exception: ", e);
            return false;
        }
    }

    public boolean deletePrompt(int id) {
        //// TODO: 9/25/2023 implementation 
        return false;
    }
}
