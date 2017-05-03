package com.joseph.services;

import com.joseph.models.Account;
import com.joseph.models.Item;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
public interface ItemService {
    void addItem(Item item, Account account);
    void removeItem(Item item);
    Item findItem(long itemId);
    List<Item> findAll();
    List<Item> findByCity(String city);
    List<Item> sortByPriceHigh();
    List<Item> sortByPriceLowToHigh();
    List<Item> sortByViewsLowToHigh();
    List<Item> sortByViewsHighToLow();
}
