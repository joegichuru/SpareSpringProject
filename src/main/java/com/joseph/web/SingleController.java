package com.joseph.web;

import com.joseph.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by joseph on 4/15/17.
 * Email: developergitch@outlook.com
 */
@Controller
public class SingleController {
    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(path = "/single")
    public String handler(Model model, HttpSession session){
        if(session.getAttribute("account")==null){
            return "redirect:login";
        }
        model.addAttribute("title","Home");
        model.addAttribute("users",accountService.getUserAccounts());
        return "single";
    }
}
