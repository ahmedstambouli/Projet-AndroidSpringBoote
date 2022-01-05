package com.example.projetintegrationspringboot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Fragmet extends AppCompatActivity {
    BottomNavigationView btnV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmet);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfilFragment()).commit();
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.B1)));

        btnV=(BottomNavigationView)findViewById(R.id.bottom_navigation);
        btnV.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                Fragment temp=null;

                switch (item.getItemId()){

                    case R.id.nav_pers:temp=new ProfilFragment();
                        break;
                    case R.id.nav_listestage:temp=new offredestageFragment();
                        break;
                    case R.id.nav_baskete:temp=new demandedestageFragment();

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,temp).commit();


            }
        });
    }
}