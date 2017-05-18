package com.joseph.web;

import com.joseph.beans.AuthData;
import com.joseph.models.Account;
import com.joseph.services.AccountService;
import com.joseph.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by joseph on 4/8/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping(path = {"/signin"})
public class SigninController {
    private AccountService accountService;
    private HttpSession httpSession;
    private MessageService messageService;
    @Autowired
    public void setAccountService(AccountService accountService){
        this.accountService=accountService;
    }
    @Autowired
    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String handleInitialRequest(Model model){
        model.addAttribute("authData",new AuthData());
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processRequest(@Valid AuthData authData, BindingResult result){
        boolean status;
        if(!result.hasErrors()){
            //call valdation method to validate user data against one stored in database
            status=authenticateUser(authData.getEmail(),authData.getPassword());
            if(status){
                Account account=accountService.getAccount(authData.getEmail());
                httpSession.setAttribute("account",account);
                httpSession.setAttribute("messages",messageService.findAllForAccount(account.getEmail()));
                return "redirect:/explore";
            }else {
                return "redirect:/signin";
            }
        }else {
            return "redirect:/signin";
        }
    }
    public boolean authenticateUser(String email,String password){
        Account account=accountService.getAccount(email);
        if(account!=null){
            return Objects.equals(account.getEmail(), email) && Objects.equals(account.getPasswordHash(), password);
        }else {
            return false;
        }

    }
}
