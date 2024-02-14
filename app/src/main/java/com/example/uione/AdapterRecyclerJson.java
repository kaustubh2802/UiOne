package com.example.uione;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterRecyclerJson extends RecyclerView.Adapter<AdapterRecyclerJson.MyHolder> {
    Context context;
    ArrayList<PojoJson> empPojos;

    public AdapterRecyclerJson(Context context, ArrayList<PojoJson> empPojos){
        this.context = context;
        this.empPojos = empPojos;
    }

    @NonNull
    @Override
    public AdapterRecyclerJson.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cust_jsondata, parent, false);
        MyHolder myHolder;
        myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerJson.MyHolder holder, final int position) {
        holder.name.setText(empPojos.get(position).getName());
        holder.age.setText(empPojos.get(position).getAge());
        holder.city.setText(empPojos.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return empPojos.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{
        TextView name, age, city;

        public MyHolder(@NonNull View view){
            super(view);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            city = view.findViewById(R.id.city);
        }
    }
}
