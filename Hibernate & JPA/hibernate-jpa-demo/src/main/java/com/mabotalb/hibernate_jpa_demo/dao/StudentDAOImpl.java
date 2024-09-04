package com.mabotalb.hibernate_jpa_demo.dao;

import com.mabotalb.hibernate_jpa_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for EntityManager
    private final EntityManager entityManager;

    // Inject EntityManager through constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method to persist the student entity
    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    // Implement find method to get the student by the id
    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    // Implement findAll method to get all students
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student order by firstName", Student.class);
        return query.getResultList();
    }

    // Implement findByLastName method to get all students that have the same last name
    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);

        query.setParameter("data", lastName);

        return query.getResultList();
    }

    // Implement update method to update the student data
    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    // Implement delete method to delete the student data using the id
    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = this.entityManager.find(Student.class, id);
        this.entityManager.remove(student);
    }

    // Implement deleteAll method to delete all students
    @Override
    @Transactional
    public int deleteAll() {
        return this.entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
