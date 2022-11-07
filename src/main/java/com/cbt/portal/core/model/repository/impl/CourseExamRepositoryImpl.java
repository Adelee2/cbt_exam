package com.cbt.portal.core.model.repository.impl;

import com.cbt.portal.core.model.CourseExam;
import com.cbt.portal.core.model.repository.CourseExamRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CourseExamRepositoryImpl implements CourseExamRepository {
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
    public List<CourseExam> courseExams(Integer courseId) {
        return null;
    }
}
