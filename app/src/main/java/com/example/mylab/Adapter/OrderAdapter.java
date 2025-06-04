package com.example.mylab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylab.Ordermodel;
import com.example.mylab.R;

import java.util.List;

public class OrderAdapter  extends RecyclerView.Adapter<OrderAdapter.Order>{

    Context mcontex;
    List<Ordermodel> mlistorder;

    public OrderAdapter(Context mcontex, List<Ordermodel> mlistorder) {
        this.mcontex = mcontex;
        this.mlistorder = mlistorder;
    }





    @NonNull
    @Override
    public Order onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(mcontex).inflate(R.layout.orderlistcust,parent,false);

        return new Order(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Order holder, int position) {
        Ordermodel ordermodel = mlistorder.get(position);

        holder.TVdocname.setText(ordermodel.getId());
        holder.TVdocexp.setText(ordermodel.getOrderdate());
        holder.TVdocaddress.setText(ordermodel.getOrderamount());
        holder.TVname.setText(ordermodel.getOdritem());


    }

    @Override
    public int getItemCount() {
        return mlistorder.size();
    }

    public static class Order extends RecyclerView.ViewHolder{
        TextView TVdocname,TVdocexp,TVdocaddress,TVname;

        public Order(@NonNull View itemView) {
            super(itemView);
            TVdocname =itemView.findViewById(R.id.TVdocname);
            TVdocexp =itemView.findViewById(R.id.TVdocexp);
            TVdocaddress =itemView.findViewById(R.id.TVdocaddress);
            TVname =itemView.findViewById(R.id.TVname);
        }
    }
}
