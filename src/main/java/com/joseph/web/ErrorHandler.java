package com.joseph.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by joseph on 4/16/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/error")
public class ErrorHandler {
    @RequestMapping(method = RequestMethod.GET)
    public String defaultHandler(){
        return "emailerror";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/404")
    public String pageNotFoundError(){
        return "404";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/500")
    public String serverError(){
        return "500";
    }
}
