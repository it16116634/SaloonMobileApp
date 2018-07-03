package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lnovo.sampleapplication.R;

public class SalCardViewBtns extends AppCompatActivity {


    Button services;
    Button packages;
    Button products;
    Button salonProfile;

    TextView uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sal_card_view_btns);



        services = (Button) findViewById(R.id.ServiceInfaceBtn);
        packages = (Button) findViewById(R.id.PackageInfaceBtn);
        products = (Button) findViewById(R.id.button5);
        salonProfile = (Button)findViewById(R.id.profileBtn);







        serviceButtonP();
        packageButtonP();
        producteButtonP();
        profileButton();

    }

    public void serviceButtonP()
    {

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                Intent go = new Intent(getApplicationContext(), services.class);
                go.putExtra("uname",uname);
                startActivity(go);



            }
        });



    }

    public void packageButtonP()
    {

        packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                Intent go = new Intent(getApplicationContext(), SalPkg.class);
                go.putExtra("uname",uname);
                startActivity(go);


            }
        });



    }


    public void producteButtonP()
    {

        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                Intent go = new Intent(getApplicationContext(), Product.class);
                go.putExtra("uname",uname);
                startActivity(go);


            }
        });



    }

    public void profileButton(){

        salonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");
                Intent go = new Intent(getApplicationContext(),SalonProfile.class);
                go.putExtra("uname",uname);
                startActivity(go);

                }
        });




    }




}
