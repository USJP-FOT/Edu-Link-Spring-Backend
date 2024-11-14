package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Attendance;
import edu.usjp.edulink.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/mark")
    public void markAttendant(@RequestBody Attendance attendance) {
        attendanceService.markAttendant(attendance);
    }
    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAll();
    }

}
