package com.example.zodiacsigns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private String dateOfBirth;
    private int dayOfBirth;
    private int monthOfBirth;
    private ImageView imgSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String personName = intent.getStringExtra(MainActivity.EXTRA_NAME);
        dateOfBirth = intent.getStringExtra(MainActivity.EXTRA_DATE);
        String[] dateData = dateOfBirth.split("/");
        dayOfBirth = Integer.parseInt(dateData[0]);
        monthOfBirth = Integer.parseInt(dateData[1]);

        TextView greeting = findViewById(R.id.text_greeting);
        greeting.setText("Hi, " + personName);

        TextView sign = findViewById(R.id.text_zodiac_sign);
        String zodiacSign = findZodiacSign(dayOfBirth, monthOfBirth);
        sign.setText("Your zodiac sign is: " + zodiacSign);

        imgSign = (ImageView) findViewById(R.id.image_sign);
        setImageSign(zodiacSign);


    }


    private void setImageSign(String sign) {
        switch (sign) {
            case "Aries":
                imgSign.setBackgroundResource(R.drawable.aries);
                break;
            case "Taurus":
                imgSign.setBackgroundResource(R.drawable.taurus);
                break;
            case "Gemini":
                imgSign.setBackgroundResource(R.drawable.gemini);
                break;
            case "Cancer":
                imgSign.setBackgroundResource(R.drawable.cancer);
                break;
            case "Leo":
                imgSign.setBackgroundResource(R.drawable.leo);
                break;
            case "Virgo":
                imgSign.setBackgroundResource(R.drawable.virgo);
                break;
            case "Libra":
                imgSign.setBackgroundResource(R.drawable.libra);
                break;
            case "Scorpio":
                imgSign.setBackgroundResource(R.drawable.scorpio);
                break;
            case "Sagittarius":
                imgSign.setBackgroundResource(R.drawable.sagittarius);
                break;
            case "Capricorn":
                imgSign.setBackgroundResource(R.drawable.capricorn);
                break;
            case "Aquarius":
                imgSign.setBackgroundResource(R.drawable.aquarius);
                break;
            case "Pisces":
                imgSign.setBackgroundResource(R.drawable.pisces);
                break;
        }
    }

    private String findZodiacSign(int dayOfBirth, int monthOfBirth) {
        String sign = "";
        switch (monthOfBirth) {
            case 1:
                if(dayOfBirth <= 19){
                    sign = "Capricorn";
                } else {
                    sign = "Aquarius";
                }
                break;
            case 2:
                if(dayOfBirth <= 19){
                    sign = "Aquarius";
                } else {
                    sign = "Pisces";
                }
                break;
            case 3:
                if(dayOfBirth <= 20){
                    sign = "Pisces";
                } else {
                    sign = "Aries";
                }
                break;
            case 4:
                if(dayOfBirth <= 20){
                    sign = "Aries";
                } else {
                    sign = "Taurus";
                }
                break;
            case 5:
                if(dayOfBirth <= 20){
                    sign = "Taurus";
                } else {
                    sign = "Gemini";
                }
                break;
            case 6:
                if(dayOfBirth <= 20){
                    sign = "Gemini";
                } else {
                    sign = "Cancer";
                }
                break;
            case 7:
                if(dayOfBirth <= 22){
                    sign = "Cancer";
                } else {
                    sign = "Leo";
                }
                break;
            case 8:
                if(dayOfBirth <= 22){
                    sign = "Leo";
                } else {
                    sign = "Virgo";
                }
                break;
            case 9:
                if(dayOfBirth <= 22){
                    sign = "Virgo";
                } else {
                    sign = "Libra";
                }
                break;
            case 10:
                if(dayOfBirth <= 22){
                    sign = "Libra";
                } else {
                    sign = "Scorpio";
                }
                break;
            case 11:
                if(dayOfBirth <= 22){
                    sign = "Scorpio";
                } else {
                    sign = "Sagittarius";
                }
                break;
            case 12:
                if(dayOfBirth <= 21){
                    sign = "Sagittarius";
                } else {
                    sign = "Capricorn";
                }
                break;
        }
        return sign;
    }
}