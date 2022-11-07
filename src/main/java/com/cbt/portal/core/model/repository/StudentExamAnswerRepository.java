package com.cbt.portal.core.model.repository;

import com.cbt.portal.core.model.StudentExamAnswer;

import java.util.List;

public interface StudentExamAnswerRepository {
    List<StudentExamAnswer> studentAnswers(Integer studentId);
}
