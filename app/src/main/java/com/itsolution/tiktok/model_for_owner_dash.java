package com.itsolution.tiktok;

public class model_for_owner_dash {
    String tittle;
    String description;
    String vurl;



    public model_for_owner_dash() {
    }

    public model_for_owner_dash(String tittle, String description, String vurl) {
        this.tittle = tittle;
        this.description = description;
        this.vurl = vurl;

    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }



}
