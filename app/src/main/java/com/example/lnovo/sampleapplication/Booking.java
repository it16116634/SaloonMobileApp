package com.example.lnovo.sampleapplication;

/**
 * Created by lnovo on 5/22/2018.
 */

class Booking {

    private String userName;
    private String SalonName;
    private String Price;
    private String Time;
    private String Date;

    public Booking() {
    }

    public Booking(String userName, String salonName, String price, String time, String date) {
        this.userName = userName;
        SalonName = salonName;
        Price = price;
        Time = time;
        Date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalonName() {
        return SalonName;
    }

    public void setSalonName(String salonName) {
        SalonName = salonName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
