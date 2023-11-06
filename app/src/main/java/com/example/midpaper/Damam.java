package com.example.midpaper;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Damam extends AppCompatActivity {
    Button btn2,btn3;
    private Button datePickerButton;
    private Button timePickerButton;
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damam);
        datePickerButton = findViewById(R.id.datePickerButton);
        btn3 = findViewById(R.id.see);
        timePickerButton = findViewById(R.id.timePickerButton);
        btn2 = findViewById(R.id.submit);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the booking confirmation
                Toast.makeText(Damam.this, "BOOKING HAS BEEN CONFIRMED!!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Damam.this, Trip.class);
                startActivity(intent);
                finish();
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Damam.this, Display.class);
                startActivity(intent);
                finish();
            }
        });



        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show initial message to select a date
                Toast.makeText(Damam.this, "Select a date", Toast.LENGTH_SHORT).show();
                showDatePicker();
            }
        });

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show initial message to select a time
                Toast.makeText(Damam.this, "Select a time", Toast.LENGTH_SHORT).show();
                showTimePicker();
            }
        });
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Handle the selected date
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                datePickerButton.setText(selectedDate);

                // Show a success message
                Toast.makeText(Damam.this, "Date set successfully: " + selectedDate, Toast.LENGTH_SHORT).show();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    private void showTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Handle the selected time
                String selectedTime = String.format("%02d:%02d", hourOfDay, minute);
                timePickerButton.setText(selectedTime);

                // Show a success message
                Toast.makeText(Damam.this, "Time set successfully: " + selectedTime, Toast.LENGTH_SHORT).show();
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);

        timePickerDialog.show();
    }
}
