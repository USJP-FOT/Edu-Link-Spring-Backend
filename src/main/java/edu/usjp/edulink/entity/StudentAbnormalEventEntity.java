package edu.usjp.edulink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@ToString
public class StudentAbnormalEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date date;
    private Time time;
}
