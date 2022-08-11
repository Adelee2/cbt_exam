package com.cbt.portal.core.model;

import javax.persistence.*;

@Entity
@Table(name = "student_exam_answers")
public class StudentExamAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
