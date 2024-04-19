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
public class Product {
    protected String productID;
    protected String pdname;
    protected String pddesc;
    protected boolean visibility;
    protected Date adddate;
    protected float price;
    protected String picture;
    protected int category;

    public Product(String productID, String pdname, String pddesc, boolean visibility, Date adddate, float price, String picture, int category) {
        this.productID = productID;
        this.pdname = pdname;
        this.pddesc = pddesc;
        this.visibility = visibility;
        this.adddate = adddate;
        this.price = price;
        this.picture = picture;
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Product() {
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    public String getPddesc() {
        return pddesc;
    }

    public void setPddesc(String pddesc) {
        this.pddesc = pddesc;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getSize() {
        return productID.substring(productID.length() - 1);
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getVariant()
    {
        return this.productID.substring(6, 9);
    }
}
