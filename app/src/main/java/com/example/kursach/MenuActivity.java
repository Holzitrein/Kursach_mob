package com.example.kursach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }
    public void onClickCalc(View view){
        Intent go_to;
        go_to = new Intent(this, CalcActivity.class);
        startActivity(go_to);
    }
    public void onClickData(View view){
        Intent go_to;
        go_to = new Intent(this, DataActivity.class);
        startActivity(go_to);
    }
    public void onClickimg1(View view){
        Intent go_to;
        go_to = new Intent(this, Stat1Activity.class);
        startActivity(go_to);
    }
    public void onClickimg2(View view){
        Intent go_to;
        go_to = new Intent(this, Stat2Activity.class);
        startActivity(go_to);
    }
    public void onClickimg3(View view){
        Intent go_to;
        go_to = new Intent(this, Stat3Activity.class);
        startActivity(go_to);
    }



}