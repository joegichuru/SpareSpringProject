package com.joseph.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
    private boolean hasSwimmingPool=false;
    private boolean hasGarage=false;
    private boolean hasSecurity=false;
    private boolean hasBalcony=false;
    private boolean hasPlayGround=false;
    private boolean hasFirePlace=false;
    private boolean hasGatedCommunity=false;
    private boolean hasParking=false;
    private boolean hasGarden=false;
    private boolean availableImediately=true;
    private String category="rent";//sell or rent
    private String itemType="apartment";//apartments etc
    private double price;
    @OneToMany(mappedBy = "item")
    private Set<Ratings> ratings;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Account account;
    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    private Location location;

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

    public boolean isHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public boolean isHasSecurity() {
        return hasSecurity;
    }

    public void setHasSecurity(boolean hasSecurity) {
        this.hasSecurity = hasSecurity;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasPlayGround() {
        return hasPlayGround;
    }

    public void setHasPlayGround(boolean hasPlayGround) {
        this.hasPlayGround = hasPlayGround;
    }

    public boolean isHasFirePlace() {
        return hasFirePlace;
    }

    public void setHasFirePlace(boolean hasFirePlace) {
        this.hasFirePlace = hasFirePlace;
    }

    public boolean isHasGatedCommunity() {
        return hasGatedCommunity;
    }

    public void setHasGatedCommunity(boolean hasGatedCommunity) {
        this.hasGatedCommunity = hasGatedCommunity;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public Set<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Ratings> ratings) {
        this.ratings = ratings;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    /**
     * this method generates amount of time that has passed since the item was posted
     * @return time as string
     */
    public String timeConverter(){
        Instant instant=Instant.now();
        Instant posted=getTimePosted().toInstant();
        //get amount of seconds past since 1970-01-01T00:00:00Z.
        long millSinceEpoch=posted.getEpochSecond();
        //get time past till now
        long millsSinceEpochNow=instant.getEpochSecond();
        long diffInTime=millsSinceEpochNow-millSinceEpoch;
        diffInTime=diffInTime*1000;
        long secondsPast=diffInTime/1000;
        long minutesPast=secondsPast/60;
        long hoursPast=minutesPast/60;
        long daysPast=hoursPast/24;
        if(secondsPast<60){
            return "just now";
        }else {
            if (minutesPast>0){
                if(minutesPast<60){
                    return minutesPast+" mins ago";
                }else {
                    if(hoursPast>0&&hoursPast<10){
                        return hoursPast +"hrs ago";
                    }else {
                        return "on "+getTimePosted().toString();
                    }
                }
            }else {
                return "on "+getTimePosted().toString();
            }
        }
    }
}
