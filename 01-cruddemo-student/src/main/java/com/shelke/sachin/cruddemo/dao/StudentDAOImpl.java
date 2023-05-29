package com.shelke.sachin.cruddemo.dao;

import com.shelke.sachin.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //support for Component scanning and exception translation
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired //optional if one constructor
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //save method implementation
    @Override
    @Transactional //for update or modification to db
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); //entityClass and primary key
    }

    @Override
    public List<Student> findAll() {
        //create query
        //TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        //take the entity class/field names and not database table names
        //TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName desc", Student.class);


        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

        //return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create Query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "From Student WHERE lastName=:theData",  // : is considered as placeholder
                Student.class);

        //set query Parameters
        theQuery.setParameter("theData", theLastName);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional //as update functionality
    public void update(Student theStudent) {
        entityManager.merge(theStudent); //update on student
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(theStudent);
    }
}
