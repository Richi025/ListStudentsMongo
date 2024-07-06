package com.example.accessing_data_mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

/**
 * A REST controller handling HTTP requests related to students, including endpoints for retrieving all students and adding new students.
 */
@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * Endpoint to retrieve all students.
     *
     * @return a list of all students
     */
    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Endpoint to create a new student.
     *
     * @param student the student object to be created
     * @return a response entity with the result of the operation
     */
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
