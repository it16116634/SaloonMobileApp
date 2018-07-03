package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);

        TextView tv = new TextView(this);
        setContentView(tv);
        Intent intent = getIntent();
        String data = intent.getExtras().getString(NotificationActivity.NOTIFICATION_DATA);
        tv.setText(data);

    }
}
