package com.idea.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="account_tab")
public class Account implements Serializable { 

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="account")
    private String account;
    
    @Column(name="password", nullable=false)
    private String password;
    
    @Column(name="category", nullable=true)
    private String category;
    
    


    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Account() {}
    
    public Account(String account, String password){
        this.account = account;
        this.password = password;
    }
    
    public String toString() {
        return "account = " + this.account + " password= " + this.password + " category= " + this.category; 
    }

}
