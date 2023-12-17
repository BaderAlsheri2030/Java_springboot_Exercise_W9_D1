package com.example.schoolmanagmentsystem.Controller;

import com.example.schoolmanagmentsystem.DTO.AddressDTO;
import com.example.schoolmanagmentsystem.Model.Address;
import com.example.schoolmanagmentsystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        service.addAddress(addressDTO);
        return ResponseEntity.status(200).body("Address added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        service.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("address updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        service.deleteAddress(id);
        return ResponseEntity.status(200).body("address deleted");
    }

    @GetMapping("/details/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id){

        return ResponseEntity.status(200).body(service.getTeacherDetails(id));
    }
}
