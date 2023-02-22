package com.example.lab10new.repository;

import com.example.lab10new.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> searchStudentByStudentNumberOrFirstNameOrLastNameOrMiddleName(String searchValue1, String searchValue2, String searchValue3, String searchValue4);
}
