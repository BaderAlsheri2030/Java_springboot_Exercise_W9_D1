package com.example.schoolmanagmentsystem.Service;

import com.example.schoolmanagmentsystem.Api.ApiException;
import com.example.schoolmanagmentsystem.DTO.AddressDTO;
import com.example.schoolmanagmentsystem.Model.Address;
import com.example.schoolmanagmentsystem.Model.Teacher;
import com.example.schoolmanagmentsystem.Repository.AddressRepository;
import com.example.schoolmanagmentsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;


    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }


    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null){
            throw new ApiException("invalid id");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuilding_number(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null){
            throw new ApiException("invalid id");
        }
        Address address = addressRepository.findAddressById(teacher.getId());
        if (address == null){
            throw new ApiException("Address doesn't exist for teacher");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuilding_number());
        address.setTeacher(teacher);
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("invalid id");
        }
        Address address = addressRepository.findAddressById(teacher.getId());
        if (address == null){
            throw new ApiException("Address doesn't exist");
        }
        teacher.setAddress(null);
        addressRepository.delete(address);
    }

    public Address getTeacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("Invalid teacher id");
        }
        Address address = addressRepository.findAddressById(teacher.getId());
        if (address == null){
            throw new ApiException("Address doesn't exist");
        }
        return address;
    }
}
