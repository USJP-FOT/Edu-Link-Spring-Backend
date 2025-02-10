package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Attendance;
import edu.usjp.edulink.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/attendance")
@CrossOrigin
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @DeleteMapping("/delete")
    public void deleteAttendance(@RequestParam(value = "id") Integer id){
        attendanceService.delete(id);
        log.info(id.toString());

    }

    @PostMapping("/mark")
    public void markAttendant(@RequestBody Attendance attendance) {
        log.info("Mark Attendance {} ",attendance.toString());
        attendanceService.markAttendant(attendance);


    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        log.info("Send all attendance");
        return attendanceService.getAll();
    }
}
