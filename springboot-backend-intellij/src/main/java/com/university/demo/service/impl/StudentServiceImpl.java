package com.university.demo.service.impl;

import com.university.demo.dao.StudentDao;
import com.university.demo.dto.StudentDto;
import com.university.demo.model.Course;
import com.university.demo.model.Student;
import com.university.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;
    @Override
    public Student save(StudentDto student) {
        log.info("saving new student into the db.");
        //DTO --> ENTITY
        Student s = new Student();
        s.setId(student.getId());
        s.setName(student.getFName() + " " + student.getLName());
        s.setEmail(student.getEmail());
        Course add = new Course();
        add.setName(s.getName());
        return dao.save(s);
    }

    @Override
    public List<StudentDto> list() {
        List<StudentDto> lst = new ArrayList<>();
//        for(Student s:dao.findAll()){
//            lst.add(new )
//        }
        dao.findAll().stream().forEach(args ->{
            lst.add(
                    StudentDto.builder()
                            .email(args.getEmail())
                            .fName(args.getName().split(" ")[0])
                            .lName(args.getName().split(" ")[1])
                            .build()
            );
        });
        return lst;
    }

    @Override
    public StudentDto findById(Long id) {
        Optional<Student> opt =  dao.findById(id);
        if (opt != null) {
            Student entity = opt.get();
            StudentDto student = StudentDto.builder()
                    .email(entity.getEmail())
                    .id(entity.getId())
                    .fName(entity.getName().split(" ")[0])
                    .lName(entity.getName().split(" ")[1])
                    .build();
            return student;
        }
        else return null;
    }

    @Override
    public void remove(Long id) {
        dao.deleteById(id);
    }
}
