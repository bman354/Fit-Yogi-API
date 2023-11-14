package com.fityogimom.entities;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Program {
    private int id;
    private int clientId;
    private Date startDate;
    private Date endDate;
    private Date lastPromptSentDate;
    private Date lastVideoSentDate;
    private boolean isPaid;
    private ProgramType programType;
}
