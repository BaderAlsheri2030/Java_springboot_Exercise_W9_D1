package com.example.schoolmanagmentsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue()
    private Integer id;
    @NotNull(message = "name cannot be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "age cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotNull(message = "major cannot be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;


    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
