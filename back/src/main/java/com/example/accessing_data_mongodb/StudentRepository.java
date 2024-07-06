package com.example.accessing_data_mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Interface extending MongoRepository for CRUD operations and custom queries against the MongoDB database.
 */
public interface StudentRepository extends MongoRepository<Student, String> {


  public Student findByFirstName(String firstName);

  public List<Student> findByLastName(String lastName);

    @Query("{name:'?0'}")
    Student findItemByName(String name);
    
    @Query(value="{program:'?0'}", fields="{'firstName' : 1, 'mail' : 1}")
    List<Student> findAll(String program);
    
    public long count();

}