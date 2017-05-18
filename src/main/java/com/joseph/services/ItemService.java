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

    List<Item> findByPrice(int high, int low);

    List<Item> findByCategory(String category);
    List<Item> filteredResults(String city,String category,double priceHigh,double priceLow);
}
