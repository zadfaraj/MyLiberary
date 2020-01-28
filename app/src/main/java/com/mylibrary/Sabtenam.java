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
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import databaseHelper.DatabaseHelper;
import databaseHelper.Person;

public class Sabtenam extends AppCompatActivity {

    String firstname, lastname, emailadress, phonenumber, password, repeatpassword;
    EditText first_name, last_name , email_adress, phone_number, pass_word, repeat_password;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabtenam);

        Objects.requireNonNull(getSupportActionBar()).setTitle("کانون اسلامی انصار                   ");
        getSupportActionBar().setSubtitle("ثبت نام                                    ");
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.bbb));

        first_name = findViewById(R.id.act_sabtenam_nam);
        last_name = findViewById(R.id.act_sabtenam_namkh);
        email_adress = findViewById(R.id.act_sabtenam_email);
        phone_number = findViewById(R.id.act_sabtenam_phone);
        pass_word = findViewById(R.id.act_sabtenam_pass);
        repeat_password = findViewById(R.id.act_sabtenam_repeatpass);

        databaseHelper = new DatabaseHelper(this);
    }

    public boolean isValidEmail(CharSequence target) {
        return (Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public void btn_sabt(View view){

        firstname = first_name.getText().toString().trim();
        lastname = last_name.getText().toString().trim();
        emailadress = email_adress.getText().toString().trim();
        phonenumber = phone_number.getText().toString().trim();
        password = pass_word.getText().toString().trim();
        repeatpassword = repeat_password.getText().toString().trim();

        AlertDialog.Builder builder = new AlertDialog.Builder(Sabtenam.this);
        builder.setMessage("     آیا اطلاعات وارد شده صحیح می باشد؟");
        builder.setCancelable(true);
        builder.setPositiveButton("        بله", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (firstname.isEmpty()){
                    Toast.makeText(Sabtenam.this, "نام خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    first_name.requestFocus();
                }

                else if (firstname.length() < 3){
                    Toast.makeText(Sabtenam.this, "نام باید بیش از دو حرف باشد!", Toast.LENGTH_SHORT).show();
                    first_name.requestFocus();
                }

                else if (lastname.isEmpty()){
                    Toast.makeText(Sabtenam.this, "نام خانوادگی خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    last_name.requestFocus();
                }

                else if (lastname.length() < 3){
                    Toast.makeText(Sabtenam.this, "نام خانوادگی باید بیش از دو حرف باشد!", Toast.LENGTH_SHORT).show();
                    last_name.requestFocus();
                }

                else if (emailadress.isEmpty()){
                    Toast.makeText(Sabtenam.this, "ایمیل خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    email_adress.requestFocus();
                }

                else if (emailadress.startsWith("www.") || emailadress.startsWith(".")){
                    Toast.makeText(Sabtenam.this, "آدرس ایمیل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
                    email_adress.requestFocus();
                }

                else if (!isValidEmail(emailadress)){
                    Toast.makeText(Sabtenam.this, "آدرس ایمیل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
                    email_adress.requestFocus();
                }

                else if (phonenumber.isEmpty()){
                    Toast.makeText(Sabtenam.this, "شماره موبایل خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    phone_number.requestFocus();
                }

                else if (phonenumber.length() < 11 || !phonenumber.startsWith("09")){
                    Toast.makeText(Sabtenam.this, "شماره موبایل را صحیح وارد کنید!", Toast.LENGTH_SHORT).show();
                    phone_number.requestFocus();
                }

                else if (password.isEmpty()){
                    Toast.makeText(Sabtenam.this, "رمز عبور خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    pass_word.requestFocus();
                }

                else if (password.length() < 8){
                    Toast.makeText(Sabtenam.this, "رمز عبور باید بیش از هفت رقم باشد!", Toast.LENGTH_SHORT).show();
                    pass_word.requestFocus();
                }

                else if (repeatpassword.isEmpty()){
                    Toast.makeText(Sabtenam.this, "تکرار رمز عبور خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                    repeat_password.requestFocus();
                }

                else if (!repeatpassword.equals(password)){
                    Toast.makeText(Sabtenam.this, "تکرار رمز عبور صحیح نیست!", Toast.LENGTH_SHORT).show();
                    repeat_password.requestFocus();
                }

                else {
                    Person person = new Person();

                    person.setName(firstname);
                    person.setFamily(lastname);
                    person.setEmail(emailadress);
                    person.setPhone(phonenumber);
                    person.setPassword(password);

                    boolean insertion = databaseHelper.insertPerson(person);

                    if (insertion){
                        startActivity(new Intent(Sabtenam.this, Vorood.class));

                        Notification noti = new Notification.Builder(Sabtenam.this)
                                .setSmallIcon(R.drawable.ic_action_notification)
                                .setColor(Color.parseColor("#00574B"))
                                .setContentTitle("پیام ثبت نام به ایمیل زیر ارسال می شود")
                                .setContentText(emailadress)
                                .setAutoCancel(true)
                                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                                .setVibrate(new long[]{100,500,100,500})
                                .build();

                        NotificationManager notimanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        assert notimanager != null;
                        notimanager.notify(0, noti);
                        finish();
                    }
                }
            }
        });

        builder.setNegativeButton("                               بررسی دوباره", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }

    public void btn_daram(View view){

        startActivity(new Intent(Sabtenam.this, Vorood.class));
        finish();
    }
}