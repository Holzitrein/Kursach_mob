package com.example.kursach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    EditText tEmail;
    EditText tPass;
    TextView error_make;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");
        tEmail = findViewById(R.id.editTextTextEmailAddress);
        tPass = findViewById(R.id.editTextTextPassword);
        error_make = findViewById(R.id.textView3);
    }
    public void LogIn(View view){
        if(TextUtils.isEmpty(tEmail.getText().toString())){
            error_make.setText("Введите вашу почту");
            return;
        }
        if(TextUtils.isEmpty(tPass.getText().toString())){
            error_make.setText("Введите пароль");
            return;
        }
        auth.signInWithEmailAndPassword(tEmail.getText().toString(),tPass.getText().toString())
            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    to_next();
                }
            }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                error_make.setText("Неверный пароль");
            }
        });

    }
    public void to_next(){
        Intent go_to;
        go_to = new Intent(this, MenuActivity.class);
        startActivity(go_to);
    }
}