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
public class Ords {
    protected int orderID;
    protected Date creationdatel;
    protected Date finisheddate;
    protected String status;
    protected int userID;

    public Ords() {
    }

    public Ords(int orderID, Date creationdatel, Date finisheddate, String status, int userID) {
        this.orderID = orderID;
        this.creationdatel = creationdatel;
        this.finisheddate = finisheddate;
        this.status = status;
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getCreationdatel() {
        return creationdatel;
    }

    public void setCreationdatel(Date creationdatel) {
        this.creationdatel = creationdatel;
    }

    public Date getFinisheddate() {
        return finisheddate;
    }

    public void setFinisheddate(Date finisheddate) {
        this.finisheddate = finisheddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
}
