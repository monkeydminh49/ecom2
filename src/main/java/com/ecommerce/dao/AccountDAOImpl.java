package com.ecommerce.dao;

import com.ecommerce.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    public void createAccount(Account account) {}
    public void updateAccount(Account account) {}
    public void deleteAccount(int id) {}
    public Account getAccountById(int id) { return null; }
}