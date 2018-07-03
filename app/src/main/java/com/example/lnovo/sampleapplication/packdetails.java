package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class packdetails extends AppCompatActivity {
    private ArrayList<String> username1 = new ArrayList<>();
    private ArrayList<Integer> arr2 = new ArrayList<>();
    FirebaseDatabase bd;
    FirebaseDatabase bd1;
    DatabaseReference ref;
    DatabaseReference ref1;
    private ListView lview;
    Button bt3,bt4;
    String value,value1,value2,value3;
    TextView t14;
    int v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packdetails);
        bt3=(Button)findViewById(R.id.button3);
        bt4=(Button)findViewById(R.id.bbb);

        Intent in = getIntent();
        final String name= in.getStringExtra("take");

        bd = FirebaseDatabase.getInstance();
        bd1 = FirebaseDatabase.getInstance();
        ref1 = bd1.getReference("services").child(name);

        ref = bd.getReference("packages").child(name);

        t14=(TextView)findViewById(R.id.t14);

        lview = (ListView) findViewById(R.id.lis);
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,username1);
        final ArrayAdapter<Integer> arrayAdapt= new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,arr2);



        lview.setAdapter(arrayAdapter);






        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value = dataSnapshot.getKey();
                //String value1 = dataSnapshot.child("SalonName").getValue(String.class);



                //if(name.equals(value)) {


                    value3 = dataSnapshot.child("pg").getValue(String.class);
                    //String value3 = dataSnapshot.child("Service2").getValue(String.class);
                    //Long value4 = dataSnapshot.child("Totalprice").getValue(long.class);
                    //String val = "Package " + "\n" + "\t\t" + value1 + "\n" + "\t\t\t\t\t\t" + value2 + "\n" + "\t\t\t\t\t\t" + value3 + "\n\n\n\n" + "\t\t\t\t\t\t" + "Package Price  (Rs):\t\t\t" + value4;
                    username1.add(value3);
                    arrayAdapter.notifyDataSetChanged();
                //}
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



        ref1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value1= dataSnapshot.child("service").getValue(String.class);
                for (int i=0;i<username1.size();i++) {
                    if(value1.equals(username1.get(i))) {
                        value2 = dataSnapshot.child("price").getValue(String.class);
                        v1=Integer.parseInt(value2);
                        arr2.add(v1);

                    }
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



        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                Intent run1 = new Intent(getApplicationContext(),payment.class);
                run1.putExtra("take",name);
                run1.putExtra("ywwa",t14.getText());
                startActivity(run1);



            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total(v);

            }
        });




    }
    public void total(View view){
        int items = 0;


        for (int item:arr2){

            items += item;

        }
        t14.setText("Rs. "+items);
        //Toast.makeText(this,"Total Price \n"+items,Toast.LENGTH_SHORT).show();
    }



}
