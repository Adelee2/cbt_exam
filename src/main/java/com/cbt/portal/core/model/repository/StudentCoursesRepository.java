package com.cbt.portal.core.model.repository;

import com.cbt.portal.core.model.StudentCourses;

import java.util.List;

public interface StudentCoursesRepository {
    List<StudentCourses> studentCourses(Integer studentId);
}
