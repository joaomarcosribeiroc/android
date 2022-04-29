package com.example.gotz;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to  convert other object type to room supported types*/

public class Converters {
    /**This method convert a List object into JSON format using Google Gson library*/
    @TypeConverter
    public String fromIntegerArrayListToJson(ArrayList<Integer> List){
        if(List == null){return null;}
        String ListJSON;
        Gson gson = new Gson();
        ListJSON = gson.toJson(List);
        return ListJSON;
    }
    /**This method convert a JSON string to a List using Google Gson library*/
    @TypeConverter
    public ArrayList<Integer> toIntegerArrayListfromJson(String ListJSON){
        ArrayList<Integer> IDFieldList = new ArrayList<>();
        Gson gson = new Gson();
        /*Here I'll get the type of the class which the data from JSON string is from*/
        Type type = new TypeToken<ArrayList<Integer>>(){}.getType();
        IDFieldList = gson.fromJson(ListJSON, type);
        return IDFieldList;
    }
    @TypeConverter
    public String fromIntegerListToJson(List<Integer> List){
        if(List == null){return null;}
        String ListJSON;
        Gson gson = new Gson();
        ListJSON = gson.toJson(List);
        return ListJSON;
    }
    /**This method convert a JSON string to a List using Google Gson library*/
    @TypeConverter
    public List<Integer> toIntegerListfromJson(String ListJSON){
        List<Integer> IDFieldList = new ArrayList<>();
        Gson gson = new Gson();
        /*Here I'll get the type of the class which the data from JSON string is from*/
        Type type = new TypeToken<List<Integer>>(){}.getType();
        IDFieldList = gson.fromJson(ListJSON, type);
        return IDFieldList;
    }

}
