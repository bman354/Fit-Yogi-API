package com.fityogimom.entities;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Video {
    private int id;
    private int clientId;
    private String videoLink;
}
