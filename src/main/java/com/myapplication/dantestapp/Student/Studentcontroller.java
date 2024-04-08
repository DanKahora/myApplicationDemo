package com.myapplication.dantestapp.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping

public class Studentcontroller {

    private final StudentService studentservice;
    private final StudentService studentService;

    @Autowired
    public Studentcontroller(StudentService studentservice, StudentService studentService) {
        this.studentservice = studentservice;
        this.studentService = studentService;
    }



    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        StudentService.addNewStudent(student);
    }

    @GetMapping
    public List<Student>getAllStudents() {
      return StudentService.getstudents();
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId) {
        StudentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam (required = false) String name,
        @RequestParam(required = false)  String email) {

        studentService.updateStudent(studentId, name, email);


    }


        }




