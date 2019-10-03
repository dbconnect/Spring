package com.example.SpringDemo.service;

import com.example.SpringDemo.exception.ResourceNotFound;
import com.example.SpringDemo.model.Student;
import com.example.SpringDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudent(Long id) throws RuntimeException {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new ResourceNotFound("Record Not Found");
    }

    public Student createStudent(Student student) {
        student = repository.save(student);
        return student;
    }

    public Student updateStudent(Student student) {
        Optional<Student> optionalStudent = repository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            Student newStudent = optionalStudent.get();
            newStudent.setName(student.getName());
            newStudent = repository.save(newStudent);
            return newStudent;
        } else {
            throw new ResourceNotFound("Record Not Found");
        }
    }

    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }

}
