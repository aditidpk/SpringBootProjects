package com.demo.spring_boot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_boot_rest_api.bean.Student;

@RestController
public class StudentController {
    //http://localhost:8080/student
    
    @GetMapping("student")
    public Student getStudent(){
        return new Student(1, "Aditi", "Deepak");
    }
}
