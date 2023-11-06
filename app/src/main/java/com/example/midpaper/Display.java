package com.example.midpaper;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Display extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        dbHelper = new DatabaseHelper(this);
        ListView listView = findViewById(R.id.listView);

        // Get readable database
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Query the database for all records in the Users table
        String query = "SELECT * FROM " + DatabaseHelper.TABLE_USERS;
        Cursor cursor = db.rawQuery(query, null);

        List<String> dataList = new ArrayList<>();

        // Extract data and add it to the list
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PASSWORD));

            String dataString = "Name: " + name + "\nEmail: " + email + "\nPassword: " + password;
            dataList.add(dataString);
        }

        // Create an ArrayAdapter to display the data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // Close the cursor and the database
        cursor.close();
        db.close();
    }
}
