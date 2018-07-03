package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.AddSal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class salReg extends AppCompatActivity {



    EditText SalName, SalOwn, SalRegNo, SalAddress, SalEmail, SalPhone, SalPass, SalConPass;

    Button buttonAdd;
    AddSal Sal;
    FirebaseDatabase customer;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sal_reg);



        ref = FirebaseDatabase.getInstance().getReference("user");

        SalName = (EditText) findViewById(R.id.SalName);
        SalOwn = (EditText) findViewById(R.id.SalOwn);

        SalRegNo = (EditText) findViewById(R.id.SalRegNo);

        SalAddress = (EditText) findViewById(R.id.SalAddress);
        SalEmail = (EditText) findViewById(R.id.SalEmail);
        SalPhone = (EditText) findViewById(R.id.SalPhone);
        SalPass = (EditText) findViewById(R.id.SalPass);
        SalConPass = (EditText) findViewById(R.id.SalConPass);

        buttonAdd = (Button) findViewById(R.id.SalonSave);


        AddValues();
        checkAlreadyExistUserName();

    }


    public void checkAlreadyExistUserName()
    {

        SalOwn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                String Name = SalName.getText().toString().trim();

                ref.orderByChild("name").equalTo(Name).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists())
                        {

                            SalName.setError("User Name is already exist!");

                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });







            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }






    private void AddValues (){


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Name = SalName.getText().toString().trim();
                String Owner = SalOwn.getText().toString().trim();
                String RegisterNo = SalRegNo.getText().toString().trim();
                String Address = SalAddress.getText().toString().trim();
                String Email = SalEmail.getText().toString().trim();
                String phoneNo = SalPhone.getText().toString().trim();
                String pass = SalPass.getText().toString().trim();
                String Conpass = SalConPass.getText().toString().trim();


                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(Name.isEmpty() || Owner.isEmpty() || RegisterNo.isEmpty() || Address.isEmpty() || Email.isEmpty() || phoneNo.isEmpty() || pass.isEmpty() || Conpass.isEmpty())
                {

                    Toast.makeText(salReg.this,"You have null fields",Toast.LENGTH_LONG).show();

                }
                else if (!(Email.matches(emailPattern)))
                {

                    SalEmail.setError("Invalid email Adddress");

                }
                else if (phoneNo.length()<10)
                {
                    SalPhone.setError("Invalid Phone Number");

                }

                else if (pass.length()<5)
                {
                    SalPass.setError("Atleast need 5 characters!");

                }
                else if(!pass.equals(Conpass))
                {
                    SalConPass.setError("password Not Match");

                }





                  else{


                    Intent go  = getIntent();
                    String type = go.getStringExtra("salon");

                    String id = ref.push().getKey();

                    AddSal salon = new AddSal(id,Name,Owner,RegisterNo,Address,Email,phoneNo,pass,Conpass,type);

                    ref.child(id).setValue(salon);

                    Toast.makeText(salReg.this,"New Salon added",Toast.LENGTH_LONG).show();


                    String uname = SalName.getText().toString();

                    Intent in = new Intent(getApplicationContext(),SalCardViewBtns.class);
                    in.putExtra("uname",uname);
                    startActivity(in);


                }


            }
        });



    }







}









