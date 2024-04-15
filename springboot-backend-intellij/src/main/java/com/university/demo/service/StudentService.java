package com.university.demo.service;

import com.university.demo.dto.StudentDto;
import com.university.demo.model.Student;

import java.util.List;

public interface StudentService {
    //CRUD
    Student save(StudentDto student);
    List<StudentDto> list();
    StudentDto findById(Long id);
    void remove(Long id);
}
