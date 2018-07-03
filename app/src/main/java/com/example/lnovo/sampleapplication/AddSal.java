package com.example.lnovo.sampleapplication;


public class AddSal {

    private String id;
    private String Name;
    private String Owner;
    private String RegNo;
    private String Address;
    private String Email;
    private String Phone;
    private String Pass;
    private String ConPass;
    private String type;

    public AddSal(String id, String name, String owner, String regNo, String address, String email, String phone, String pass, String conPass, String type) {
        this.id = id;
        Name = name;
        Owner = owner;
        RegNo = regNo;
        Address = address;
        Email = email;
        Phone = phone;
        Pass = pass;
        ConPass = conPass;
        this.type = type;

    }

    public AddSal() {

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

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
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