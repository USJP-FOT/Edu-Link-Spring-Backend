package edu.usjp.edulink.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EditRequest {
    private Long id;
    private String image;
    private String actualValue;
    private String predictedValue;
    private String confidence;
    private Timestamp timestamp;
}
