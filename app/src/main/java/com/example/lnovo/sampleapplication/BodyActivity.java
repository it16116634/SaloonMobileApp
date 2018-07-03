package com.example.lnovo.sampleapplication;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BodyActivity extends AppCompatActivity {

    private ArrayList<String> name = new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Service service;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Service").child("BodyService");
        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(arrayAdapter);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String Value = dataSnapshot.child("ServiceName").getValue(String.class);
                String  val = Value;
                name.add(val);
                arrayAdapter.notifyDataSetChanged();
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                switch (i){

                    case 0:
//                        Toast.makeText(getApplicationContext(),"Hair cutting",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),BookingFormActivity.class);
                        intent.putExtra("servicename",arrayAdapter.getItem(i));
                        startActivity(intent);
                        break;
                    case 1:
//                        Toast.makeText(getApplicationContext(),"Hair coloring",Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(getApplicationContext(),BookingFormActivity.class);
                        intent1.putExtra("servicename",arrayAdapter.getItem(i));
                        startActivity(intent1);
                        break;
                    case 2:
//                        Toast.makeText(getApplicationContext(),"Hair Extention",Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(getApplicationContext(),BookingFormActivity.class);
                        intent2.putExtra("servicename",arrayAdapter.getItem(i));
                        startActivity(intent2);
                        break;
                }

            }
        });

    }
}
