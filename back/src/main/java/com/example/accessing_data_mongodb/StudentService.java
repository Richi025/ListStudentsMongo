package com.example.accessing_data_mongodb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public Student addStudent(String firstName, String lastName, String program, String mail, LocalDate birthdate) {
        Student student = new Student(firstName, lastName, program, mail, birthdate);
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
