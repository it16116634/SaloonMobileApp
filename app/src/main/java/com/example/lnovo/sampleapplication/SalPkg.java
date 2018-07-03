package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SalPkg extends AppCompatActivity {



    Button pkgBtn;
    DatabaseReference ref;
    Spinner servc;

    EditText pkgNm;
    TextView uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sal_pkg);


        ref = FirebaseDatabase.getInstance().getReference("packages");



        servc = (Spinner) findViewById(R.id.spinnerPkg);
        pkgNm = (EditText)findViewById(R.id.pkgName);
        pkgBtn = (Button) findViewById(R.id.pkgBtn);

        uname = (TextView) findViewById(R.id.salonUsernameTextView);
        viwusername();
        getVlaue();

        getPkg();

    }








    public void viwusername()
    {
        Intent in = getIntent();
        String UserNAme = in.getStringExtra("uname");
        uname.setText(UserNAme);


    }






    private void getVlaue(){


        pkgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String pNm =pkgNm.getText().toString().trim();
                String pkg = servc.getSelectedItem().toString().trim();



                if(pNm.isEmpty())
                {
                    Toast.makeText(SalPkg.this,"You Should Enter the Package Name ",Toast.LENGTH_LONG).show();

                }
                else {


                    String id = ref.push().getKey();

                    AddPak AddPackages = new AddPak(id,pNm,pkg);


                    Intent in = getIntent();
                    String UserNAme = in.getStringExtra("uname");


                    ref.child(UserNAme).child(pNm).setValue(AddPackages);


                    Toast.makeText(SalPkg.this, "New Package Added", Toast.LENGTH_LONG).show();

                }


                }
        });

        }




    public void getPkg()
    {

        Intent in = getIntent();
        String uname = in.getStringExtra("uname");

        //final String s=servc.getSelectedItem().toString().trim();


        DatabaseReference DB = FirebaseDatabase.getInstance().getReference("services");

        DB.child(uname).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final List<String> pkg = new ArrayList<>();

                for (DataSnapshot servicesnapshot: dataSnapshot.getChildren()) {
                    String sr = servicesnapshot.child("service").getValue(String.class);
                    pkg.add(sr);
                }


                ArrayAdapter<String> AddPackages=new ArrayAdapter<String>(SalPkg.this, android.R.layout.simple_spinner_item,pkg);
                AddPackages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                servc.setAdapter(AddPackages);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

}



