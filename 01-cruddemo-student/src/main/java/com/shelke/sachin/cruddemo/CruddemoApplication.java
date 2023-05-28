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
            // createStudent(studentDAO);

            createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        //create multiple students
        System.out.println("Creating the student object>>>>");
        Student tempStudent1 = new Student("Rahul", "Dravid", "rahul@rahul.rahul");
        Student tempStudent2 = new Student("John", "Foo", "john@john.john");
        Student tempStudent3 = new Student("Mary", "Fnn", "mary@mary.mary");
        Student tempStudent4 = new Student("Jack", "Fpp", "jack@jack.jack");

        //save the students
        System.out.println("Saving students>>>>");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        studentDAO.save(tempStudent4);

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
