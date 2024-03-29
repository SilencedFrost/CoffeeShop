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
public class Comment {
    protected int commentID;
    protected int userID;
    protected String productID;
    protected Date adddate;
    protected float rating;
    protected String comm;

    public Comment() {
    }

    public Comment(int commentID, int userID, String productID, Date adddate, float rating, String comm) {
        this.commentID = commentID;
        this.userID = userID;
        this.productID = productID;
        this.adddate = adddate;
        this.rating = rating;
        this.comm = comm;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }
    
    
}
