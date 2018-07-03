package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class view_inventory extends AppCompatActivity {

    private ArrayList<String> usernamed = new ArrayList<>();
    private ArrayList<String> username = new ArrayList<>();
    FirebaseDatabase bd;
    DatabaseReference ref,ref2;
    private ListView lv,lview;
   // ListView lv;
    Button search;
    TextView editText5;
    String value,uname,selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inventory);
        Intent in = getIntent();
        uname = in.getStringExtra("uname");

        bd = FirebaseDatabase.getInstance();
        ref2 = bd.getReference("product");


        //editText5=(TextView)findViewById(R.id.editText5);
        //editText5.setText(uname);
        lv = (ListView) findViewById(R.id.dynv);
        lview = (ListView) findViewById(R.id.lview);
        search = (Button) findViewById(R.id.button4);
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,usernamed);
        final ArrayAdapter<String> arrayAdapt= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,username);
        lview.setAdapter(arrayAdapt);




        lv.setAdapter(arrayAdapter);

        ref2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value = dataSnapshot.getKey();
                //value1= dataSnapshot.child("pg").getValue(String.class);
                //value2= dataSnapshot.child("").getValue(String.class);
                //String val = "Package :"+"\t\t"+value1+"\n"+"\t\t\t\t\t\t\t\t\t\t\t\t"+value2+"\n";
                username.add(value);
                arrayAdapt.notifyDataSetChanged();
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


        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected =((TextView)view).getText().toString();

                /*//String nam ="Kumari salon";
                Intent run1 = new Intent(getApplicationContext(), packdetails.class);
                //run1.putExtra("position", lview.getItemIdAtPosition(i));
                run1.putExtra("take", selected);
                startActivity(run1);*/
                ref=bd.getReference("product").child(selected);
                usernamed.clear();
                ref.addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        //String value = dataSnapshot.getKey();
                        String value1= dataSnapshot.child("iname").getValue(String.class);
                        //String value3=dataSnapshot.child("iprice").getKey();
                        String value2= dataSnapshot.child("iprice").getValue(String.class);
                        String val =value1+"\n"+"Rs: "+value2;
                        usernamed.add(value1);
                        arrayAdapter.notifyDataSetChanged();
                    }

                    //public void search(){
                    // search.setOnClickListener((view)-> (
                    //String editText5.getText().toString();


                    // ));


                    //}

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


            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String select = ((TextView)view).getText().toString();
                Intent in = new Intent(getApplicationContext(), invaddtocart.class);
                in.putExtra("ado",select);
                in.putExtra("nama",selected);
                in.putExtra("ugenama",uname);
                startActivity(in);


            }
        });


        //search();




    }
}
