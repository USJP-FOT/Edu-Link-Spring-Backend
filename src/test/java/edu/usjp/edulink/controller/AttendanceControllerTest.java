package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Attendance;
import edu.usjp.edulink.service.AttendanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AttendanceController.class)
public class AttendanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AttendanceService attendanceService;

    private Attendance attendance;

    @BeforeEach
    public void setUp() {
        attendance = new Attendance();
        attendance.setStudentId(1);
        attendance.setStudentName("John Doe");
        attendance.setAttendanceDate(new Date());
        attendance.setAttendanceTime("10:00 AM");
        attendance.setAttendanceStatus(true);
    }

    @Test
    public void testMarkAttendant() throws Exception {
        Mockito.doNothing().when(attendanceService).markAttendant(any(Attendance.class));

        mockMvc.perform(post("/attendance/mark")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"studentId\":1,\"studentName\":\"John Doe\",\"attendanceDate\":\"2024-12-02T00:00:00.000+00:00\",\"attendanceTime\":\"10:00 AM\",\"attendanceStatus\":true}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAttendance() throws Exception {
        Mockito.when(attendanceService.getAll()).thenReturn(Arrays.asList(attendance));

        mockMvc.perform(get("/attendance/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].studentId").value(1))
                .andExpect(jsonPath("$[0].studentName").value("John Doe"))
                .andExpect(jsonPath("$[0].attendanceDate").exists())
                .andExpect(jsonPath("$[0].attendanceTime").value("10:00 AM"))
                .andExpect(jsonPath("$[0].attendanceStatus").value(true));
    }
}
