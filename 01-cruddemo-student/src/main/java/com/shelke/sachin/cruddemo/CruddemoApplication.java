package com.shelke.sachin.cruddemo;

import com.shelke.sachin.cruddemo.dao.StudentDAO;
import com.shelke.sachin.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) { //From Sp. Boot Framework - executed after spring beans are loaded
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        //create the student object
        System.out.println("Creating the student object>>>>");
        Student tempStudent = new Student("Sachin", "Shelke", "sachin@sachin.sachin");

        //save the student object
        System.out.println("Saving student in DB");
        studentDAO.save(tempStudent);

        //display id of saved student
        System.out.println("Saved student: Generated Id: " + tempStudent.getId());
    }
}
