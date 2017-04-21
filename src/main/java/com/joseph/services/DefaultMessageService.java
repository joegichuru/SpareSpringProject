package com.joseph.services;


import com.joseph.models.Messages;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
@DefaultService
public class DefaultMessageService implements MessageService {
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Transactional(readOnly = false)
    @Override
    public void addMessage(Messages message) {
        sessionFactory.getCurrentSession().saveOrUpdate(message);
    }

    @Transactional(readOnly = false)
    @Override
    public void removeMessage(Messages message) {
        sessionFactory.getCurrentSession().remove(message);

    }

    @Override
    public List findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Messages m order by m.timeSend asc ")
                .getResultList();
    }

    @Transactional(readOnly = false)
    @Override
    public void readMessage(long messageId) {
        Messages messages=findMessage(messageId);
        //change read status to true i.e read the message
        if(!messages.isRead()) {
            messages.setRead_status(true);
        }
    }

    @Override
    public Messages findMessage(long messageId) {
        return (Messages) sessionFactory.getCurrentSession()
                .createQuery("select distinct u from Messages u where u.id=:messageId")
                .setParameter("messageId",messageId).uniqueResult();

    }

}
