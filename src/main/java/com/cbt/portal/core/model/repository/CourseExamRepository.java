package com.cbt.portal.core.model.repository;

import com.cbt.portal.core.model.CourseExam;

import java.util.List;

public interface CourseExamRepository {
    List<CourseExam> courseExams(Integer courseId);
}
