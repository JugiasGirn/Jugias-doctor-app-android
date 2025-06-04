package com.example.mylab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mylab.Adapter.Doctrecyle;
import com.example.mylab.Adapter.MedicalAdapter;

import java.util.ArrayList;
import java.util.List;

public class BuymedicalActivity extends AppCompatActivity {

    List<Medicalmodel> mlistmedict = new ArrayList<>();
RecyclerView Rlshop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buymedical);
        Rlshop =findViewById(R.id.Rlshop);
        getAdddata();
    }
    void getAdddata(){
        mlistmedict.add(new Medicalmodel("Malena Store","Pimpari","2000",R.mipmap.pharmacy));
        mlistmedict.add(new Medicalmodel("Sileca Store","Salon","1000",R.mipmap.pharmacy));
        mlistmedict.add(new Medicalmodel("Kapoor Store","Mk road","3000",R.mipmap.pharmacy));
        mlistmedict.add(new Medicalmodel("Testmed Store","Pimpari","1200",R.mipmap.pharmacy));
        mlistmedict.add(new Medicalmodel("Extended Store","J K road","1400",R.mipmap.pharmacy));
        mlistmedict.add(new Medicalmodel("Pharma Store","Piplani","1600",R.mipmap.pharmacy));
        mlistmedict.add(new Medicalmodel("Zest Store","Gujrat","1700",R.mipmap.pharmacy));

        MedicalAdapter doctrecyle = new MedicalAdapter(BuymedicalActivity.this,mlistmedict);
        Rlshop.setAdapter(doctrecyle);
    }


}