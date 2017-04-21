package com.joseph.services;

import com.joseph.models.Ratings;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
public interface RatingsService {
    void addRatings(Ratings ratings);
    void removeRatings(Ratings ratings);
    Ratings findRatings(long ratingsId);
    List<Ratings> findAll();
}
