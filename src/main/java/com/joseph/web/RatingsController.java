package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.models.Ratings;
import com.joseph.services.AccountService;
import com.joseph.services.ItemService;
import com.joseph.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by joseph on 5/15/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/explore/ratings")
public class RatingsController {
    private Ratings ratings=new Ratings();
    private RatingsService ratingsService;
    private ItemService itemService;
    Account account;
    AccountService accountService;
    HttpSession session;
    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setRatingsService(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }
    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseBody
    public String defaultRating(@RequestParam("itemId") long itemId,
                                @RequestParam("ratingValue") int rating,
                                @RequestParam("messageBody") String body,
                                @RequestParam("userEmail") String userEmail){
        account= (Account) session.getAttribute("account");
        //confirm current logged user before rating
        if(accountService.getAccount(userEmail)!=null&&Objects.equals(account.getEmail(), userEmail)){
            ratings.setUser(account);
            ratings.setItem(itemService.findItem(itemId));
            ratings.setValue(rating);
            ratings.setMessage(body);
            ratingsService.addRatings(ratings);
        }else {
            return "Error!";
        }
        return "<p>Successfully Reviewed Item.Thank you</p>";

    }
}
