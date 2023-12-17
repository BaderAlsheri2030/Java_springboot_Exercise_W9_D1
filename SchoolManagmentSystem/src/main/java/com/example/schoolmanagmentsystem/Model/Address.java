package com.example.schoolmanagmentsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private Integer id;
    @NotNull(message = "Area cannot be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;
    @NotNull(message = "Street cannot be null")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;
    @NotNull(message = "building number cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}