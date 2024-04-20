/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author thnrg
 */
public class ProductInfo {
    protected String productName;
    protected String productDesc;
    protected boolean S;
    protected boolean M;
    protected boolean L;
    protected String priceS;
    protected String priceM;
    protected String priceL;
    protected String picture;

    public ProductInfo() {
        this.S = false;
        this.M = false;
        this.L = false;
    }

    public ProductInfo(String productName, String productDesc, boolean S, boolean M, boolean L, float priceS, float priceM, float priceL, String picture) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.S = S;
        this.M = M;
        this.L = L;
        
        Locale vietnam = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vietnam);
        String formattedPrice = numberFormat.format(priceS);
        this.priceS = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
        
        formattedPrice = numberFormat.format(priceM);
        this.priceM = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
        
        formattedPrice = numberFormat.format(priceL);
        this.priceL = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
        
        this.picture = picture;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public boolean isS() {
        return S;
    }

    public void setS(boolean S) {
        this.S = S;
    }

    public boolean isM() {
        return M;
    }

    public void setM(boolean M) {
        this.M = M;
    }

    public boolean isL() {
        return L;
    }

    public void setL(boolean L) {
        this.L = L;
    }

    public String getPriceS() {
        return priceS;
    }

    public void setPriceS(float priceS) {
        Locale vietnam = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vietnam);
        String formattedPrice = numberFormat.format(priceS);
        this.priceS = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
    }

    public String getPriceM() {
        return priceM;
    }

    public void setPriceM(float priceM) {
        Locale vietnam = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vietnam);
        String formattedPrice = numberFormat.format(priceM);
        this.priceM = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
    }

    public String getPriceL() {
        return priceL;
    }

    public void setPriceL(float priceL) {
        Locale vietnam = Locale.forLanguageTag("vi-VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vietnam);
        String formattedPrice = numberFormat.format(priceL);
        this.priceL = formattedPrice.substring(0, formattedPrice.length() - 2) + "VND";
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}
