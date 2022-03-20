package com.my.shakelogs;

import java.util.ArrayList;

public class model1 {
    private String ehliyet;
    private String iduser;
    private String cinsiyet;
    private ArrayList<model2> kisilik;

    public String getEhliyet() {
        return ehliyet;
    }

    public void setEhliyet(String ehliyet) {
        this.ehliyet = ehliyet;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public ArrayList<model2> getKisilik() {
        return kisilik;
    }

    public void setKisilik(ArrayList<model2> kisilik) {
        this.kisilik = kisilik;
    }
}
