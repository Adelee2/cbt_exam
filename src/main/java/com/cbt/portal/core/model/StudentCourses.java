package com.cbt.portal.core.model;

import javax.persistence.*;

@Entity
@Table(name = "student_courses")
public class StudentCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
