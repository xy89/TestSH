package com.idea.test.controller;

import com.idea.test.entity.Account;
import com.idea.test.service.AccountService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource(name = "accountService")
    private AccountService accountService;
    
    /*
     * http://localhost:8080/TestSH/account/get?acount=zaozigao@126.com
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Account getAccount(@RequestParam(value = "account") String account, HttpServletRequest request) {        
        Account tmpAccount = accountService.get(account);        
        return  tmpAccount;
    }
    /*
     * http://localhost:8080/TestSH/account/add?account=zaozigao@126.com&password=123&category=126
     */
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public @ResponseBody
    String addAccount(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password, 
            @RequestParam(value = "category", required = false, defaultValue = "default") String category){
        System.out.println("ok");
        accountService.add(account, password, category);
        return "Add success";     
    }
    
   
    @RequestMapping(value="/update", method = RequestMethod.GET)
    public @ResponseBody
    String updateAccount(@RequestParam(value = "account") String account, 
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword", required = false) String newPassword, 
            @RequestParam(value = "category", required = false) String category){
  
        int flag = accountService.update(account, oldPassword, newPassword, category);
        if(flag == 0) {
            return "Update success";     
        }else {
            return "account and password dismatch";
        }      
    }
    /* 
     * http://localhost:8080/TestSH/account/delete?acount=zaozigao@126.com&password=123
     */
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public @ResponseBody
    String deleteAccount(@RequestParam(value = "account") String account, 
            @RequestParam(value = "password") String password){
         int flag = accountService.delete(account, password);
        if(flag == 0) {
            return "Delete success";
        }else {
            return "account and password dismatch";
        }       
}
    
    /*
     * http://localhost:8080/TestSH/account/list?group=126
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAccountList(@RequestParam(value = "category") String category) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("accountList");
        List<Account> accountList = accountService.getList(category);
        mav.addObject("accountList", accountList);
        return mav;
    }
    
}


















