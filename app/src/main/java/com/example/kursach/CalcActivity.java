package com.example.kursach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class CalcActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MyFragmetAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        tabLayout = findViewById(R.id.TabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("Калл"));
        tabLayout.addTab(tabLayout.newTab().setText("ИМТ"));
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new MyFragmetAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
    EditText znach1;
    EditText znach2;
    TextView otvet;
    Button button;
    public void onClickotvet1(View view){
        button = (Button) findViewById(R.id.button9);
        znach1 = findViewById(R.id.editTextTextPersonName5);
        znach2 = findViewById(R.id.editTextTextPersonName4);
        otvet = findViewById(R.id.textView12);
        float result = 0;
        result = (Float.parseFloat(znach1.getText().toString()));
        result = (Float.parseFloat(znach2.getText().toString())) * 1000 / (result * result);
        otvet.setText( Float.toString(result));
    }

    EditText znach3;
    EditText znach4;
    EditText znach5;
    TextView otvet2;
    Button button2;
    public void onClickotvet2(View view){
        button2 = (Button) findViewById(R.id.button10);
        znach3 = findViewById(R.id.editTextTextPersonName6);
        znach4 = findViewById(R.id.editTextTextPersonName7);
        znach5 = findViewById(R.id.editTextTextPersonName9);
        otvet2 = findViewById(R.id.textView13);
        double result = 0;
        float a = Float.parseFloat(znach3.getText().toString());
        float b = Float.parseFloat(znach4.getText().toString());
        float c = Float.parseFloat(znach5.getText().toString());
        result = ((a * 10) + (6.25 * b) - (c * 5) + 5);
        otvet2.setText( Double.toString(result));
    }
}


