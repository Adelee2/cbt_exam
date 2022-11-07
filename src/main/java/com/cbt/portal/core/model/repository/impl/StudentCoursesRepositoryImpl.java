package com.cbt.portal.core.model.repository.impl;

import com.cbt.portal.core.model.StudentCourses;
import com.cbt.portal.core.model.repository.StudentCoursesRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StudentCoursesRepositoryImpl implements StudentCoursesRepository {
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
    public List<StudentCourses> studentCourses(Integer studentId) {
        return null;
    }
}
