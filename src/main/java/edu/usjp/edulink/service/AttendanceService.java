package edu.usjp.edulink.service;

import edu.usjp.edulink.dto.Attendance;

import java.util.List;

public interface AttendanceService {
    void markAttendant(Attendance attendance);

    List<Attendance> getAll();
}
