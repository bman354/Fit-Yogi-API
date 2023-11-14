package com.fityogimom.entities;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prompt {
    private int id;
    private String prompt;
    private int clientId;
    private Date creationDate;
}
