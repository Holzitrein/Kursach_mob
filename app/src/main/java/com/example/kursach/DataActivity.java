package com.example.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    SQLiteDatabase db;
    TextView we;
    TextView ro;
    TextView IMT;
    TextView we_mean;
    EditText ed_wei;
    EditText ed_rost;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        we = findViewById(R.id.textView6);
        ro = findViewById(R.id.textView9);
        IMT = findViewById(R.id.textView10);
        we_mean = findViewById(R.id.textView11);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (num INTEGER, wei INTEGER, rost INTEGER, UNIQUE(num))");
        db.execSQL("INSERT OR IGNORE INTO users VALUES (1, 70, 180), (2, 72, 180);");

    }
    public void onClickShow(View view){
        we = findViewById(R.id.textView6);
        ro = findViewById(R.id.textView9);
        IMT = findViewById(R.id.textView10);
        we_mean = findViewById(R.id.textView11);
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        int weit = 0;
        int ros = 0;
        float mean = 1;
        int iter = 0;
        float im = 0;
        while(query.moveToNext()){
            weit = query.getInt(1);
            ros = query.getInt(2);
            iter++;
            mean += weit;
        }
        im = (ros^2);
        String weit_s = String.valueOf(weit);
        String ros_s = String.valueOf(ros);
        String IMT_s = String.valueOf(im);
        mean = mean / iter;
        String mean_s = String.valueOf(mean);
        we.setText(("Вес: " + weit_s).toString());
        ro.setText(("Рост: " + ros_s).toString());
        IMT.setText(("ИМТ: " + IMT_s).toString());
        we_mean.setText(("Средний вес за всё время: " + mean_s).toString());
    }
    public void onClickUp(View view){
        int weit = 0;
        int ros = 0;
        float mean = 1;
        int iter = 0;
        float im = 0;

        we = findViewById(R.id.textView6);
        ro = findViewById(R.id.textView9);
        IMT = findViewById(R.id.textView10);
        we_mean = findViewById(R.id.textView11);

        ed_wei = findViewById(R.id.editTextTextPersonName2);
        ed_rost = findViewById(R.id.editTextTextPersonName3);
        weit = Integer.parseInt(String.valueOf(ed_wei.getText()));
        ros = Integer.parseInt(String.valueOf(ed_rost.getText()));
        ContentValues newValues = new ContentValues();
        newValues.put("wei", weit);
        newValues.put("ROST", ros);
        System.out.println("111");
        Cursor query = db.rawQuery("SELECT * FROM users;", null);

        while(query.moveToNext()){
            weit = query.getInt(1);
            ros = query.getInt(2);
            iter++;
            mean += weit;
        }
        newValues.put("num", iter);

        db.insert("users", null, newValues);
        im = (ros^2);
        String weit_s = String.valueOf(weit);
        String ros_s = String.valueOf(ros);
        String IMT_s = String.valueOf(im);
        mean = mean / iter;
        String mean_s = String.valueOf(mean);
        we.setText(("Вес: " + weit_s).toString());
        ro.setText(("Рост: " + ros_s).toString());
        IMT.setText(("ИМТ: " + IMT_s).toString());
        we_mean.setText(("Средний вес за всё время: " + mean_s).toString());
    }
}