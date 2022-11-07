package com.cbt.portal.core.model.repository;


import com.cbt.portal.core.model.Students;

import java.util.List;

public interface StudentRepository {
    List<Students> login(String matricNum, String password);

}
