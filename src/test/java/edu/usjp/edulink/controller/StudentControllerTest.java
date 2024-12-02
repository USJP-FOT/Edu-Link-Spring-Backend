package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Student;
import edu.usjp.edulink.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setId(1);
        student.setName("John Doe");
    }

    @Test
    public void testAddStudent() throws Exception {
        Mockito.doNothing().when(studentService).addStudent(any(Student.class));

        mockMvc.perform(post("/student/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John Doe\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllStudents() throws Exception {
        Mockito.when(studentService.getAllStudent()).thenReturn(Arrays.asList(student));

        mockMvc.perform(get("/student/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Mockito.doNothing().when(studentService).deleteById(1);

        mockMvc.perform(delete("/student/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }
}
