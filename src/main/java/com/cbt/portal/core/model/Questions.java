package com.cbt.portal.core.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
