package com.university.demo.model;

import lombok.Data;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Course {
    @Id           //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "courses")   //courses is the other side collection
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Constructors, getters, setters...
}
