package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

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
    @GetMapping("/suspend/{accountId}")
    public String suspendAccount(@PathVariable("accountId")long accountId){
        Account account=accountService.findAccount(accountId);
        account.setActive(false);
        accountService.editAccount(account);
        return "redirect:/accountsaction";
    }
    @GetMapping("/recover/{accountId}")
    public String deleteAccount(@PathVariable("accountId")long accountId){
        Account account=accountService.findAccount(accountId);
        account.setActive(true);
        accountService.editAccount(account);
        return "redirect:/accountsaction";
    }
    @GetMapping("/edit/{accountId}")
    public String editAccount(@PathVariable("accountId") long accountId,Model model){
        Account account= (Account) session.getAttribute("account");
        if(account.getId()!=accountId){
            return "redirect:signout";
        }
        model.addAttribute("editAccount",account);
        return "editaccount";

    }
    @PostMapping("/edit/{accountId}")
    public String editPostProcessor(@RequestParam("newpass")String password2,@Valid Account account, BindingResult result,
                                    @RequestParam("profileImg") MultipartFile multipartFile,
                                    @PathVariable("accountId")long accountId){
        Account logged= (Account) session.getAttribute("account");
        if(!result.hasErrors()){
            if (logged.getId()!=accountId){
             return "redirect:/signout";
            }
            Account ac=accountService.getAccount(logged.getEmail());
            ac.setPasswordHash(password2);
            ac.setFname(account.getFname());
            ac.setLname(account.getLname());

            if(multipartFile.getSize()!=0){
                try {
                    ac.setProfile(multipartFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            accountService.editAccount(ac);
            session.removeAttribute("account");
            session.setAttribute("account",ac);

        }else {
            return "redirect:/signin";
        }
        return "redirect:/explore";
    }
    @GetMapping("/suspended")
    public String suspended(Model model){
        Account account= (Account) session.getAttribute("account");
        if(account==null){
            return "redirect:/signin";
        }
        if(account.isActive()){
            return "redirect:/explore";
        }
        return "suspended";
    }
}
