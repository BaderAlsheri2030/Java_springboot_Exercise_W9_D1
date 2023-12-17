package com.example.schoolmanagmentsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "name cannot be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotNull(message = "age cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotNull(message = "email cannot be null")
    @Email(message = "must be a valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotNull(message = "salary cannot be null")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;



}