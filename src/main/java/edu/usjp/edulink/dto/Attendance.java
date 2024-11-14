package edu.usjp.edulink.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    private Integer studentId; // foreign key from student
    private String studentName;
    private Date attendanceDate;
    private String attendanceTime;
    private Boolean attendanceStatus;
}
