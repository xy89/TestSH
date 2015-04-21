package com.idea.test.dao;

import com.idea.test.entity.Account;

import java.util.List;

public interface AccountDao {
    public void saveOrUpdate(Account account);
    public void delete(Account account);
    public Account getAccount(String account);
    public List<Account> getAccountList(Account account);
}
