package com.university.demo.dao;

import com.university.demo.model.Student;
import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository <Student, Long>{
    Collection findByEmail(String email);
}
