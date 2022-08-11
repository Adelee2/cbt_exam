package com.cbt.portal.core.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
