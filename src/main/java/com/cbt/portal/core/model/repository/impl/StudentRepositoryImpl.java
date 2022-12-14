package com.cbt.portal.core.model.repository.impl;

import com.cbt.portal.core.model.Students;
import com.cbt.portal.core.model.repository.StudentRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext(unitName = "PortalPU")
    private EntityManager em;

    private void persist (Object object)
    {
        em.persist (object);
    }
    private void merge (Object object)
    {
        em.merge (object);
    }

    @Override
    public List<Students> login(String matricNum, String password) {
        return null;
    }
}
