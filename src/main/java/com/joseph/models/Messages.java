package com.joseph.models;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by joseph on 3/15/17.
 * Email: developergitch@outlook.com
 */
@Entity
public class Messages extends BaseModel {
    private String messageBody;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timeSend;
    private String senderEmail;
    private String recipientEmail;
    private Boolean read_status =false;
    private String subject;

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getTimeSend() {
        return timeSend;
    }

    public void setTimeSend(Date timeSend) {
        this.timeSend = timeSend;
    }


    public Boolean isRead() {
        return read_status;
    }

    public void setRead_status(Boolean read_status) {
        this.read_status = read_status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }
}
