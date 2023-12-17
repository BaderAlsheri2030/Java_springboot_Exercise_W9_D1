package com.example.schoolmanagmentsystem.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "teacher id cannot be null")
    private Integer teacher_id;
    @NotNull(message = "Street cannot be null")
    private String street;
    @NotNull(message = "building number cannot be null")
    private Integer building_number;
    @NotNull(message = "Area cannot be null")
    private String area;

}
