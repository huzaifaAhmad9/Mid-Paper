package com.example.midpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user, pass, email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.userName);
        pass = findViewById(R.id.userPassword);
        email = findViewById(R.id.userEmail);
        btn = findViewById(R.id.saveButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = user.getText().toString();
                String emailValue = email.getText().toString();
                String passwordValue = pass.getText().toString();

                if (TextUtils.isEmpty(nameValue) || TextUtils.isEmpty(emailValue) || TextUtils.isEmpty(passwordValue)) {
                    // Check if any of the fields are empty and display a Toast.
                    Toast.makeText(MainActivity.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else {
                    // All fields are filled, proceed to save the data.
                    DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put("name", nameValue);
                    values.put("email", emailValue);
                    values.put("password", passwordValue);

                    long newRowId = db.insert("Users", null, values);

                    if (newRowId != -1) {
                        // Data successfully inserted.
                        Toast.makeText(MainActivity.this, "User added successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Trip.class);
                        startActivity(intent);
                    } else {
                        // Error occurred while inserting data.
                        Toast.makeText(MainActivity.this, "Failed to add user. Please try again.", Toast.LENGTH_SHORT).show();
                    }

                    db.close();
                }
            }
        });
    }
}
