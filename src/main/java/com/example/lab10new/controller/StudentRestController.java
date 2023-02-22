package com.example.lab10new.controller;


import com.example.lab10new.entity.Student;
import com.example.lab10new.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {


    @Autowired
    private StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<Student>> allStudents(){

        List<Student> students = studentService.showRegisteredStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){

        return studentService.saveRegister(student);
    }
    @PostMapping("/saveStudents")
    public List<Student> saveStudents(@RequestBody List<Student> students){

        return studentService.saveRegisterStudents(students);
    }
    @GetMapping("/getOneStudent/{id}")
    public Student getOneStudent(@PathVariable int id){
       return studentService.getStudentById(id);
    }
    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudent(student,id);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public String delete(@PathVariable int id){
        studentService.deleteRegistration(id);
        return "Student is deleted";
    }

}
