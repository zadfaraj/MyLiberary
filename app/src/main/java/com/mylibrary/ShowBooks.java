package com.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class ShowBooks extends AppCompatActivity {

    public static final String GOTODARKHST = "gotodarkhast";

    TextView booktitle, jalal;
    String romanmessage, sotimessage, bookdarkhast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_books);

        Objects.requireNonNull(getSupportActionBar()).hide();

        booktitle = findViewById(R.id.book_title);
        jalal = findViewById(R.id.jalal);
        jalal.setMovementMethod(LinkMovementMethod.getInstance());

        romanmessage = getIntent().getStringExtra(Roman.ID_MESSAGE);
        booktitle.setText(romanmessage);

        sotimessage = getIntent().getStringExtra(Soti.ID_MESSAGE);
        booktitle.setText(sotimessage);
    }

    public void btn_rezerv (View view) {

        Intent rezerv = new Intent(ShowBooks.this, DarkhasteKetab.class);

        bookdarkhast = booktitle.getText().toString().trim();

        rezerv.putExtra(GOTODARKHST, bookdarkhast);

        startActivity(rezerv);
    }
}
