package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class rest_list extends AppCompatActivity {
    List<Restaurant> list=new ArrayList<Restaurant>();
    RecyclerView rvRests;
    restaurantAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_list);
        init();
        rvRests=findViewById(R.id.rvRests);
        adapter= new restaurantAdapter(list);
        rvRests.setHasFixedSize(true);
        rvRests.setLayoutManager(new LinearLayoutManager(this));
        rvRests.setAdapter(adapter);
    }



    public void init(){
        SharedPreferences sh=getSharedPreferences("restaurants", Context.MODE_PRIVATE);
        /*SharedPreferences.Editor editor= sh.edit();
        Restaurant r= new Restaurant("KFC", "02303040", "DHA Phase5", "Come for best fried chicken");
        editor.putString("KFC",r.toJson());
        r= new Restaurant("MacD", "02303043", "DHA Phase3", "Come for best fries");
        editor.putString("MacD",r.toJson());
        editor.apply();*/
        Map<String, ?> allEntries = sh.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            try {
                JSONObject jsonObject = new JSONObject((String) entry.getValue());
                String name = jsonObject.getString("name");
                String phone = jsonObject.getString("phone");
                String address = jsonObject.getString("address");
                String description = jsonObject.getString("description");
                Restaurant restaurant = new Restaurant(name, phone, address, description);
                list.add(restaurant);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Add(View v){
        Intent i = new Intent(getApplicationContext(), AddPage.class);
        startActivity(i);
        finish();
    }


}