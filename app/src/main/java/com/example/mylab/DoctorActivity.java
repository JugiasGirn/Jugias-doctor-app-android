package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mylab.Adapter.Doctrecyle;

import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {

    List<doctormodel> mlistdoct = new ArrayList<>();
  RecyclerView Rldoct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Rldoct =findViewById(R.id.Rldoct);



        getAdddata();



    }


   void getAdddata(){
        mlistdoct.add(new doctormodel("Ajit Saste","Pimpari","5yrs","9898989898","600"));
        mlistdoct.add(new doctormodel("Mohan Raj","Nigdi","8yrs","9898989898","900"));
        mlistdoct.add(new doctormodel("Rohit Athare","Pimpari","10yrs","9898989898","500"));
        mlistdoct.add(new doctormodel("Dilip karkra","Pimpari","5yrs","9898989898","800"));
        mlistdoct.add(new doctormodel("Rani rajkare","Pimpari","7yrs","9898989898","500"));
        mlistdoct.add(new doctormodel("Ajit Saste","Pimpari","6yrs","9898989898","600"));
        mlistdoct.add(new doctormodel("Pankaj Raj","Pimpari","12yrs","9898989898","700"));
        mlistdoct.add(new doctormodel("Manish Malhotra","Pimpari","3yrs","9898989898","800"));
        mlistdoct.add(new doctormodel("Kaniak Kapoor","Pimpari","4yrs","9898989898","900"));
        mlistdoct.add(new doctormodel("Ajit ratre","Pimpari","7yrs","9898989898","600"));
        Doctrecyle doctrecyle = new Doctrecyle(mlistdoct,DoctorActivity.this);
        Rldoct.setAdapter(doctrecyle);
    }
}