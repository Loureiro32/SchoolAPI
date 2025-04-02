package com.mindera.school.entity;

import jakarta.persistence.*;

import java.time.Year;

@Entity(name = "Grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grade_name")
    private String gradeName;

    @Column(name = "enrollment_year")
    private Year year;


}
