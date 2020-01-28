package com.mylibrary;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    MediaPlayer splashsound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Objects.requireNonNull(getSupportActionBar()).hide();

        splashsound = MediaPlayer.create(this, R.raw.splashsound);
        splashsound.start();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },2200);
    }
}
