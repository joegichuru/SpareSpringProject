package com.joseph.web;

import com.joseph.models.Item;
import com.joseph.services.ItemService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by joseph on 4/7/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/")
public class HomeController {
    private List<Item> itemList;
    private List<String> products=new ArrayList<>();
    @Autowired
    private ItemService itemService;
    @Autowired
    private HttpSession session;
    @RequestMapping(method = RequestMethod.GET)
    public String handleHomePage(Model model){
        return "landing";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/navigation")
    public String navigationTemplate(Model model){
        Calendar calendar=Calendar.getInstance();
        model.addAttribute("date",calendar.getTime());
        model.addAttribute("name","joseph");
        products.add("Stationary");
        products.add("Furniture");
        products.add("Boxes");
        products.add("More");
        products.add("Stationary");
        products.add("Furniture");
        products.add("Boxes");
        products.add("More");
        products.add("Stationary");
        products.add("Furniture");
        products.add("Boxes");
        products.add("More");
        products.add("Stationary");
        products.add("Furniture");
        products.add("Boxes");
        products.add("More");
        products.add("Stationary");
        products.add("Furniture");
        products.add("Boxes");
        products.add("More");
        model.addAttribute("products",products);
        return "navigation";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/explore")
    public String handleExplore(Model model){
        itemList=itemService.findAll() ;
        if(itemList.size()>0) {
            model.addAttribute("items", itemList);
        }
        if(session.getAttribute("account")==null){
            session.setAttribute("logged",false);
        }else {
            session.setAttribute("logged",true);
        }
        return "explore";
    }
}
