package com.joseph.models;


import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
    private boolean hasSwimmingPool;
    private boolean hasGarage;
    private boolean hasSecurity;
    private boolean hasBalcony;
    private boolean hasPlayGround;
    private boolean hasFirePlace;
    private boolean hasGatedCommunity;
    private boolean hasParking;
    private boolean hasGarden;
    private boolean availableImediately;
    private String city="nairobi";
    @ElementCollection
    private List<String> amenities=new ArrayList<>();
    private String category="apartment";//sell or rent
    private double price;
    @Transient
    private String locationStr;
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
        this.location = new Location(locationStr);
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
        LocalDate localDate=getTimePosted().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
                        return "on "+(localDate.getYear()+"/"+localDate.getMonthValue()+"/"+localDate.getDayOfMonth());
                    }
                }
            }else {
                return "on "+(localDate.getYear());
            }
        }
    }
    //encode the image to base64 so you can use the string to generate an image in html :-)
    public String encodedImage(){
        return "data:image/png;base64,"+ Base64.getEncoder().encodeToString(getDescriptiveImage());
    }
    //image croping algorithm
    public void cropImage(byte[] original){
        InputStream inputStream=new ByteArrayInputStream(original);
        try {
            BufferedImage originalImage= ImageIO.read(inputStream);
            int height=originalImage.getHeight();
            int width=originalImage.getWidth();
            //scale all images to be 2880 *1620
            if((height>1400&&height<1700)&&(width>2600&&width<3000)){
                //do nothing perfect size
            }else {
                //crop or expand
                //crop

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocationStr() {
        return locationStr;
    }

    public void setLocationStr(String locationStr) {
        this.locationStr = locationStr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
