package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Main2Activity extends AppCompatActivity {


    EditText name,service,location;
    Button insert;
    FirebaseDatabase database;
    DatabaseReference ref;
    Salon salon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = (EditText) findViewById(R.id.salonName);
        service = (EditText) findViewById(R.id.salonLocation);
        location = (EditText) findViewById(R.id.description);
        insert =(Button) findViewById(R.id.button3);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Salon");
        salon = new Salon();
    }
    private void getValues()
    {
        salon.setName(name.getText().toString());
        salon.setLocation(location.getText().toString());
        salon.setService(service.getText().toString());
    }

    public void AddsalonButtonclicked(View view) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            getValues();
            ref.child("Salon2").setValue(salon);
            Toast.makeText(Main2Activity.this,"Data Inserted..",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
