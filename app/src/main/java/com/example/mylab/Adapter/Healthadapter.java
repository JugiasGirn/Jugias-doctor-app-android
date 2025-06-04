package com.example.mylab.Adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylab.HealthActivity;
import com.example.mylab.R;
import com.example.mylab.doctormodel;
import com.example.mylab.fragment.FragmentHealthone;
import com.example.mylab.fragment.Fragtwo;

import java.util.List;

public class Healthadapter extends RecyclerView.Adapter<Healthadapter.Lab>{

    List<String> mlistdoc;
    Context mcontext;
    HealthActivity healthActivity;

    public Healthadapter(List<String> mlistdoc, Context mcontext, HealthActivity healthActivity) {
        this.mlistdoc = mlistdoc;
        this.mcontext = mcontext;
        this.healthActivity =healthActivity;
    }




    @NonNull
    @Override
    public Healthadapter.Lab onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.healthcustom,parent,false);
        return new Healthadapter.Lab(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Healthadapter.Lab holder, int position) {
        String doctmod = mlistdoc.get(position);

        holder.TVdocname.setText(doctmod);

        holder.CVhealth.setOnClickListener(view -> {
            Fragment fragment = new FragmentHealthone();
            Fragment fragment1 = new Fragtwo();
           // Fragment fragment = new FragmentHealthone();

            healthActivity.RLhealth.setVisibility(View.GONE);
            if(position ==0) {
                ((Activity) mcontext).getFragmentManager().beginTransaction().replace(R.id.Fllay, fragment).commit();
            }else{
                ((Activity) mcontext).getFragmentManager().beginTransaction().replace(R.id.Fllay, fragment1).commit();
            }
           // ((Activity) mcontext).getFragmentManager().getPrimaryNavigationFragment(R.id.Fllay, fragment);
          // ((Activity) mcontext).getFragmentManager().getPrimaryNavigationFragment().getExitTransition().

        });



    }



    @Override
    public int getItemCount() {
        return mlistdoc.size();
    }

    public static class Lab extends RecyclerView.ViewHolder{

        TextView TVdocname;
        CardView CVhealth;


        public Lab(@NonNull View itemView) {
            super(itemView);


            TVdocname =itemView.findViewById(R.id.TVdocname);
            CVhealth =itemView.findViewById(R.id.CVhealth);
        }
    }
}
