package com.mabotalb.jpa_advanced_mappings.dao;

import com.mabotalb.jpa_advanced_mappings.entity.Instructor;
import com.mabotalb.jpa_advanced_mappings.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(Integer id);

    void deleteInstructorById(Integer id);

    InstructorDetail findInstructorDetailById(Integer id);

    void deleteInstructorDetailById(Integer id);
}
