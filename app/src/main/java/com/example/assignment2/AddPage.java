package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);
    }
    public void AddRest(View v){
        String name,address,phone,desc;
        TextView text= findViewById(R.id.rNameInput);
        name= text.getText().toString();

        text=findViewById(R.id.rAddressInput);
        address=text.getText().toString();
        text=findViewById(R.id.rPhoneInput);
        phone=text.getText().toString();
        text=findViewById(R.id.rDescInput);
        desc=text.getText().toString();

        Restaurant r= new Restaurant(name,phone,address,desc);

        SharedPreferences sh= getSharedPreferences("restaurants", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sh.edit();
        editor.putString(name,r.toJson());
        editor.apply();

        Intent i=new Intent(getApplicationContext(),rest_list.class);
        startActivity(i);
        finish();

    }

}