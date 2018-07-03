package com.example.lnovo.sampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PolicyActivity extends AppCompatActivity {

    TextView policy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        policy = (TextView) findViewById(R.id.textview1);
    }
}
