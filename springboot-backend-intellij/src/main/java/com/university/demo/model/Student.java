package com.university.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id   //PK
    @GeneratedValue         //Sequence
    private Long id;
    @Column(name = "full_name")
    @NonNull
    private String name;
    @Email(message = "Invalid email address!!!")
    private String email;
    private Date birthDate;
    @ManyToMany
    @JoinTable(   //breaking table of the many-to-many
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();
}
