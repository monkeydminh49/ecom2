package com.ecommerce.dao.impl;

import com.ecommerce.dao.FullNameDAO;
import com.ecommerce.model.FullName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FullNameDAOImpl implements FullNameDAO {

    private final List<FullName> fullNames = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void createFullName() {
        FullName fullName = new FullName();
        fullName.setFirstName("FirstName");
        fullName.setLastName("LastName");
        fullNames.add(fullName);
    }

    @Override
    public void updateFullName() {
        if (!fullNames.isEmpty()) {
            FullName fullName = fullNames.get(random.nextInt(fullNames.size()));
            fullName.setFirstName("UpdatedFirstName");
            fullName.setLastName("UpdatedLastName");
        }
    }

    @Override
    public void deleteFullName() {
        if (!fullNames.isEmpty()) {
            fullNames.remove(random.nextInt(fullNames.size()));
        }
    }

    @Override
    public FullName getFullName() {
        if (fullNames.isEmpty()) {
            return null;
        }
        return fullNames.get(random.nextInt(fullNames.size()));
    }

    @Override
    public List<FullName> getAllFullNames() {
        return new ArrayList<>(fullNames);
    }
}