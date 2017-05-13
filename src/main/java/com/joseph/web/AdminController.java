package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by joseph on 5/13/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/adminhome")
public class AdminController {
    private HttpSession session;
    private AccountService accountService;
    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String defaultHandler(){
        if(session.getAttribute("account")==null){
            return "redirect:/signin";
        }
        Account account= (Account) session.getAttribute("account");
        if(!Objects.equals(account.getUserType(), "ADMIN")){
            session.removeAttribute("account");
            return "redirect:/signin";
        }else {
            return "admindashboard";
        }

    }
}
