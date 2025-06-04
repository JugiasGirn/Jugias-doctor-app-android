package com.example.mylab.Adapter;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylab.Medicalmodel;
import com.example.mylab.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MedicalAdapter extends RecyclerView.Adapter<MedicalAdapter.Medical> {
    Context mcontext;
    List<Medicalmodel> mlistmed;

    public MedicalAdapter(Context mcontext, List<Medicalmodel> mlistmed) {
        this.mcontext = mcontext;
        this.mlistmed = mlistmed;
    }

    @NonNull
    @Override
    public Medical onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.medicalstore, parent, false);
        return new Medical(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Medical holder, int position) {
        Medicalmodel medModel = mlistmed.get(position);

        holder.TVdocname.setText(medModel.getMname());
        holder.TVdocaddress.setText(medModel.getMaddress());
        holder.TVdocfee.setText(medModel.getMinorderamt());

        // Set up onClickListener for the appointment button
        holder.Btdocappoint.setOnClickListener(view -> openDateTimePicker());
    }

    @Override
    public int getItemCount() {
        return mlistmed.size();
    }

    public static class Medical extends RecyclerView.ViewHolder {
        TextView TVdocname, TVdocaddress, TVdocfee, TVdoccontact, Btdocappoint;

        public Medical(@NonNull View itemView) {
            super(itemView);

            TVdocname = itemView.findViewById(R.id.TVdocname);
            TVdocaddress = itemView.findViewById(R.id.TVdocaddress);
            TVdocfee = itemView.findViewById(R.id.TVdocfee);
            TVdoccontact = itemView.findViewById(R.id.TVdoccontact);
            Btdocappoint = itemView.findViewById(R.id.Btdocappoint);
        }
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
                    Toast.makeText(mcontext, "your order will be placed on Selected Date and Time: " + selectedDateTime, Toast.LENGTH_SHORT).show();
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
        );
        timePickerDialog.show();
    }
}