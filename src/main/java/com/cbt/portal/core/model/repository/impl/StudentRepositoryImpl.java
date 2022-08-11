package com.cbt.portal.core.model.repository.impl;

import com.cbt.portal.core.model.repository.StudentRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext(unitName = "PortalPU")
    private EntityManager em;
}
