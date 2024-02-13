package com.example.uione;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class Activity5 extends AppCompatActivity {

    ArrayList arrayList1;
//    ArrayList<GridPojo> arrayList1;
    RecyclerView recyclerView1;
    GridItemAdapter adapterRecycler1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        gridListData();

        recyclerView1 = findViewById(R.id.recyclerViewLinear);
        recyclerView1.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(gridLayoutManager);

        adapterRecycler1 = new GridItemAdapter(this, arrayList1);
        recyclerView1.setAdapter(adapterRecycler1);
    }

    private void gridListData(){
        arrayList1 = new ArrayList<GridPojo>();

        // Add your data here
        arrayList1.add(new GridPojo("Mobile", R.drawable.ic_baseline_smartphone_24));
        arrayList1.add(new GridPojo("Internet", R.drawable.ic_baseline_public_24));
        arrayList1.add(new GridPojo("Data Exploration", R.drawable.ic_baseline_data_exploration_24));
        arrayList1.add(new GridPojo("Database", R.drawable.ic_baseline_airport_shuttle_24));
        arrayList1.add(new GridPojo("Battery", R.drawable.ic_battery));
        arrayList1.add(new GridPojo("Alarm", R.drawable.ic_lock));
        arrayList1.add(new GridPojo("Signal", R.drawable.ic_8k));
    }
}

