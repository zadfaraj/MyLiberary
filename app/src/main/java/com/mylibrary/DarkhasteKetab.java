package com.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class DarkhasteKetab extends AppCompatActivity {

    TextView textView;
    String showbookmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkhaste_ketab);

        Objects.requireNonNull(getSupportActionBar()).setTitle("درخواست کتاب                       ");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bbb));

        textView = findViewById(R.id.textView_darkhast);

        showbookmessage = getIntent().getStringExtra(ShowBooks.GOTODARKHST);
        textView.setText(showbookmessage);
    }
}
