package com.example.uione;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    ArrayList<LinearPojo> arrayList;
    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        initializeRecyclerView();
        loadData();

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity6.class);
                startActivity(intent);
            }
        });
    }

    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewLinear);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void loadData() {
        arrayList = new ArrayList<>();
        addSampleData();
        adapterRecycler = new AdapterRecycler(this, arrayList);
        recyclerView.setAdapter(adapterRecycler);
    }

    private void addSampleData() {
        // Add sample data (replace image URLs with actual URLs)
        arrayList.add(new LinearPojo("Suresh Joshi", "1234 ABC Road, Kolhapur, Maharashtra", R.drawable.imgview1));
        arrayList.add(new LinearPojo("Aarti Pawar", "456 XYZ Street, Nashik, Maharashtra", R.drawable.imgview2));
        arrayList.add(new LinearPojo("Rajesh Gavane", "789 PQR Nagar, Sangli, Maharashtra", R.drawable.imgview3));
        arrayList.add(new LinearPojo("Prajakta Deshmukh", "1011 MNO Colony, Ratnagiri, Maharashtra", R.drawable.imgview4));
        arrayList.add(new LinearPojo("Abhishek Patil", "222 Hilltop Road, Pune, Maharashtra", R.drawable.imgview5));
        arrayList.add(new LinearPojo("Smita Shah", "555 Shivaji Chowk, Nagpur, Maharashtra", R.drawable.imgview6));
        arrayList.add(new LinearPojo("Amol Chavan", "777 Sunrise Lane, Mumbai, Maharashtra", R.drawable.logo_microsoft));
        arrayList.add(new LinearPojo("Priya Desai", "888 River View Apartments, Thane, Maharashtra", R.drawable.logo1));

//        arrayList.add(new LinearPojo("Suresh", "Kolhapur", R.drawable.logo_microsoft));
//        arrayList.add(new LinearPojo("Aarti", "Nashik", R.drawable.b360));
//        arrayList.add(new LinearPojo("Rajesh", "Sangli", R.drawable.imgview1));
//        arrayList.add(new LinearPojo("Prajakta", "Ratnagiri", R.drawable.imgview2));

        // Add more data as needed
    }
}


/*
public class Activity4 extends AppCompatActivity {
    ArrayList<LinearPojo> arrayList;
    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;
    Button btn4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);


        // Initialize RecyclerView and data
        initializeRecyclerView();
        loadData();
        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch Activity3
                Intent intent = new Intent(getApplicationContext(), Activity5.class);
                startActivity(intent);
            }
        });

    }
    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewLinear);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    // Method to load data into RecyclerView
    private void loadData() {
        arrayList = new ArrayList<>();
        // Add sample data
        addSampleData();

        // Initialize adapter and set it to RecyclerView
        adapterRecycler = new AdapterRecycler(this, arrayList);
        recyclerView.setAdapter(adapterRecycler);
    }

    // Method to add sample data
    private void addSampleData() {
        arrayList.add(new LinearPojo("Android 11", "11"));
        arrayList.add(new LinearPojo("Android 10", "10.0"));
        // Add more versions as needed
    }


}*/