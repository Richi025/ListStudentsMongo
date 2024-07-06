package com.example.accessing_data_mongodb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Contains business logic related to students, encapsulating CRUD operations defined in StudentRepository.
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    /**
     * Adds a new student to the database.
     *
     * @param firstName the first name of the student
     * @param lastName the last name of the student
     * @param program the program the student is enrolled in
     * @param mail the email address of the student
     * @param birthdate the birthdate of the student
     * @return the saved student object
     */
    public Student addStudent(String firstName, String lastName, String program, String mail, LocalDate birthdate) {
        Student student = new Student(firstName, lastName, program, mail, birthdate);
        return studentRepository.save(student);
    }

    /**
     * Retrieves all students from the database.
     *
     * @return a list of all students
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
