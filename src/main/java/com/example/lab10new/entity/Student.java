package com.example.lab10new.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @NotBlank(message = "Student Number cannot be null or empty space or blank")
    @Column(nullable = false)
    private String studentNumber;
    @NotBlank(message = "First Name cannot be null or empty space or blank")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "Last Name cannot be null or empty space or blank")
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = true)
    private String middleName;

    @Column(nullable = true)
    private Float cgpa;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    //@NotBlank(message = "International Student cannot be null or empty space or blank")
    private Boolean isInternational;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", cgpa=" + cgpa +
                ", enrollmentDate=" + enrollmentDate +
                ", isInternational='" + isInternational + '\'' +
                '}';
    }



}
