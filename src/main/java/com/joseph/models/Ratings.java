package com.joseph.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

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
}
