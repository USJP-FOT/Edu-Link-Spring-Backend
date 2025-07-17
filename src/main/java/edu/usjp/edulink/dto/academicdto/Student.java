package edu.usjp.edulink.dto.academicdto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String academicYear;
    private String email;
}
