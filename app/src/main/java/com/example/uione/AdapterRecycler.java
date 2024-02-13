package com.example.uione;
// AdapterRecycler.java

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {


    //he dogh final kele context & arraylist
    private final Context context;
    private final ArrayList<LinearPojo> arrayList;

    public AdapterRecycler(Context context, ArrayList<LinearPojo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_recycler_list, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        LinearPojo item = arrayList.get(position);
        holder.name.setText(item.getName());
        holder.address.setText(item.getAddress());

        // Load image using Glide library
        Glide.with(context)
                .load(item.getImageUrl())
                .placeholder(R.drawable.logo1) // Placeholder image while loading
                .error(R.drawable.b360) // Image to display in case of error
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

//
//    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//    @Override
//    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        LinearPojo item = arrayList.get(position);
//        holder.name.setText(item.getName());
//        holder.address.setText(item.getAddress());
//        Glide.with(context)
//                .load(item.getImageUrl())
//                .apply(RequestOptions.centerCropTransform())
//                .into(holder.imageView);
//    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView name, address;
        ImageView imageView;

        public MyHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            address = view.findViewById(R.id.address);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}

//// AdapterRecycler.java
//import android.content.Context;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//        import java.util.ArrayList;
//
//public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {
//
//    Context context;
//    ArrayList<LinearPojo> arrayList;
//
//    public AdapterRecycler(Context context, ArrayList<LinearPojo> arrayList) {
//        this.context = context;
//        this.arrayList = arrayList;
//    }
//
//
//
//
//    //jeva view tayar hoil teva hya  onCreateViewHolder ne custom_recycler_list view set hoil
//    @NonNull
//    @Override
//    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // Inflate the custom layout for each item
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_recycler_list, parent, false);
//        return new MyHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        // Bind data to TextViews in each item
//        holder.versionName.setText(arrayList.get(position).getVersionName());
//        holder.version.setText(arrayList.get(position).getVersion());
//    }
//
//    @Override
//    public int getItemCount() {
//        return arrayList.size();
//    }
//
//    // ViewHolder class to hold references to views
//    public static class MyHolder extends RecyclerView.ViewHolder {
//        TextView versionName, version;
//
//        public MyHolder(@NonNull View view) {
//            super(view);
//            versionName = view.findViewById(R.id.version_name);
//            version = view.findViewById(R.id.version);
//        }
//    }
//}
//
