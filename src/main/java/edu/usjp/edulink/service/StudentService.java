package edu.usjp.edulink.service;

import edu.usjp.edulink.dto.academicdto.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> getAllStudent();

    void deleteById(Integer id);

    Student findById(Integer id);
}
