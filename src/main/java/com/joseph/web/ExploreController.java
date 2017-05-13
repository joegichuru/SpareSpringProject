package com.joseph.web;

import com.joseph.models.Item;
import com.joseph.services.ItemService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by joseph on 5/9/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/explore")
public class ExploreController {
    private List<Item> itemList;
    private ItemService itemService;
    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
    private HttpSession session;
    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String handleExplore(Model model){

        itemList=itemService.findAll();//.subList(0,itemList.size()>30? 30:itemList.size()-1);
        itemList=itemList.subList(0,itemList.size()<20?itemList.size():20);//debug here done :=)
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
    @RequestMapping(value = "sort/city/",method = RequestMethod.GET)
    public String exploreFilterCity(@RequestParam(value = "city",required = false,defaultValue = "nairobi")String city,Model model){
        List<Item> itemListByCity=itemService.findByCity(city);
        model.addAttribute("items",itemListByCity);
        return "explorefrag::explore";
    }
    @RequestMapping(value = "sort/price/",method = RequestMethod.GET)
    public String exploreFilterPrice(@RequestParam(value = "high",required = false)int high,
                                     @RequestParam(value = "low",required = false)int low,Model model){
        itemList=itemService.findByPrice(high,low);
        model.addAttribute("items",itemList);
        return "explorefrag::explore";
    }
    @RequestMapping(value = "sort/category",method = RequestMethod.GET)
    public String exploreFilterByCategory(@RequestParam(value = "category",required = false,defaultValue = "RENT")String category,
                                          Model model){
        itemList=itemService.findByCategory(category);
        model.addAttribute("items",itemList);
        return "explorefrag::explore";
    }
    @GetMapping(value = "map")
    public String exploreMap(Model model){
        if(session.getAttribute("account")==null){
            session.setAttribute("logged",false);
        }else {
            session.setAttribute("logged",true);
        }
        return "exploremap";
    }
}
