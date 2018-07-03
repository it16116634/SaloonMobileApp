package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfile extends AppCompatActivity {

    DatabaseReference ref;
    EditText getPhone,getCity,getEmail;
    Button saveButton,pbtn;
    TextView CusNameTxt;
//    Spinner getGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        CusNameTxt = (TextView) findViewById(R.id.CusName);
 //       getGender = (Spinner)findViewById(R.id.GenSpinner);
        getPhone = (EditText)findViewById(R.id.CusPhNo);
        getCity = (EditText)findViewById(R.id.CusCity);
        getEmail = (EditText)findViewById(R.id.CusEmail);
 //       getPass = (EditText)findViewById(R.id.CusPass);
 //       getConPass=(EditText)findViewById(R.id.CusConPass);

        saveButton = (Button)findViewById(R.id.btnInsert);

        pbtn = (Button) findViewById(R.id.button2) ;
        getValue();

        changePassBtn();

        editData();

    }

    public void changePassBtn(){


        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");
                Intent go = new Intent(getApplicationContext(),PasswordChange.class);
                go.putExtra("uname",uname);

                startActivity(go);
            }
        });

    }


    public void editData(){

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                //      updateGender();
                updatePhone();

                updateEmail();

                updateAddress();



            }
        });




    }







  /* public void updateGender(){


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

                DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        final List <String> gen = new ArrayList<>();
                        String Gender  = getGender.getSelectedItem().toString();
                        gen.add(Gender);
                        if(dataSnapshot.exists()){

                            dataSnapshot.getRef().child("gender").setValue(Gender);

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



            }
        });







    }


*/


    public void updatePhone(){


        Intent in = getIntent();
        String uname = in.getStringExtra("uname");

        DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

        DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String Phone  = getPhone.getText().toString();
                if(Phone.length()<10){
                    getPhone.setError("Invalid Phone Number");


                }

                else if(dataSnapshot.exists()){

                    dataSnapshot.getRef().child("phNo").setValue(Phone);

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








    }



    public void updateAddress(){



                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

                DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String City  = getCity.getText().toString();
                        if(dataSnapshot.exists()){

                            dataSnapshot.getRef().child("city").setValue(City);

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












    }





    public void updateEmail(){



                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

                DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String Email  = getEmail.getText().toString();
                        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                        if(!(Email.matches(emailPattern))){


                            getEmail.setError("Invalid email Adddress");


                        }

                        else if(dataSnapshot.exists()){

                            dataSnapshot.getRef().child("email").setValue(Email);

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











    }













    public void getValue(){


        Intent in = getIntent();
        String uname = in.getStringExtra("uname");



        ref = FirebaseDatabase.getInstance().getReference("user");

        ref.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                String CusName = dataSnapshot.child("name").getValue(String.class);
      //          String CusGender = dataSnapshot.child("gender").getValue(String.class);
                String Phone = dataSnapshot.child("phNo").getValue(String.class);
                String Address = dataSnapshot.child("city").getValue(String.class);
                String Email = dataSnapshot.child("email").getValue(String.class);
      //          String Pass = dataSnapshot.child("pass").getValue(String.class);
     //           String ConPass = dataSnapshot.child("conPass").getValue(String.class);


                CusNameTxt.setText(CusName);
  //            getGender.setSelected(CusGender);
                getPhone.setText(Phone);
                getCity.setText(Address);
                getEmail.setText(Email);
    //            getPass.setText(Pass);
    //            getConPass.setText(ConPass);
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



    }






}

