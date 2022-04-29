package com.example.gotz.Database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

//Here I need to add all the Entities that will be a table part of my database
@Database(entities = {
        TestStandardEntity.class,
        TestDataEntity.class},
        version = 1, exportSchema = false)
public abstract class MyRoomDataBase extends RoomDatabase {

    public static MyRoomDataBase INSTANCE;

    //For each table in the database I will create one abstract method
    public abstract TestStandardDao testStandardDao();
    public abstract TestDataDao testDataDao();

    public static MyRoomDataBase getInMemoryDatabase(Context context){

        if(INSTANCE== null){
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),MyRoomDataBase.class).build();
        }
        return INSTANCE;
    }
    public static MyRoomDataBase getFileDatabase  (Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyRoomDataBase.class, "ColetaDataBase").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){ INSTANCE=null;}
}
