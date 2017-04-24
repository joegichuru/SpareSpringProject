package com.joseph.models;

import javax.persistence.Entity;

/**
 * Created by joseph on 4/23/17.
 * Email: developergitch@outlook.com
 */
@Entity
public class Location extends BaseModel {
    //To do set location to somewhere in nairobi just incase the user doesn't enter
    private String latitude;
    private String longitude;
    private String city;
    private String street;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
