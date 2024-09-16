package com.mabotalb.jpa_advanced_mappings.dao;

import com.mabotalb.jpa_advanced_mappings.entity.Course;
import com.mabotalb.jpa_advanced_mappings.entity.Instructor;
import com.mabotalb.jpa_advanced_mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        // Get all courses
        List<Course> courses = instructor.getCourses();

        // Remove the associated objects reference
        // Break bi-directional link
        for (Course course : courses) {
            course.setInstructor(null);
        }

        // Remove the instructor
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

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {
        
        TypedQuery<Course> query = this.entityManager.createQuery("FROM course WHERE instructor.id = :data ", Course.class);

        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {

        TypedQuery<Instructor> query = this.entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH i.instructorDetail " +
                        "JOIN FETCH i.courses WHERE i.id =:data", Instructor.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {

        this.entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {

        this.entityManager.merge(course);
    }

    @Override
    public Course findCourseById(Integer id) {

        return this.entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(Integer id) {

        // Retrieve the course
        Course course = this.findCourseById(id);

        this.entityManager.remove(course);
    }
}
