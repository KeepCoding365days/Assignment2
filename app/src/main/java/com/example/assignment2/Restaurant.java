package com.example.assignment2;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class Restaurant {
    public int uid;

    public String name;

    public String phone;


    public String location;

    @ColumnInfo(name="description")
    public String description;

    public String toJson() {
        return "{" +
                "\"name\":\"" + name + "\"," +
                "\"phone\":\"" + phone + "\"," +
                "\"address\":\"" + location + "\"," +
                "\"description\":\"" + description + "\"" +
                "}";
    }
    public Restaurant(String name, String phone, String location, String description){
        this.name=name;
        this.phone=phone;
        this.location=location;
        this.description=description;
    }
}


