package edu.usjp.edulink.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String phoneNumber;
    String academicYear;
}
