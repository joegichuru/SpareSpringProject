package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.models.Item;
import com.joseph.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by joseph on 4/10/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping(path = "/add")
public class AddItemController {
    @Autowired
    HttpSession session;
    @Autowired
    private
    ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest(Model model){
        Account account= (Account) session.getAttribute("account");
        if(account==null){
            return "redirect:/signin";
        }
        if(!account.isActive()){
            return "redirect:/accountsaction/suspended";
        }
        model.addAttribute("item",new Item());
        return "add";
    }
    @PostMapping
    public String process(@Valid Item item, BindingResult result, @RequestParam("item-image") MultipartFile multipartFile){
        Account account= (Account) session.getAttribute("account");
        if(result.hasErrors()){
            return "redirect:/error";
        }else {
            try {
                item.setDescriptiveImage(multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            itemService.addItem(item,account);
        }
        return "redirect:/add";
    }
}
