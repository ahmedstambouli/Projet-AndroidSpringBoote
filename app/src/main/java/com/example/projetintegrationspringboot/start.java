package com.example.projetintegrationspringboot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
    }
    public void onClick(View v){
        Intent i = new Intent(getApplicationContext(),login.class);
        startActivity(i);
    }
}