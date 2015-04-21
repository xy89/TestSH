package com.idea.test.service;

import com.idea.test.entity.Account;

import java.util.List;

public interface AccountService {
    public void add(String account, String password, String category);
    public int update(String account, String oldPassword, String newPassword, String category);
    public int delete(String account,String password);
    public Account get(String account);
    public List<Account> getList(String category);
}
