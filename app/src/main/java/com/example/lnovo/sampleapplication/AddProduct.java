package com.example.lnovo.sampleapplication;

public class AddProduct {

    private String iname;
    private String ino;
    private String iprice;
    private String iqty;

    public AddProduct(String iname, String ino, String iprice, String iqty) {
        this.iname = iname;
        this.ino = ino;
        this.iprice = iprice;
        this.iqty = iqty;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public void setIno(String ino) {
        this.ino = ino;
    }

    public void setIprice(String iprice) {
        this.iprice = iprice;
    }

    public void setIqty(String iqty) {
        this.iqty = iqty;
    }

    public String getIname() {
        return iname;
    }

    public String getIno() {
        return ino;
    }

    public String getIprice() {
        return iprice;
    }

    public String getIqty() {
        return iqty;
    }

    public AddProduct() {


    }
}
