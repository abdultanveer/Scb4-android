package com.example.scb4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openDialer(View view) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
        startActivity(dialIntent);
    }
}