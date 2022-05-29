package com.example.kursach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    EditText tEmail;
    EditText tPhone;
    EditText tName;
    EditText tPass;
    TextView error_make;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        tEmail = findViewById(R.id.editTextTextEmailAddress2);
        tPhone  = findViewById(R.id.editTextPhone);
        tName = findViewById(R.id.editTextTextPersonName);
        tPass= findViewById(R.id.editTextTextPassword2);
        error_make = findViewById(R.id.textView5);
    }
    public void regOn(View view){
        if(TextUtils.isEmpty(tEmail.getText().toString())){
            error_make.setText("Введите вашу почту");
            return;
        }
        if(TextUtils.isEmpty(tPass.getText().toString())){
            error_make.setText("Введите пароль");
            return;
        }
        if(TextUtils.isEmpty(tName.getText().toString())){
            error_make.setText("Введите ваше Имя");
            return;
        }
        if(TextUtils.isEmpty(tPhone.getText().toString())){
            error_make.setText("Введите ваш телефон");
            System.out.println("Успех");
            return;
        }
        auth.createUserWithEmailAndPassword(tEmail.getText().toString(), tPass.getText().toString())
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    System.out.println("Успех222");
                    User user = new User();
                    user.setEmail(tEmail.getText().toString());
                    user.setName(tName.getText().toString());
                    user.setPass(tPass.getText().toString());
                    user.setPhone(tPhone.getText().toString());
                    users.child(user.getEmail()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            System.out.println("Успех");
                            to_next();
                        }
                    });
                }
            });
    }
    public void to_next(){
        Intent go_to;
        go_to = new Intent(this, MenuActivity.class);
        startActivity(go_to);
    }
}