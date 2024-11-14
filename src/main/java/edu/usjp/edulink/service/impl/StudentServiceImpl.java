package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.Student;
import edu.usjp.edulink.entity.StudentEntity;
import edu.usjp.edulink.repository.StudentRepository;
import edu.usjp.edulink.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(modelMapper.map(student, StudentEntity.class));
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(studentEntity -> {
            students.add(modelMapper.map(studentEntity, Student.class));
        });
        return students;
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
