package com.ecommerce.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    public List<String> manageDepartments() {
        List<String> departments = new ArrayList<>();
        // logic to get departments
        departments.add("Department 1");
        departments.add("Department 2");
        return departments;
    }

    public List<Task> manageTasks() {
        List<Task> tasks = new ArrayList<>();
        // logic to get tasks
        return tasks;
    }
}
