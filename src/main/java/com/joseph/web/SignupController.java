package com.joseph.web;

import com.joseph.beans.UserForm;
import com.joseph.models.Account;
import com.joseph.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

/**
 * Created by joseph on 4/8/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping(path = {"signup"})
public class SignupController {
    private Account account=new Account();
    private AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService){
        this.accountService=accountService;
    }
    public UserForm userForm=new UserForm();
    @RequestMapping(method = RequestMethod.GET)
    public String handleInitialRequest(Model model){
        model.addAttribute("userForm",userForm);
        return "register";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String process(@Valid UserForm userForm, BindingResult result,
                          @RequestParam("profile") MultipartFile multipartFile,Model model){
        //check if email is already registered to another account
        if(accountService.getUserAccounts(userForm.getEmail()).size()>0){
            return "redirect:error";
        }else {
            account.setCreatedOn(new Date());
            account.setActive(true);
            account.setEmail(userForm.getEmail());
            account.setFname(userForm.getFname());
            account.setLname(userForm.getLname());
            account.setLastLogIn(new Date());
            account.setGender(userForm.getGender());
            account.setPasswordHash(userForm.getPassword());
        }

        if(multipartFile.getSize()!=0){
            try {
                account.setProfile(multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(result.hasErrors()){
            return "redirect:signup";
        }else {
           accountService.createAccount(account);
            return "redirect:signin";
        }

    }

}
