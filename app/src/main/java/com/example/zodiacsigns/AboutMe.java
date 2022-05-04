package com.example.zodiacsigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class AboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    public void onPhoneClick(View view) {
        TextView phoneNumber = findViewById(R.id.phone_number);
        String number = phoneNumber.getText().toString();

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        startActivity(intent);
    }

    public void onEmailClick(View view) {
        TextView emailAddress = findViewById(R.id.email);
        String email = emailAddress.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onGitHubAddressClick(View view) {
        TextView webpage = findViewById(R.id.github);
        webpage.setMovementMethod(LinkMovementMethod.getInstance());

    }
}