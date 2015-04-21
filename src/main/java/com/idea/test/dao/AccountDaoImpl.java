package com.idea.test.dao;


import com.idea.test.entity.Account;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.annotation.Resource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    

    //Query query = session.createSQLQuery("INSERT INTO account_tab (account, password, group) VALUES (?,?,?)");
    //query.setParameter(0, account.getAccount());
    //query.setParameter(1, account.getPassword());
    //query.setParameter(2, account.getGroup());
    //return query.executeUpdate(); 
 
    
    public void saveOrUpdate(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(account);
    }    

    public void delete(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(account);
        
    }    

    public Account getAccount(String account) {
        Session session = sessionFactory.getCurrentSession();
        Account result = (Account)session.get(Account.class, account);
        return result;
    }

    public List<Account> getAccountList(Account account) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createQuery("FROM Account where category = :category");
       query.setParameter("category", account.getCategory());
       List<Account> list = query.list();
       return list;
    }
    

}
