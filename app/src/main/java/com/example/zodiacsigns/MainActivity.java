package com.example.zodiacsigns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText selectDate;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private final static int DEFAULT_CALENDAR_DAY = 1;
    private final static int DEFAULT_CALENDAR_MONTH = 5;
    private final static int DEFAULT_CALENDAR_YEAR = 1990;
    public final static String EXTRA_NAME = "com.example.android.zodiacsigns.extra.MESSAGE";
    public final static String EXTRA_DATE = "com.example.android.zodiacsigns.extra.DATE";
    private AlertDialog.Builder alertDialog;
    private EditText mMessageName;
    private EditText mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectDate = findViewById(R.id.editdate);
        selectDate.setOnClickListener(this);

        mMessageName = findViewById(R.id.editTextTextPersonName);
        mDate = selectDate;
    }

    @Override
    public void onClick(View view) {
        if(view == selectDate) {
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    selectDate.setText(day + "/" + (month + 1) + "/" + year);
                }
            }, DEFAULT_CALENDAR_YEAR, DEFAULT_CALENDAR_MONTH, DEFAULT_CALENDAR_DAY);
            dialog.show();
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String personName = mMessageName.getText().toString();
        String dateOfBirth = mDate.getText().toString();

        checkName(intent, personName);
        checkDate(intent, dateOfBirth);

        if(!personName.equals("") && !dateOfBirth.equals("")) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contact) {
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
        } else if (id == R.id.exit) {
            alertDialog = new AlertDialog.Builder(this);
            alertDialog.setIcon(R.drawable.ic_exit_alert);
            alertDialog.setTitle(R.string.title_exit);
            alertDialog.setMessage(R.string.exit_message);

            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "You stay! Cool :)", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog finalDialog = alertDialog.create();
            finalDialog.show();

        }
        return true;
    }

    private void checkName(Intent intent, String personName) {
        if(!personName.equals("")) {
            intent.putExtra(EXTRA_NAME, personName);
        } else {
            Toast.makeText(this, "Please, add your name", Toast.LENGTH_LONG).show();
        }
    }

    private void checkDate(Intent intent, String dateOfBirth) {
        if(!dateOfBirth.equals("")) {
            intent.putExtra(EXTRA_DATE, dateOfBirth);
        } else {
            Toast.makeText(this, "Please, pick a date", Toast.LENGTH_LONG).show();
        }
    }


}