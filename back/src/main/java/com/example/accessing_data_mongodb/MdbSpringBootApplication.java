package com.example.accessing_data_mongodb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

  @Autowired
  private StudentRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(MdbSpringBootApplication.class, args);
  }
  
  
  @Override
  public void run(String... args) throws Exception {

    System.out.println("Data creation started...");
    repository.save(new Student("Alice", "Smith", "sistemas", "alice@student.com", LocalDate.of(1998, 5, 15)));
    repository.save(new Student("Richi", "Perez", "civil", "Richi@student.com", LocalDate.of(1998, 5, 15)));
    System.out.println("Data creation complete...");
  }
}
    /* 
    // READ
    // 1. Show all the data
    repository.findAll().forEach(item -> System.out.println(getItemDetails(item)));

    System.out.println("For...Program");
    List<Student> list = repository.findAll("civil");

    list.forEach(studemt -> System.out.println(getItemDetails(studemt)));

    long count = repository.count();
    System.out.println("Number of documents in the collection: " + count);
  }
   
  // Print details in readable form

  public String getItemDetails(Student item) {

    System.out.println(
        "Student Name: " + item.getFirstName() +
            ", \nStudent Name:: " + item.getLastName() +
            ", \nStudent Program: " + item.getProgram() +
            ", \nStudent Email: " + item.getMail() +
            ", \nStudent Age: " + item.getAge());

    return "";
  }*
  */


