package com.example.schoolmanagmentsystem.Service;

import com.example.schoolmanagmentsystem.Api.ApiException;
import com.example.schoolmanagmentsystem.Model.Course;
import com.example.schoolmanagmentsystem.Model.Teacher;
import com.example.schoolmanagmentsystem.Repository.CourseRepository;
import com.example.schoolmanagmentsystem.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final TeacherRepository teacherRepository;


    public List<Course> getCourses(){
    return repository.findAll();
    }

    public void addCourse(Course course){
    repository.save(course);
    }

    public void updatedCourse(Course course){
        Course course1  = repository.findCourseById(course.getId());
        if (course1 == null){
            throw new ApiException("Invalid course id");
        }
        course1.setName(course.getName());
        course1.setTeacher(course.getTeacher());
        repository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course course = repository.findCourseById(id);
        if (course == null){
            throw new ApiException("Invalid course id");
        }
        repository.delete(course);
    }

    public String teacherOfCourse(Integer id){
        Course course = repository.findCourseById(id);
        if (course == null){
            throw new ApiException("Invalid Course id");
        }
        Teacher teacher = teacherRepository.findTeacherById(course.getTeacher().getId());
        if (teacher == null){
            throw new ApiException("There is no teacher for this course");
        }
        return teacher.getName();
    }
}
