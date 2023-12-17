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
public class TeacherService {
    private final TeacherRepository repository;
    private final CourseRepository courseRepository;

    public List<Teacher> getTeachers(){
        return repository.findAll();
    }

    public void addTeacher(Teacher teacher){
        repository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1 = repository.findTeacherById(id);
        if (teacher1 == null){
            throw new ApiException("Invalid id");
        }
        teacher1.setAddress(teacher.getAddress());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setAge(teacher.getAge());
        repository.save(teacher1);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = repository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("Invalid id");
        }
        repository.delete(teacher);
    }

    public Teacher getTeacherDetails(Integer id){
        Teacher teacher = repository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("invalid Teacher id");
        }
        return teacher;
    }


    public void assignTeacherToCourse(Integer teacher_id, Integer course_id){
    Teacher teacher = repository.findTeacherById(teacher_id);
    if(teacher == null){
        throw new ApiException("Invalid Teacher id");
    }
        Course course = courseRepository.findCourseById(course_id);
    if (course == null){
        throw new ApiException("Invalid Course id");
    }
    course.setTeacher(teacher);
    courseRepository.save(course);
    }
}
