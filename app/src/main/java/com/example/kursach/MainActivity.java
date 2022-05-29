package com.example.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickLogin(View view){
        Intent go_to;
        go_to = new Intent(this, LoginActivity.class);
        startActivity(go_to);
    }
    public void onClickReg(View view){
        Intent go_to;
        go_to = new Intent(this, RegActivity.class);
        startActivity(go_to);
    }
}