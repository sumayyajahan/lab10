package com.example.lab10new.controller;

import com.example.lab10new.entity.Student;
import com.example.lab10new.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public String addForm(Model model){

        Student student = new Student();
        model.addAttribute("student", student);

        return "add";
    }

    @PostMapping("/submitRegister")
    public String saveRegisterStudent(@ModelAttribute Student student){

        studentService.saveRegister(student);

        return "redirect:/show";

    }
    @GetMapping("/show")
    public String showStudents(Model model){

        List<Student> students = studentService.showRegisteredStudents();
        model.addAttribute("students", students);


        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id, HttpSession httpSession){

        studentService.deleteRegistration(id);
        httpSession.setAttribute("msg","Data is deleted Successfully.");
        return "redirect:/show";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
         Student student = studentService.getStudentById(id);

         model.addAttribute("student",student);

         return "edit";
    }
    @PostMapping("/updateRegister")
    public String update(@ModelAttribute Student student, HttpSession httpSession){
        studentService.updateStudent(student, student.getStudentId());

        httpSession.setAttribute("msg", "Data is updated Successfully!");

        return "redirect:/show";

    }
    @GetMapping(value = {"/search"})
    public String search(@RequestParam String searchValue, Model model) {
        List<Student> students = null;
        if (searchValue.isBlank()) {
            students = studentService.showRegisteredStudents();
        } else {
            students = studentService.search(searchValue);
        }

        model.addAttribute("students", students);
        model.addAttribute("searchValue", searchValue);
        return "index";
    }


}
