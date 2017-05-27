package com.joseph.web;

import com.joseph.models.Account;
import com.joseph.models.Messages;
import com.joseph.services.AccountService;
import com.joseph.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * Created by joseph on 5/16/17.
 * Email: developergitch@outlook.com
 */
@Controller
@RequestMapping("/explore/message")
public class MessageController {
    private Messages messages;
    private MessageService messageService;
    Account account;
    private AccountService accountService;
    private HttpSession session;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }
    @GetMapping
    @ResponseBody
    public String defaultMessageHandler(
            @RequestParam("senderEmail")String senderEmail,
            @RequestParam("subject") String subject,
            @RequestParam("body")String body,
            @RequestParam("recipientEmail") String recipient){
        account= (Account) session.getAttribute("account");
        if(Objects.equals(account.getEmail(), senderEmail)){
            messages=new Messages();
            messages.setRead_status(false);
            messages.setMessageBody(body);
            messages.setRecipientEmail(recipient);
            messages.setTimeSend(new Date());
            messages.setSubject(subject);
            messages.setSenderEmail(senderEmail)    ;
            messages.setSenderAccount(account);
            messageService.addMessage(messages);

        }else {
            return "<p>Fatal Error!</p>";
        }
        return "<p>Success</p>";
    }
}
