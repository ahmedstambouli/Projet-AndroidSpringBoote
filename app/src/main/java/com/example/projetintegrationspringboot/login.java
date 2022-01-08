package com.example.projetintegrationspringboot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private SharedPreferences nPre;
    private SharedPreferences.Editor nEditor;
    private CheckBox nCheckBox;
    private EditText username, password;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password = findViewById(R.id.Password);
        username = findViewById(R.id.Email);
        btnlogin = findViewById(R.id.btnlogin);

        getSupportActionBar().hide();
        nPre = PreferenceManager.getDefaultSharedPreferences(this);
        nEditor = nPre.edit();
        checkSharedPreferences();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Username / Password Required", Toast.LENGTH_LONG).show();
                }else{
                    //proceed to login
                    login();
                }

            }
        });
    }

    private void checkSharedPreferences(){

        nCheckBox = findViewById(R.id.chekbox);

        String checkbox = nPre.getString(getString(R.string.chekbox),"False");
        String email = nPre.getString(getString(R.string.email),"");
        String p = nPre.getString(getString(R.string.password),"");
        username.setText(email);
        password.setText(p);
        if(checkbox.equals("True")){
            nCheckBox.setChecked(true);
        }else {
            nCheckBox.setChecked(false);
        }
    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            System.out.println("nice");
                        }
                    },700);

                }else{
                    Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),Fragmet.class));
            }
        });

       /* if (nCheckBox.isChecked()) {
            nEditor.putString(getString(R.string.chekbox), "True");
            nEditor.commit();
            String name = nEmail.getText().toString();
            nEditor.putString(getString(R.string.email), name);
            nEditor.commit();
            String password = nPass.getText().toString();
            nEditor.putString(getString(R.string.password), password);
            nEditor.commit();

        }
       // Toast.makeText(this, "this is " + nCheckBox.isChecked(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),Fragmet.class);

        startActivity(i);
*/

    }



    public void register(View v){
        Intent i = new Intent(getApplicationContext(),register.class);
        startActivity(i);
    }
}