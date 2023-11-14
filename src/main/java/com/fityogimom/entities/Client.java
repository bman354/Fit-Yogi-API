package com.fityogimom.entities;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    private Integer id;
    private ArrayList<Program> programs;
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private Date accountCreationDate;
    private String adminNote;
    private String clientNote;
}