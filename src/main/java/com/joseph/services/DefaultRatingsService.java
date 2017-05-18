package com.joseph.services;

import com.joseph.models.Ratings;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
@DefaultService
public class DefaultRatingsService implements RatingsService {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional(readOnly = false)
    @Override
    public void addRatings(Ratings ratings) {
        sessionFactory.getCurrentSession().save(ratings);
    }

    @Override
    public void removeRatings(Ratings ratings) {

    }

    @Override
    public Ratings findRatings(long ratingsId) {
        return null;
    }

    @Override
    public List<Ratings> findAll() {
        return null;
    }
}
