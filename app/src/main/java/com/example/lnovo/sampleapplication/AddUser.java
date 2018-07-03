package com.example.lnovo.sampleapplication;

public class AddUser {

    private String id;
    private String Name;
    private String Gender;
    private String PhNo;
    private String City;
    private String Email;
    private String Pass;
    private String ConPass;
    private String type;

    public AddUser(String id, String name, String gender, String phNo, String city, String email, String pass, String conPass, String type) {
        this.id = id;
        Name = name;
        Gender = gender;
        PhNo = phNo;
        City = city;
        Email = email;
        Pass = pass;
        ConPass = conPass;
        this.type = type;
    }

    public AddUser() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhNo() {
        return PhNo;
    }

    public void setPhNo(String phNo) {
        PhNo = phNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getConPass() {
        return ConPass;
    }

    public void setConPass(String conPass) {
        ConPass = conPass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
