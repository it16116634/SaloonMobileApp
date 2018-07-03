package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;

import java.util.ArrayList;

public class invaddtocart extends AppCompatActivity {

    FirebaseDatabase bd;
    DatabaseReference ref;

    String value1,value2;
    Integer roll;
    TextView value3,value4,value5;
    Button bt,bt2;
    String pd,uname,unam;
    Integer tot;

    ScrollableNumberPicker ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invaddtocart);

        Intent inl = getIntent();
        pd = inl.getStringExtra("ado");
        uname = inl.getStringExtra("nama");
        unam = inl.getStringExtra("ugenama");


        ver=(ScrollableNumberPicker)findViewById(R.id.scrl);

        bt2=(Button)findViewById(R.id.buy);
        bt=(Button)findViewById(R.id.cost);
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("product").child(uname);
        value3=(TextView)findViewById(R.id.shpnm);
        value4 = (TextView)findViewById(R.id.prs);
        value5 = (TextView)findViewById(R.id.prss);







        ref.addChildEventListener(new ChildEventListener() {


            //String i="Nature's secrets anti-dandruff shampoo";

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value1= dataSnapshot.child("iname").getValue(String.class);

                if(value1.equals(pd)) {
                    value3.setText(value1);
                    value2 = dataSnapshot.child("iprice").getValue(String.class);
                    value4.setText(value2);

                }




            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal(v);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
              Intent rl=new Intent(getApplicationContext(), payment.class);
              rl.putExtra("ywwa",value5.getText());
              rl.putExtra("uname",unam);
              startActivity(rl);

            }
        });



    }
    public void cal(View view){

        roll=ver.getValue();
        int i=Integer.parseInt(value2);
        tot = i*roll;
        value5.setText("Rs. "+tot);


    }
}
