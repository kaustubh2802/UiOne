package com.example.uione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.btn2);

        // Retrieve stored username and password from SharedPreferences
        String storedUsername = sharedPreferences.getString("username", "");
        String storedPassword = sharedPreferences.getString("password", "");

        // Set the retrieved values to EditText fields
        usernameEditText.setText(storedUsername);
        passwordEditText.setText(storedPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = usernameEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();

                if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                } else if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", storedUsername);
                    editor.putString("password", storedPassword);
                    editor.apply();


                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
//                    intent.putExtra("username", storedUsername);
//                    intent.putExtra("password", storedPassword);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
