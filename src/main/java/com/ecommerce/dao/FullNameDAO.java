package com.ecommerce.dao;

import com.ecommerce.model.FullName;

import java.util.List;

public interface FullNameDAO {
    void createFullName();
    void updateFullName();
    void deleteFullName();
    FullName getFullName();

    List<FullName> getAllFullNames();
}
