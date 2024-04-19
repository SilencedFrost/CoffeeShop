/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author thnrg
 */
public class Customer {
    protected int userID;
    protected String username;
    protected String profilepic;
    protected int position;
    protected String email;
    protected boolean gender;
    protected String phone;
    protected String exactloc;
    protected String ward;
    protected String district;
    protected String city;
    protected Date joindate;

    public Customer() {
    }

    public Customer(int userID, String username, String profilepic, int position, String email, boolean gender, String phone, String exactloc, String ward, String district, String city, Date joindate) {
        this.userID = userID;
        this.username = username;
        this.profilepic = profilepic;
        this.position = position;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.exactloc = exactloc;
        this.ward = ward;
        this.district = district;
        this.city = city;
        this.joindate = joindate;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExactloc() {
        return exactloc;
    }

    public void setExactloc(String exactloc) {
        this.exactloc = exactloc;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }
}
