package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Student;
import edu.usjp.edulink.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        log.info("add student {}", student);
        studentService.addStudent(student);
    }
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }
    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam(value = "id") Integer id) {
        studentService.deleteById(id);
    }
}
