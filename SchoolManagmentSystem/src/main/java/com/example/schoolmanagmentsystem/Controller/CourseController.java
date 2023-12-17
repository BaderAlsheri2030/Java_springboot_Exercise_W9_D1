package com.example.schoolmanagmentsystem.Controller;

import com.example.schoolmanagmentsystem.Model.Course;
import com.example.schoolmanagmentsystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;


    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(service.getCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse( @RequestBody @Valid Course course){
        service.addCourse(course);
        return ResponseEntity.status(200).body("course added");
    }

    @PutMapping("/update")
    public ResponseEntity updateCourse( @RequestBody @Valid Course course){
        service.updatedCourse(course);
        return ResponseEntity.status(200).body("course updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        service.deleteCourse(id);
        return  ResponseEntity.status(200).body("Course deleted");
    }
    @GetMapping("/teacher/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
        return ResponseEntity.status(200).body(service.teacherOfCourse(id));
    }


}
