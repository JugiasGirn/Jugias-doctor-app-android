package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mylab.Adapter.Healthadapter;

import java.util.ArrayList;
import java.util.List;

public class HealthActivity extends AppCompatActivity {
    List<String> mlisttitle = new ArrayList<>();
  public  RecyclerView RLhealth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        RLhealth =findViewById(R.id.RLhealth);
        addtitledata();
    }


    void addtitledata(){
        mlisttitle.clear();
        mlisttitle.add("Statins Can Help Women With Breast Cancer, Study Finds");
        mlisttitle.add("3 Most Effective Ways to Treat Obesity");
        mlisttitle.add("Exercise May Help Treat and Prevent Postpartum Depression, Study Finds");
        Healthadapter healthadapter = new Healthadapter(mlisttitle,HealthActivity.this, HealthActivity.this);
        RLhealth.setVisibility(View.VISIBLE);
        RLhealth.setAdapter(healthadapter);
    }
}