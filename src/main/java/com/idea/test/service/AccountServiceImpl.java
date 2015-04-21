package com.idea.test.service;

import com.idea.test.dao.AccountDao;
import com.idea.test.entity.Account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

import javax.annotation.Resource;

@Service("accountService")
@Transactional(propagation=Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
    
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    public void add(String account, String password, String category) {
       Account tmpAccount = new Account();
       tmpAccount.setAccount(account);
       tmpAccount.setPassword(password);
       tmpAccount.setCategory(category);
       accountDao.saveOrUpdate(tmpAccount);        
    }
    
    public int update(String account, String oldPassword, String newPassword, String category){
        Account tmpAccount= accountDao.getAccount(account);
        if(tmpAccount.getPassword().equals(oldPassword)){
            if(newPassword != null){
                tmpAccount.setPassword(newPassword);
            }
            if(category != null){
                tmpAccount.setCategory(category);
            }             
            accountDao.saveOrUpdate(tmpAccount);
            return 0;
        }else {
            return -1;
        }
    }

    public Account get(String account) {
        return accountDao.getAccount(account);
    }

    public List<Account> getList(String category) {
        Account tmpAccount = new Account();
        tmpAccount.setCategory(category);
        return accountDao.getAccountList(tmpAccount);
    }

    public int delete(String account,String password) {
        Account tmpAccount = accountDao.getAccount(account);
        if(tmpAccount.getPassword().equals(password)){
            accountDao.delete(tmpAccount);
            return 0;
        }else {
            return -1;
        }        
    }


}
