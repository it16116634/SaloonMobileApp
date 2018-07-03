package com.example.lnovo.sampleapplication;

public class Salon {
    private String name;
    private String location;
    private String service;

    public Salon() {

    }

    public Salon(String name, String location, String service) {
        this.name = name;
        this.location = location;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
