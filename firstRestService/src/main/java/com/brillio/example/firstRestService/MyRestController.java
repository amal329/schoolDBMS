package com.brillio.example.firstRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@EnableCaching
@Component
public class MyRestController {
    @Autowired
    StudentDAO studentDAO;

    @Autowired
    Student1DAO student1DAO;

    @GetMapping("/")
    public String firstMethod(){
        return "Welcome to SpringBoot Application!!!";
    }

    @GetMapping("/student")
    public List<StudentDTO> getStudent(){
        return studentDAO.findAll();
    }

    @Cacheable(key = "#id",value = "student")
    @GetMapping("/student/{id}")
    public Optional<StudentDTO> getAnyStudent(@PathVariable String id){
        return studentDAO.findById(id);
    }

    @GetMapping("/student/fname/{name}")
    public Optional<StudentDTO> getAnyStudentByName(@PathVariable String name){
        return studentDAO.findByFname(name); //no method to search by name
    }

    @GetMapping("/student/fullname/{fname}/{lname}")
    public List<StudentDTO> getAnyStudentByName(@PathVariable String fname, @PathVariable String lname){
        return studentDAO.findAllByFnameAndLname(fname,lname); //no method to search by name
    }

    @GetMapping("/student/marks")
    public List<Student1DTO> getAllStudentsMarks()
    {
        return student1DAO.findAll();
    }

    @GetMapping("/student/join")
    public List<String> getAnyStudentByName(){
        return student1DAO.getJointDetails(); //no method to search by name
    }
}
