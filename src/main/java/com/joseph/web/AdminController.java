package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.models.Item;
import com.joseph.services.AccountService;
import com.joseph.services.ItemService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Objects;

/**
 * Created by joseph on 5/13/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/reports")
public class AdminController {
    private HttpSession session;
    private AccountService accountService;
    private ItemService itemService;
    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public String allItems(Model model){
        if(session.getAttribute("account")==null){
            return "redirect:/signin";
        }
        Account account= (Account) session.getAttribute("account");
        if(!Objects.equals(account.getUserType(), "ADMIN")){
            session.removeAttribute("account");
            return "redirect:/signin";
        }else {
            model.addAttribute("items",itemService.findAll());
            return "reports";
        }

    }
    @GetMapping("delete/{itemId}")
    public String deleteItemProcessor(Model model, @PathVariable("itemId") long itemId){
        if(session.getAttribute("account")==null){
            return "redirect:/signin";
        }
        Account account= (Account) session.getAttribute("account");
        if(!Objects.equals(account.getUserType(), "ADMIN")){
            session.removeAttribute("account");
            return "redirect:/signin";
        }else {
            Item item=itemService.findItem(itemId);
            itemService.removeItem(item);
            model.addAttribute("items",itemService.findAll());
            return "redirect:/reports";
        }
    }
    @GetMapping(value = "download")
    public void downloadReport(HttpServletRequest request, HttpServletResponse response){
        StringBuilder builder=new StringBuilder();
        Date current=new Date();
        builder.append("item id,posted by account Id,on date,account email\t\n");
        response.setContentType("application/octet-stream");
        for (Item i:itemService.findAll()){
            builder.append(i.getId()).append(",")
                    .append(i.getAccount().getId()).append(",")
                    .append(i.getTimePosted()).append(",")
                    .append(i.getAccount().getEmail())
                    .append("" +
                            "\t\n");
        }
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(current.toString()+".csv");
            fileOutputStream.write(builder.toString().getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream=new FileInputStream(current.toString()+".csv");
            IOUtils.copy(inputStream,response.getOutputStream());
            response.setHeader("Content-disposition", "attachment; filename="+current.toString()+".csv");
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
