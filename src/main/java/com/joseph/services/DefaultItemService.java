package com.joseph.services;

import com.joseph.models.Account;
import com.joseph.models.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
@DefaultService
public class DefaultItemService implements ItemService {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = false)
    @Override
    public void addItem(Item item, Account account) {
        item.setAccount(account);
        item.setAvailableImediately(true);
        item.setTimePosted(new Date());
        sessionFactory.getCurrentSession().save(item);
    }

    @Transactional(readOnly = false)
    @Override
    public void removeItem(Item item) {
        sessionFactory.getCurrentSession().remove(item);

    }

    @Override
    public Item findItem(long itemId) {
        return (Item) sessionFactory.getCurrentSession().createQuery("FROM Item i WHERE i.id=:itemId")
                .setParameter("itemId",itemId).getSingleResult();

    }

    @Override
    public List<Item> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Item i order by i.timePosted desc ").getResultList();
    }

    @Override
    public List<Item> findByCity(String city) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Item i WHERE i.location.city=:city").setParameter("city",city).getResultList();
    }

    @Override
    public List<Item> findByPrice(int high, int low) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Item i WHERE i.price>:low AND i.price<:high")
                .setParameter("high",high)
                .setParameter("low",low).getResultList();
    }

    @Override
    public List<Item> findByCategory(String category) {
        if(!category.equals("rent")||!category.equals("sell")){
            category="rent";
        }
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Item i WHERE i.category like :cat").setParameter("cat",category)
                .getResultList();
    }
}
