package com.example.lnovo.sampleapplication;

public class AddServices {


private String id;
private String service;
private String price;

    public AddServices() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public AddServices(String id, String service, String price) {
        this.id = id;
        this.service = service;
        this.price = price;

    }
}