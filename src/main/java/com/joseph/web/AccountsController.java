package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by joseph on 5/10/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/accountsaction")
public class AccountsController {
    HttpSession session;
    AccountService accountService;

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String defaultAccountAction(Model model){
        if(session.getAttribute("account")!=null){
            Account account= (Account) session.getAttribute("account");
            if(!account.getUserType().equals("ADMIN")){
                return "redirect:/signin";
            }else {
                model.addAttribute("accounts",accountService.getUserAccounts());
                return "accounts";
            }
        }else {
            return "redirect:/signin";
        }

    }
    @ResponseBody
    @GetMapping("/suspend/{accountId}")
    public String suspendAccount(@PathVariable("accountId")long accountId){
        Account account=accountService.findAccount(accountId);
        account.setActive(false);
        accountService.editAccount(account);
        return "<p>Successfully suspended account<p>";
    }
}
