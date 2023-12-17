package com.example.schoolmanagmentsystem.Controller;

import com.example.schoolmanagmentsystem.Model.Teacher;
import com.example.schoolmanagmentsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService service;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(service.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher( @RequestBody @Valid Teacher teacher){
        service.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@Valid @RequestBody Teacher teacher){
        service.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        service.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    @GetMapping("/details/{id}")
    public ResponseEntity teacherDetails(@PathVariable Integer id){
    return ResponseEntity.status(200).body(service.getTeacherDetails(id));
    }

    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignToCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
    service.assignTeacherToCourse(teacher_id,course_id);
    return ResponseEntity.status(200).body("Teacher assigned to course");
    }

}
