package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lnovo.sampleapplication.R;

public class temp1 extends AppCompatActivity {

    TextView uname;
    Button CusProfile,ratebtn;
    RatingBar rates;
    TextView descrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp1);

        //ratings
        rates = (RatingBar) findViewById(R.id.rateStars);
        descrip = (TextView)findViewById(R.id.descrip);




        CusProfile = (Button)findViewById(R.id.customerProfileBtn);

        uname = (TextView)findViewById(R.id.txv);


        viewUserName();
        CustomerProfile();




        //Rating


        rates.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                descrip.setText("Value is "+rating);




            }
        });


    }












    public void viewUserName()
    {
        Intent take = getIntent();
        String getUname = take.getStringExtra("uname");
        uname.setText(getUname);



    }


    public void CustomerProfile(){



        CusProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");
                Intent go = new Intent(getApplicationContext(),CustomerProfile.class);
                go.putExtra("uname",uname);
                startActivity(go);

            }
        });


    }





    }


