package com.mabotalb.jpa_advanced_mappings.dao;

import com.mabotalb.jpa_advanced_mappings.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(Integer id);

    void deleteInstructorById(Integer id);
}
