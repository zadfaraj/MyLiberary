package com.mylibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainPage extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    FrameLayout frameLayout;
    Button btnprofile, btncategory, btnsoti, btnhame;
    TextView txtprofile, txtcategory, txtsoti, txthame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        frameLayout = findViewById(R.id.act_mnpage_fholder);
        btnprofile = findViewById(R.id.act_mnpage_prof);
        btncategory = findViewById(R.id.act_mnpage_category);
        btnsoti = findViewById(R.id.act_mnpage_soti);
        btnhame = findViewById(R.id.act_mnpage_hame);
        txtprofile = findViewById(R.id.act_mnpage_p);
        txtcategory = findViewById(R.id.act_mnpage_c);
        txtsoti = findViewById(R.id.act_mnpage_s);
        txthame = findViewById(R.id.act_mnpage_h);

        Objects.requireNonNull(getSupportActionBar()).hide();

        btnprofile.setBackgroundResource(R.drawable.ic_action_profile_yellow);
        txtprofile.setTextColor(Color.parseColor("#FFE082"));
        btnsoti.setBackgroundResource(R.drawable.ic_action_soti_light);
        txtsoti.setTextColor(Color.parseColor("#acacac"));
        btnhame.setBackgroundResource(R.drawable.ic_action_hame_light);
        txthame.setTextColor(Color.parseColor("#acacac"));
        btncategory.setBackgroundResource(R.drawable.ic_action_category_light);
        txtcategory.setTextColor(Color.parseColor("#acacac"));

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.act_mnpage_fholder, new Profile());
        ft.commit();

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.act_mnpage_fholder, new Profile());
                ft.commit();

                btnprofile.setBackgroundResource(R.drawable.ic_action_profile_yellow);
                txtprofile.setTextColor(Color.parseColor("#FFE082"));
                btnsoti.setBackgroundResource(R.drawable.ic_action_soti_light);
                txtsoti.setTextColor(Color.parseColor("#acacac"));
                btnhame.setBackgroundResource(R.drawable.ic_action_hame_light);
                txthame.setTextColor(Color.parseColor("#acacac"));
                btncategory.setBackgroundResource(R.drawable.ic_action_category_light);
                txtcategory.setTextColor(Color.parseColor("#acacac"));
            }
        });

        btnsoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.act_mnpage_fholder, new Soti());
                ft.commit();

                btnprofile.setBackgroundResource(R.drawable.ic_action_profile_light);
                txtprofile.setTextColor(Color.parseColor("#acacac"));
                btnsoti.setBackgroundResource(R.drawable.ic_action_soti_yellow);
                txtsoti.setTextColor(Color.parseColor("#FFE082"));
                btnhame.setBackgroundResource(R.drawable.ic_action_hame_light);
                txthame.setTextColor(Color.parseColor("#acacac"));
                btncategory.setBackgroundResource(R.drawable.ic_action_category_light);
                txtcategory.setTextColor(Color.parseColor("#acacac"));
            }
        });

        btnhame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.act_mnpage_fholder, new Hame());
                ft.commit();

                btnprofile.setBackgroundResource(R.drawable.ic_action_profile_light);
                txtprofile.setTextColor(Color.parseColor("#acacac"));
                btnsoti.setBackgroundResource(R.drawable.ic_action_soti_light);
                txtsoti.setTextColor(Color.parseColor("#acacac"));
                btnhame.setBackgroundResource(R.drawable.ic_action_hame_yellow);
                txthame.setTextColor(Color.parseColor("#FFE082"));
                btncategory.setBackgroundResource(R.drawable.ic_action_category_light);
                txtcategory.setTextColor(Color.parseColor("#acacac"));
            }
        });

        btncategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.act_mnpage_fholder, new Category());
                ft.commit();

                btnprofile.setBackgroundResource(R.drawable.ic_action_profile_light);
                txtprofile.setTextColor(Color.parseColor("#acacac"));
                btnsoti.setBackgroundResource(R.drawable.ic_action_soti_light);
                txtsoti.setTextColor(Color.parseColor("#acacac"));
                btnhame.setBackgroundResource(R.drawable.ic_action_hame_light);
                txthame.setTextColor(Color.parseColor("#acacac"));
                btncategory.setBackgroundResource(R.drawable.ic_action_category_yellow);
                txtcategory.setTextColor(Color.parseColor("#FFE082"));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "برای خروج دوباره کلیک کنید!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void btn_darkhaste_ketab (View view) {

        startActivity(new Intent(MainPage.this, DarkhasteKetab.class));
    }

    public void btn_nazarat (View view) {

        startActivity(new Intent(MainPage.this, Nazarat.class));
    }

    public void btn_aboutus (View view) {

        startActivity(new Intent(MainPage.this, Aboutus.class));
    }

    public void btn_roman (View view) {

        startActivity(new Intent(MainPage.this, Roman.class));
    }

    public void btn_honari (View view) {

        startActivity(new Intent(MainPage.this, Honari.class));
    }
}
