package com.joseph.web;

import com.joseph.services.AccountService;
import com.joseph.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

/**
 * Created by joseph on 4/15/17.
 * Email: developergitch@outlook.com
 */
@Controller
public class SingleController {
    private AccountService accountService;
    private ItemService itemService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(path = "/explore/{itemId}")
    public String handler(Model model, HttpSession session, @PathVariable long itemId){
        if(session.getAttribute("account")==null){
            return "redirect:/signin";
        }
        model.addAttribute("title","Home");
        model.addAttribute("users",accountService.getUserAccounts());
        try{
            //check if item exits if not return user back to explore page
            model.addAttribute("item",itemService.findItem(itemId));
            return "single";
        }catch (NoResultException e){
            return "redirect:/explore";
        }
    }
}
