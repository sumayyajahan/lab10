package com.example.lab10new.service;

import com.example.lab10new.entity.Student;
import com.example.lab10new.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveRegister(Student student){
        return studentRepository.save(student);
    }
    public List<Student> saveRegisterStudents(List<Student> students){

        return studentRepository.saveAll(students);
    }
    public List<Student> showRegisteredStudents(){

        return studentRepository.findAll();
    }
    public Student getStudentById(int id){

        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()){
            return student.get();
        }
        return null;
    }
    public Student updateStudent(Student student, int id){
        Student existingStudent = studentRepository.findById(id).orElse(null);
        existingStudent.setStudentNumber(student.getStudentNumber());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setMiddleName(student.getMiddleName());
        existingStudent.setCgpa(student.getCgpa());
        existingStudent.setIsInternational(student.getIsInternational());

        return studentRepository.save(existingStudent);
    }
    public List<Student> search(String searchValue) {
        return studentRepository.searchStudentByStudentNumberOrFirstNameOrLastNameOrMiddleName(searchValue, searchValue, searchValue, searchValue);
    }

    public void deleteRegistration(int id){
        studentRepository.deleteById(id);
    }
}
