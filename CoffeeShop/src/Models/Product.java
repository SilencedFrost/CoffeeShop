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
    protected String size;
    protected float price;

    public Product(String productID, String pdname, String pddesc, boolean visibility, Date adddate, String size, float price) {
        this.productID = productID;
        this.pdname = pdname;
        this.pddesc = pddesc;
        this.visibility = visibility;
        this.adddate = adddate;
        this.size = size;
        this.price = price;
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
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
