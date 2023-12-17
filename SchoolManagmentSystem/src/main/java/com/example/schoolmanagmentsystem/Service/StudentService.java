package com.example.schoolmanagmentsystem.Service;

import com.example.schoolmanagmentsystem.Api.ApiException;
import com.example.schoolmanagmentsystem.Model.Course;
import com.example.schoolmanagmentsystem.Model.Student;
import com.example.schoolmanagmentsystem.Repository.CourseRepository;
import com.example.schoolmanagmentsystem.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null){
            throw new ApiException("invalid student id");
        }
        student1.setAge(student.getAge());
        student1.setCourses(student.getCourses());
        student1.setMajor(student.getMajor());
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if (student == null){
            throw new ApiException("invalid student id");
        }
        studentRepository.delete(student);
    }

    public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if (course == null || student == null){
            throw new ApiException("invalid course or student id");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer id, String newMajor){
        Student student = studentRepository.findStudentById(id);

        if (student == null){
            throw new ApiException("invalid student id");
        }
        for(Course course1: courseRepository.findAll()){
            course1.getStudents().remove(student);
        }
        student.setCourses(null);
        student.setMajor(newMajor);
        studentRepository.save(student);
    }


    public Set<Student> getClassStudents(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if (course == null){
            throw new ApiException("invalid Course id");
        }
        return course.getStudents();
    }
}
