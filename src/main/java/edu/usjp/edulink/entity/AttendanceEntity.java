package edu.usjp.edulink.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;

    @Column(name = "fkStudentId", nullable = false)
    private Integer studentId; // foreign key from student


    private Date attendanceDate;
    private String attendanceTime;
    private Boolean attendanceStatus;
}
