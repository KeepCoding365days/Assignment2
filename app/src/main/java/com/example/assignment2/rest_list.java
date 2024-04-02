package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class rest_list extends AppCompatActivity {
    ArrayList<Restaurant> list;
    RecyclerView rvRests;
    restaurantAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_list);
        init();
        adapter= new restaurantAdapter(list);
        rvRests.setHasFixedSize(true);
        rvRests.setLayoutManager(new LinearLayoutManager(this));
        rvRests.setAdapter(adapter);

    }
    private void init()
    {
        list = new ArrayList<>();
        list.add(new Restaurant("KFC", "02303040", "DHA Phase5", "Come for best fried chicken"));
        list.add(new Restaurant("MCD", "02303034", "DHA Phase8", "Come for best burger"));
        list.add(new Restaurant("KFC", "02303040", "DHA Phase5", "Come for best fried chicken"));
        list.add(new Restaurant("MCD", "02303034", "DHA Phase8", "Come for best burger"));
        rvRests=findViewById(R.id.rvRests);
    }
    public void addRest(View v){
        list.add(new Restaurant("KFC", "02303040", "DHA Phase5", "Come for best fried chicken"));
        setContentView(R.layout.activity_rest_list);
        adapter= new restaurantAdapter(list);
        rvRests.setHasFixedSize(true);
        rvRests.setLayoutManager(new LinearLayoutManager(this));
        rvRests.setAdapter(adapter);
    }

}