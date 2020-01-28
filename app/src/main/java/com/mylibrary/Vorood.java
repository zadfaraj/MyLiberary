package com.mylibrary;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import databaseHelper.DatabaseHelper;

public class Vorood extends AppCompatActivity {

    EditText email_adress;
    String emailadress;
    EditText pass_word;
    String password;
    Button recovery;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vorood);

        Objects.requireNonNull(getSupportActionBar()).setTitle("کانون اسلامی انصار                   ");
        getSupportActionBar().setSubtitle("ورود                                      ");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bbb));

        email_adress = findViewById(R.id.act_vorood_edttxt_email);
        pass_word = findViewById(R.id.act_vorood_edttxt_pass);
        recovery = findViewById(R.id.act_vorood_forget);

        databaseHelper = new DatabaseHelper(this);
    }

    public boolean isValidEmail(CharSequence target) {
        return (Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void btn_vorood(View view){

        password = pass_word.getText().toString().trim();
        emailadress = email_adress.getText().toString().trim();

        boolean isValid = databaseHelper.userEnterance(emailadress,password);

        if (isValid){
            startActivity(new Intent(Vorood.this, MainPage.class));
            finish();
        }

        else if (emailadress.isEmpty()){
            Toast.makeText(Vorood.this, "ایمیل خود را وارد کنید!", Toast.LENGTH_SHORT).show();
            email_adress.requestFocus();
        }

        else if (emailadress.startsWith("www.") || emailadress.startsWith(".")){
            Toast.makeText(Vorood.this, "آدرس ایمیل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
            email_adress.requestFocus();
        }

        else if (!isValidEmail(emailadress)){
            Toast.makeText(Vorood.this, "آدرس ایمیل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
            email_adress.requestFocus();
        }

        else if (password.isEmpty()){
            Toast.makeText(Vorood.this, "رمز عبور خود را وارد کنید!", Toast.LENGTH_SHORT).show();
            pass_word.requestFocus();
        }

        else if (password.length() < 8){
            Toast.makeText(Vorood.this, "رمز عبور باید بیش از هفت رقم باشد!", Toast.LENGTH_SHORT).show();
            pass_word.requestFocus();
        }

        else {
            Toast.makeText(Vorood.this, "این حساب کاربری وجود ندارد!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_forget (View view){

        emailadress = email_adress.getText().toString().trim();

        AlertDialog.Builder builder = new AlertDialog.Builder(Vorood.this);
        builder.setMessage("          ارسال رمز عبور جدید به ایمیل؟");
        builder.setCancelable(true);
        builder.setPositiveButton("              بله", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                recovery.setText(R.string.bazyabi_password);

                if (emailadress.isEmpty()){
                    Toast.makeText(Vorood.this, "ایمیل خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    email_adress.requestFocus();
                }

                else if (emailadress.startsWith("www.") || emailadress.startsWith(".")){
                    Toast.makeText(Vorood.this, "آدرس ایمیل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
                    email_adress.requestFocus();
                }

                else if (!isValidEmail(emailadress)){
                    Toast.makeText(Vorood.this, "آدرس ایمیل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
                    email_adress.requestFocus();
                }

                else {
                Notification noti = new Notification.Builder(Vorood.this)
                        .setSmallIcon(R.drawable.ic_action_notification)
                        .setColor(Color.parseColor("#00574B"))
                        .setContentTitle("رمز عبور به ایمیل زیر ارسال می شود")
                        .setContentText(emailadress)
                        .setAutoCancel(true)
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                        .setVibrate(new long[]{100,500,100,500})
                        .build();

                NotificationManager notimanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                assert notimanager != null;
                notimanager.notify(0, noti);
                }
            }
        });

        builder.setNegativeButton("                               خیر", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }

    public void btn_nadaram(View view){

        startActivity(new Intent(Vorood.this, Sabtenam.class));
        finish();
    }
}