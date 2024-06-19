package com.demo.spring_boot_rest_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_boot_rest_api.bean.Student;

@RestController
public class StudentController {
    // http://localhost:8080/student

    @GetMapping("student")
    public Student getStudent() {
        return new Student(1, "Aditi", "Deepak");
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Doe"));
        students.add(new Student(3, "Mr", "Bean"));

        return students;
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
