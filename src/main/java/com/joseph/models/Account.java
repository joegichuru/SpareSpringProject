package com.joseph.models;

import org.springframework.util.Base64Utils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

/**
 * Created by joseph on 3/15/17.
 * Email: developergitch@outlook.com
 */
@Entity
@Table(name = "ACCOUNTS")
public class Account extends BaseModel {
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdOn;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLogIn;
    private boolean active;
    private String passwordHash;
    @Column(name = "F_NAME")
    @NotNull
    private String fname;
    @Column(name = "L_NAME")
    @NotNull
    private String lname;
    @Column(name = "EMAIL")
    @NotNull
    private String email;
    @Column(name = "PROF")
    @Lob
    private byte[] profile;
    @Column(name = "PHONE")
    private String phone;
    /**
     * There are two user categories; ADMIN and REGULAR
     * ADMIN has some elevated privilages
     */
    @Column(name = "TYPE")
    private String userType="REGULAR";
    private String gender;

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(Date lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //encode the image to base64 so you can use the string to generate an image in html :-)
    public String encodedImage(){
        return "data:image/png;base64,"+Base64.getEncoder().encodeToString(getProfile());
    }

}
