package com.joseph.services;

import com.joseph.models.Messages;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
public interface MessageService {
    void addMessage(Messages message);
    void removeMessage(Messages message);
    List findAll();
    void readMessage(long messageId);
    Messages findMessage(long MessageId);

}
