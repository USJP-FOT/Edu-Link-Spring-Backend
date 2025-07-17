package edu.usjp.edulink.dto.academicdto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomStudentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId; // fk student id
    private Integer classId;   // fk classroom id

    private Boolean handRice;
    private Boolean mobilePhoneUse;
    private Boolean talkWithOthers;
    private Boolean sleep;
}
