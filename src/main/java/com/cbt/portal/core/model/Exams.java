package com.cbt.portal.core.model;

import javax.persistence.*;

@Entity
@Table(name = "exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
