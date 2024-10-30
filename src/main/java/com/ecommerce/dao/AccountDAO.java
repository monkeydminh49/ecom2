package com.ecommerce.dao;

import com.ecommerce.model.Account;

public interface AccountDAO {
    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(int id);
    Account getAccountById(int id);
}