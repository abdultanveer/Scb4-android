package com.example.scb4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvName = findViewById(R.id.tvHome);
      String nameReceived =  getIntent().getStringExtra("name");
      tvName.setText(nameReceived);
    }

    @Override
    protected void onStart() {
        super.onStart();

      //  throw  new NullPointerException("demo crash");
    }

    public void openDialer(View view) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
        startActivity(dialIntent);
    }


    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
       // if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    public void setAlarm(View view) {
        createAlarm("scb lunch",12,25);
    }
}