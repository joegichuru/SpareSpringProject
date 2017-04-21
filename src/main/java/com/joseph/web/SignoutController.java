package com.joseph.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by joseph on 4/16/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/signout")
public class SignoutController {
    @RequestMapping(method = RequestMethod.GET)
    /**
     *Get @param HttpSession .Invalidate all sessions the redirect to landing page
     * @return String <code>redirect Path</code>
     */
    public String handleRequest(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
