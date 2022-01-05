package com.example.projetintegrationspringboot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private SharedPreferences nPre;
    private SharedPreferences.Editor nEditor;
    private CheckBox nCheckBox;
    private EditText nEmail, nPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        nPre = PreferenceManager.getDefaultSharedPreferences(this);
        nEditor = nPre.edit();
        checkSharedPreferences();
    }

    private void checkSharedPreferences(){
        nPass = findViewById(R.id.Password);
        nEmail = findViewById(R.id.Email);
        nCheckBox = findViewById(R.id.chekbox);

        String checkbox = nPre.getString(getString(R.string.chekbox),"False");
        String email = nPre.getString(getString(R.string.email),"");
        String password = nPre.getString(getString(R.string.password),"");
        nEmail.setText(email);
        nPass.setText(password);
        if(checkbox.equals("True")){
            nCheckBox.setChecked(true);
        }else {
            nCheckBox.setChecked(false);
        }
    }

    public void login(View v) {

       /* if (nCheckBox.isChecked()) {
            nEditor.putString(getString(R.string.chekbox), "True");
            nEditor.commit();
            String name = nEmail.getText().toString();
            nEditor.putString(getString(R.string.email), name);
            nEditor.commit();
            String password = nPass.getText().toString();
            nEditor.putString(getString(R.string.password), password);
            nEditor.commit();

        }*/
        Toast.makeText(this, "this is " + nCheckBox.isChecked(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),Fragmet.class);

        startActivity(i);


    }
    public void register(View v){
        Intent i = new Intent(getApplicationContext(),register.class);
        startActivity(i);
    }
}