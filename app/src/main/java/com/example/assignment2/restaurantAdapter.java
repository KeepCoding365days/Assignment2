package com.example.assignment2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class restaurantAdapter extends RecyclerView.Adapter<restaurantAdapter.ViewHolder> {
    List<Restaurant> restaurants;
    public restaurantAdapter(List<Restaurant> list){
        restaurants=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.restaurant,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rDesc.setText(restaurants.get(position).description);
        holder.rLocation.setText(restaurants.get(position).location);
        holder.rName.setText(restaurants.get(position).name);
        holder.rPhone.setText(restaurants.get(position).phone);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rName,rLocation,rPhone,rDesc;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            rName=itemView.findViewById(R.id.rName);
            rDesc=itemView.findViewById(R.id.rDesc);
            rLocation=itemView.findViewById(R.id.rLocation);
            rPhone=itemView.findViewById(R.id.rPhone);
        }
    }
}
