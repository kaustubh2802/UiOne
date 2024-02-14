package com.example.uione;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView usernameTextView, passwordTextView;
    TextView batteryLevelTextView;
    BroadcastReceiver broadcastReceiver;
    SharedPreferences sharedPreferences;
    Button btn3;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide action bar
        setContentView(R.layout.activity_2);

        // Retrieve the username and password passed from the previous activity
//        String username = getIntent().getStringExtra("username");
//        String password = getIntent().getStringExtra("password");



        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);

        // Retrieve stored username and password from SharedPreferences
        String storedUsername = sharedPreferences.getString("username", "");
        String storedPassword = sharedPreferences.getString("password", "");

        // Initialize TextViews
        usernameTextView = findViewById(R.id.text_view1);
        passwordTextView = findViewById(R.id.text_view2);
        batteryLevelTextView = findViewById(R.id.batterylevel);

//        String username1=usernameTextView.toString().trim();
//        String password1=passwordTextView.toString().trim();

        // Set the username and password to the TextViews
        usernameTextView.setText("Username: " + storedUsername);
        passwordTextView.setText("Password: " + storedPassword);

        // Register BroadcastReceiver for battery level monitoring
        batteryLevel();


        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch Activity3
                Intent intent = new Intent(getApplicationContext(), Activity4.class);
                startActivity(intent);
            }
        });


    }

    // Method to monitor battery level
    private void batteryLevel() {
        broadcastReceiver = new BroadcastReceiver() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                batteryLevelTextView.setText(level + "%");
            }
        };

        // Register BroadcastReceiver with IntentFilter for ACTION_BATTERY_CHANGED
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister BroadcastReceiver when Activity is destroyed
        unregisterReceiver(broadcastReceiver);
    }
}
