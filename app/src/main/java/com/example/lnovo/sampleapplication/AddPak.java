package com.example.lnovo.sampleapplication;

public class AddPak {

    private String id;
    private String pk;
    private String pg;

    public AddPak() {

    }

    public AddPak(String id, String pk,String pg) {
        this.id = id;
        this.pk = pk;
        this.pg = pg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }
}
