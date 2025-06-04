package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mylab.Adapter.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    RecyclerView RLorder;
    List<Ordermodel> mlistorder = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        RLorder =findViewById(R.id.RLorder);
        getadata();
    }


    void getadata(){
        mlistorder.add(new Ordermodel("102","Abc","10/11/22","500"));
        mlistorder.add(new Ordermodel("109","Ajit Saste","10/11/22","600"));
        mlistorder.add(new Ordermodel("204","Abc","15/11/22","4500"));
        mlistorder.add(new Ordermodel("456","Dilip karkra","08/11/22","800"));
        mlistorder.add(new Ordermodel("505","PathLab","18/11/22","7500"));

        OrderAdapter orderAdapter = new OrderAdapter(OrderActivity.this,mlistorder);
        RLorder.setAdapter(orderAdapter);

    }
}