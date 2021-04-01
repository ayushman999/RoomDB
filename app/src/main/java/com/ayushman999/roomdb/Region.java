package com.ayushman999.roomdb;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "region_table")
public class Region {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name="array")
    public ArrayList<String> array;
    public Region(@NonNull String name)
    {
        this.name=name;
    }


    public String getName() {
        return name;
    }
    public ArrayList<String> getArray(){return array;}
    /*@ColumnInfo(name="borders")
    public ArrayList<String> borders;*/
}
