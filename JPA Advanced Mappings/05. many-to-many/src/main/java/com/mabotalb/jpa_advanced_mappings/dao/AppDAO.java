package com.mabotalb.jpa_advanced_mappings.dao;

import com.mabotalb.jpa_advanced_mappings.entity.Course;
import com.mabotalb.jpa_advanced_mappings.entity.Instructor;
import com.mabotalb.jpa_advanced_mappings.entity.InstructorDetail;
import com.mabotalb.jpa_advanced_mappings.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(Integer id);

    void deleteInstructorById(Integer id);

    InstructorDetail findInstructorDetailById(Integer id);

    void deleteInstructorDetailById(Integer id);

    List<Course> findCoursesByInstructorId(Integer id);

    Instructor findInstructorByIdJoinFetch(Integer id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(Integer id);

    void deleteCourseById(Integer id);

    void save(Course course);

    Course findCourseWithReviewsByCourseId(Integer id);

    Course findCourseWithStudentsByCourseId(Integer id);

    Student findStudentWithCoursesByStudentId(Integer id);

    void update(Student student);

    void deleteStudentById(Integer id);
}
