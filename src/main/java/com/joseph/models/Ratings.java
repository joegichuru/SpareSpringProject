package com.joseph.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
@Entity
public class Ratings extends BaseModel{
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Account user;
    private int value;
    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;
    private String message;

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
