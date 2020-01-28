package com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Nazarat extends AppCompatActivity {

    EditText matnepayam;
    String payam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nazarat);

        matnepayam = findViewById(R.id.act_nazarat_payam);

        Objects.requireNonNull(getSupportActionBar()).setTitle("نظرات و پیشنهادات                   ");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bbb));
    }

    public void btn_ersale_payam (View view) {
        payam = matnepayam.getText().toString().trim();

        if (payam.isEmpty()){
            Toast.makeText(this, "پیامی نوشته نشده است!", Toast.LENGTH_SHORT).show();
        }

        else {
        Toast.makeText(this, "پیام شما ارسال شد!", Toast.LENGTH_SHORT).show();
        }
    }
}
