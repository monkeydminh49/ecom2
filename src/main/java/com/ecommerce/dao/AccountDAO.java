package com.ecommerce.dao;

import com.ecommerce.model.Account;

import java.util.List;

public interface AccountDAO {
    void createAccount();
    void updateAccount();
    void deleteAccount();
    Account getAccount();

    List<Account> getAllAccounts();
}
