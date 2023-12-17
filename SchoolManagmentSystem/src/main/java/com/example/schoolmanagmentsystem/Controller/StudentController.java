package com.example.schoolmanagmentsystem.Controller;

import com.example.schoolmanagmentsystem.Model.Student;
import com.example.schoolmanagmentsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService service;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(service.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        service.addStudent(student);
        return ResponseEntity.status(200).body("student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student){
        service.updateStudent(id,student);
        return ResponseEntity.status(200).body("student updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        service.deleteStudent(id);
        return ResponseEntity.status(200).body("Student is deleted");
    }

    @PutMapping("{student_id}/assign/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        service.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(200).body("Student assigned to course");
    }


    @PutMapping("/major/{student_id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer student_id,@PathVariable String major){
        service.changeMajor(student_id,major);
        return ResponseEntity.status(200).body("Major changed and all courses for student are deleted");
    }

    @GetMapping("/class/{course_id}")
    public ResponseEntity getCourseStudents(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(service.getClassStudents(course_id));
    }

}
