package com.ecommerce.dao.impl;

import com.ecommerce.dao.AccountDAO;
import com.ecommerce.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountDAOImpl implements AccountDAO {

    private final List<Account> accounts = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void createAccount() {
        Account account = new Account();
        account.setId(random.nextInt(1000));
        account.setBalance(random.nextDouble() * 10000);
        accounts.add(account);
    }

    @Override
    public void updateAccount() {
        if (!accounts.isEmpty()) {
            Account account = accounts.get(random.nextInt(accounts.size()));
            account.setBalance(random.nextDouble() * 10000);
        }
    }

    @Override
    public void deleteAccount() {
        if (!accounts.isEmpty()) {
            accounts.remove(random.nextInt(accounts.size()));
        }
    }

    @Override
    public Account getAccount() {
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts.get(random.nextInt(accounts.size()));
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}