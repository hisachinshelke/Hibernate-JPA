package com.shelke.sachin.cruddemo.dao;

import com.shelke.sachin.cruddemo.entity.Student;

public interface StudentDAO { // acts as a mediator between app and db

    void save(Student theStudent);

    Student findById(Integer id);

}
