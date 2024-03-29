package Models;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thnrg
 */
public class PaymentCard {
    protected String cardnum;
    protected int userID;
    protected Date expdate;
    protected int cvv;
    protected String cardownername;

    public PaymentCard(String cardnum, int userID, Date expdate, int cvv, String cardownername) {
        this.cardnum = cardnum;
        this.userID = userID;
        this.expdate = expdate;
        this.cvv = cvv;
        this.cardownername = cardownername;
    }

    public PaymentCard() {
    }
    
    public String getCardnum() {
        return cardnum;
    }

    public int getUserID() {
        return userID;
    }

    public Date getExpdate() {
        return expdate;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardownername() {
        return cardownername;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setCardownername(String cardownername) {
        this.cardownername = cardownername;
    }
}
