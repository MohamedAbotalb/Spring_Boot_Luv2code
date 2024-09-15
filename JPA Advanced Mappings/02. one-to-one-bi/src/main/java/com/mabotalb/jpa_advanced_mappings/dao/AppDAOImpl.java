package com.mabotalb.jpa_advanced_mappings.dao;

import com.mabotalb.jpa_advanced_mappings.entity.Instructor;
import com.mabotalb.jpa_advanced_mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    // Define field for entity manager
    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {

        this.entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return this.entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {

        // Retrieve the instructor
        Instructor instructor = this.findInstructorById(id);

        this.entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public InstructorDetail findInstructorDetailById(Integer id) {
        return this.entityManager.find(InstructorDetail.class, id);
    }

    @Override
    public void deleteInstructorDetailById(Integer id) {
        // Retrieve the instructor detail
        InstructorDetail detail = this.findInstructorDetailById(id);

        // Remove the associated object reference
        // Break bi-directional link
        detail.getInstructor().setInstructorDetail(null);

        this.entityManager.remove(detail);
    }
}
