package com.example.SpringDemo.rest;

import com.example.SpringDemo.model.Student;
import com.example.SpringDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:8000")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<List<Student>>(students, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = service.getStudent(id);
        return new ResponseEntity<Student>(student, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student updated = service.createStudent(student);
        return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updated = service.updateStudent(student);
        return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") Long id) {
        service.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
