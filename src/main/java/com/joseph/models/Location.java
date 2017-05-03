package com.joseph.models;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by joseph on 4/23/17.
 * Email: developergitch@outlook.com
 */
@Entity
public class Location extends BaseModel {
    //To do set location to somewhere in nairobi just incase the user doesn't enter
    private double latitude;
    private double longitude;
    private String city;
    @Transient
    private final  Map<String,Double[]> cities=new HashMap<>();

    public Location() {
    }
    public Location(String location){
        //initialise cities;
        cities.put("Nairobi",new Double[]{0.0,0.0});
        cities.put("Nairobi",new Double[]{0.0,0.0});
        cities.put("Nairobi",new Double[]{0.0,0.0});
        cities.put("Nairobi",new Double[]{0.0,0.0});
        cities.put("Nairobi",new Double[]{0.0,0.0});
        cities.put("Nairobi",new Double[]{0.0,0.0});
        cities.put("Nairobi",new Double[]{0.0,0.0});
        String[] templocation=location.split(" ");
        //set location from extracted strings
        double tempLat=Double.parseDouble(templocation[1]);
        double tempLong=Double.parseDouble(templocation[3]);
        if(tempLat!=0){
            this.latitude=tempLat;
        }
        if(tempLong!=0){
            this.longitude=tempLong;
        }
        String city=genarateCity(latitude,longitude);
    }
    @Transient
    private String genarateCity(double latitude, double longitude) {
        String currentCity="Unknown";
        for(Double[] city:cities.values()){
            
        }
        return null;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
