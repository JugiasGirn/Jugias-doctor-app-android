package com.example.mylab.Adapter;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylab.R;
import com.example.mylab.doctormodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.List;

public class Doctrecyle extends RecyclerView.Adapter<Doctrecyle.Doct> {
    List<doctormodel> mlistdoc;
    Context mcontext;

    public Doctrecyle(List<doctormodel> mlistdoc, Context mcontext) {
        this.mlistdoc = mlistdoc;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public Doct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.doctlistcustom, parent, false);
        return new Doct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Doct holder, int position) {
        doctormodel doctmod = mlistdoc.get(position);
        holder.TVdocname.setText(doctmod.getDname());
        holder.TVdocexp.setText(doctmod.getExpre());
        holder.TVdocaddress.setText(doctmod.getHaddress());
        holder.TVdocfee.setText(doctmod.getFeecost());
        holder.TVdoccontact.setText(doctmod.getMobilenum());

        holder.Btdocappoint.setOnClickListener(view -> openDateTimePicker());
    }

    private void openDateTimePicker() {
        Calendar calendar = Calendar.getInstance();

        // Date Picker
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                mcontext,
                (view, year, month, dayOfMonth) -> {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    // Now open the time picker
                    openTimePicker(calendar);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void openTimePicker(Calendar calendar) {
        // Time Picker
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                mcontext,
                (view, hourOfDay, minute) -> {
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minute);

                    // Format the selected date and time
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault());
                    String selectedDateTime = sdf.format(calendar.getTime());

                    // Show a toast with the selected date and time
                    Toast.makeText(mcontext, "Your appointment has been booked on: " + selectedDateTime, Toast.LENGTH_SHORT).show();
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
        );
        timePickerDialog.show();
    }

    @Override
    public int getItemCount() {
        return mlistdoc.size();
    }

    public static class Doct extends RecyclerView.ViewHolder {

        TextView TVdocname, TVdocexp, TVdocaddress, TVdocfee, TVdoccontact;
        Button Btdocappoint;

        public Doct(@NonNull View itemView) {
            super(itemView);

            TVdocname = itemView.findViewById(R.id.TVdocname);
            TVdocexp = itemView.findViewById(R.id.TVdocexp);
            TVdocaddress = itemView.findViewById(R.id.TVdocaddress);
            TVdocfee = itemView.findViewById(R.id.TVdocfee);
            TVdoccontact = itemView.findViewById(R.id.TVdoccontact);
            Btdocappoint = itemView.findViewById(R.id.Btdocappoint);
        }
    }
}

