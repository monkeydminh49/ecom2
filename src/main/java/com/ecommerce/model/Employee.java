package com.ecommerce.model;

import javax.management.relation.Role;

public abstract class Employee {
    private int id;
    private FullName fullName;
    private Address address;
    private String email;
    private String phoneNumber;
    private Role role;
}
