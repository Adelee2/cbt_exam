package com.cbt.portal.core.model;

import javax.persistence.*;

@Entity
@Table(name = "course_exams")
public class CourseExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
