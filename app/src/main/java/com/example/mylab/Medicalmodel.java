package com.example.mylab;

public class Medicalmodel {

    public String getMname() {
        return mname;
    }

    public String getMaddress() {
        return maddress;
    }

    public String getMinorderamt() {
        return minorderamt;
    }

    public int getImage() {
        return image;
    }

    String mname;
    String maddress;
    String minorderamt;
    int image;

    public Medicalmodel(String mname, String maddress, String minorderamt, int image) {
        this.mname = mname;
        this.maddress = maddress;
        this.minorderamt = minorderamt;
        this.image = image;
    }


}
