package com.example.gotz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gotz.Database.MyRoomDataBase;

public class MainActivity extends AppCompatActivity {
    public static MyRoomDataBase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDB = MyRoomDataBase.getFileDatabase(getApplicationContext());
        setContentView(R.layout.activity_main);
    }

    public void callTestingActivity(View v){
        Intent intent = new Intent(this, Activity_Testing.class);
        startActivity(intent);
    }
}