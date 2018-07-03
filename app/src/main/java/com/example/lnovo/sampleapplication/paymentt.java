package com.example.lnovo.sampleapplication;

public class paymentt {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String phnnumber;
    private String email;
    private String cardnum;

    public paymentt() {
    }

    public paymentt(String firstname, String lastname, String address, String city, String phnnumber, String email, String cardnum) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.phnnumber = phnnumber;
        this.email = email;
        this.cardnum = cardnum;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhnnumber() {
        return phnnumber;
    }

    public void setPhnnumber(String phnnumber) {
        this.phnnumber = phnnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }
}
