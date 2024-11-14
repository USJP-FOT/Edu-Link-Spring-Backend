package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Student;
import edu.usjp.edulink.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        System.out.println(student);
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
