package com.example.mylab;

public class Ordermodel {

    String id;
    String odritem;
    String orderdate;
    String orderamount;


    public Ordermodel(String id, String odritem, String orderdate, String orderamount) {
        this.id = id;
        this.odritem = odritem;
        this.orderdate = orderdate;
        this.orderamount = orderamount;

    }



    public String getId() {
        return id;
    }

    public String getOdritem() {
        return odritem;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public String getOrderamount() {
        return orderamount;
    }


}
