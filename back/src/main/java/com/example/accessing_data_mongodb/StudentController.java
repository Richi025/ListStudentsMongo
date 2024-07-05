package com.example.accessing_data_mongodb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/newStudents")
    public ResponseEntity<String> newStudents(@RequestBody Student student) {
        try {
            studentService.addStudent(student.getFirstName(), student.getLastName(), student.getProgram(), student.getMail(), student.getBirthdate());
            return ResponseEntity.ok("Student created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while creating the student.");
        }
    }
}
