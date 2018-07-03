package com.example.lnovo.sampleapplication;

/**
 * Created by lnovo on 5/17/2018.
 */

public class Appointment {

    private String userName;
    private String SalonName;
    private String ServiceName;
    private String Time;
    private String Date;

    public Appointment() {
    }

    public Appointment(String userName, String salonName, String serviceName, String time, String date) {
        this.userName = userName;
        SalonName = salonName;
        ServiceName = serviceName;
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

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
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
