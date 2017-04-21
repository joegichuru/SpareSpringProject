package com.joseph.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by joseph on 3/15/17.
 * Email: developergitch@outlook.com
 */
@Entity
@Table(name = "ITEMS")
@Component
public class Item extends BaseModel{
    @NotNull
    private String name;
    @NotNull
    private String description;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timePosted;
    @Lob
    private byte[] descriptiveImage;
    private int noOfBathrooms=1;
    private int noOfBedrooms=1;
    private boolean hasPacking=false;
    private boolean hasSwimmingPool=false;
    private boolean availableImediately=true;
    private String category="rent";//sell or rent
    private String itemType="apartment";//apartments etc
    private double price;
    @OneToMany(mappedBy = "item")
    private Set<Ratings> ratings;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(Date timePosted) {
        this.timePosted = timePosted;
    }

    public byte[] getDescriptiveImage() {
        return descriptiveImage;
    }

    public void setDescriptiveImage(byte[] descriptiveImage) {
        this.descriptiveImage = descriptiveImage;
    }

    public int getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(int noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public int getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public boolean isHasPacking() {
        return hasPacking;
    }

    public void setHasPacking(boolean hasPacking) {
        this.hasPacking = hasPacking;
    }

    public boolean isHasSwimmingPool() {
        return hasSwimmingPool;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public boolean isAvailableImediately() {
        return availableImediately;
    }

    public void setAvailableImediately(boolean availableImediately) {
        this.availableImediately = availableImediately;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
