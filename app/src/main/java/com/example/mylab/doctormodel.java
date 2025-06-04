package com.example.mylab;

public class doctormodel {

    String dname;

    public String getDname() {
        return dname;
    }

    public String getHaddress() {
        return haddress;
    }

    public String getExpre() {
        return expre;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public String getFeecost() {
        return feecost;
    }

    String haddress;
    String expre;
    String mobilenum;
    String feecost;

    public doctormodel(String dname, String haddress, String expre, String mobilenum, String feecost) {
        this.dname = dname;
        this.haddress = haddress;
        this.expre = expre;
        this.mobilenum = mobilenum;
        this.feecost = feecost;
    }


}
