package com.example.mylab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylab.R;
import com.example.mylab.doctormodel;

import java.util.List;

public class Labadapter extends RecyclerView.Adapter<Labadapter.Lab>{

    List<doctormodel> mlistdoc;
    Context mcontext;

    public Labadapter(List<doctormodel> mlistdoc, Context mcontext) {
        this.mlistdoc = mlistdoc;
        this.mcontext = mcontext;
    }




    @NonNull
    @Override
    public Labadapter.Lab onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.doctlistcustom,parent,false);
        return new Labadapter.Lab(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Lab holder, int position) {
        doctormodel doctmod = mlistdoc.get(position);

        holder.TVdocname.setText(doctmod.getDname());
        holder.TVdocexp.setText(doctmod.getExpre());
        holder.TVdocaddress.setText(doctmod.getHaddress());
        holder.TVdocfee.setText(doctmod.getFeecost());
        holder.TVdoccontact.setText(doctmod.getMobilenum());
        holder.Btdocappoint.setOnClickListener(view -> Toast.makeText(mcontext,"Lab Booking is Succesfully!",Toast.LENGTH_SHORT).show());

    }



    @Override
    public int getItemCount() {
        return mlistdoc.size();
    }

    public static class Lab extends RecyclerView.ViewHolder{

        TextView TVdocname,TVdocexp,TVdocaddress,TVdocfee,TVdoccontact,Btdocappoint;


        public Lab(@NonNull View itemView) {
            super(itemView);

            TVdocname =itemView.findViewById(R.id.TVdocname);
            TVdocexp =itemView.findViewById(R.id.TVdocexp);
            TVdocaddress =itemView.findViewById(R.id.TVdocaddress);
            TVdocfee =itemView.findViewById(R.id.TVdocfee);
            TVdoccontact =itemView.findViewById(R.id.TVdoccontact);
            Btdocappoint =itemView.findViewById(R.id.Btdocappoint);
        }
    }
}
