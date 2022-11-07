package com.cbt.portal.core.model.repository.impl;

import com.cbt.portal.core.model.StudentExamAnswer;
import com.cbt.portal.core.model.repository.StudentExamAnswerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StudentExamAnswerRepositoryImpl implements StudentExamAnswerRepository {
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
    public List<StudentExamAnswer> studentAnswers(Integer studentId) {
        return null;
    }
}
