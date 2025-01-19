package edu.usjp.edulink.dto;

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
