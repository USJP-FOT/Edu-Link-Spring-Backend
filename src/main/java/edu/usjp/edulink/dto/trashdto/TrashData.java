package edu.usjp.edulink.dto.trashdto;


import lombok.*;
import java.sql.Timestamp;


@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrashData {
    private Long id;
    private String image;
    private String actualValue;
    private String predictedValue;
    private String confidence;
    private Timestamp timestamp;
}
