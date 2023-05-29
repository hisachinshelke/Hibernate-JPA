package com.shelke.sachin.cruddemo.dao;

import com.shelke.sachin.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO { // acts as a mediator between app and db

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);
}
