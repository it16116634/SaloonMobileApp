package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {


    EditText uname;
    EditText upassword;
    Button log;



    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        radio();
        Login();

    }


    public void Login()
    {
        log = (Button) findViewById(R.id.LogBtn);

        log.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ref = FirebaseDatabase.getInstance().getReference("user");

               ref.addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                       String userName = dataSnapshot.child("name").getValue(String.class);
                       String passWord = dataSnapshot.child("pass").getValue(String.class);
                       String type = dataSnapshot.child("type").getValue(String.class);


                       uname = (EditText) findViewById(R.id.UserName);
                       upassword = (EditText) findViewById(R.id.Password);

                       String un = uname.getText().toString().trim();
                       String pw = upassword.getText().toString().trim();

                       if((userName.equals(un))  & (passWord.equals(pw)) & (type.equals("Customer")) )
                       {
                           Intent in = new Intent(getApplicationContext(),MainmenuActivity.class);
                           in.putExtra("uname",un);
                           startActivity(in);


                       }

                       else if((userName.equals(un))  & (passWord.equals(pw)) & (type.equals("Salon")) )
                       {
                           Intent in = new Intent(getApplicationContext(),SalCardViewBtns.class);
                           in.putExtra("uname",un);
                           startActivity(in);


                       }

                       else if(!(userName.equals(un))  & (passWord.equals(pw)) & (type.equals("Customer")))
                       {
                            Toast.makeText(login.this,"Invalid login details",Toast.LENGTH_LONG).show();

                       }
                       else if (userName.equals(un)  & (!(passWord.equals(pw)) & (type.equals("Customer"))))
                       {
                           Toast.makeText(login.this,"Invalid login details",Toast.LENGTH_LONG).show();

                       }

                       else if(!(userName.equals(un))  & (passWord.equals(pw)) & (type.equals("Salon")))
                       {
                           Toast.makeText(login.this,"Invalid login details",Toast.LENGTH_LONG).show();

                       }
                       else if (userName.equals(un)  & (!(passWord.equals(pw)) & (type.equals("Salon"))))
                       {
                           Toast.makeText(login.this,"Invalid login details",Toast.LENGTH_LONG).show();

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

















    public void radio()
    {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.SalonRadio) {

                    Button create = (Button) findViewById(R.id.RegBtn);
                    create.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            RadioButton rb = (RadioButton) findViewById(R.id.SalonRadio);
                            String type2 = (String) rb.getText();

                            Intent goagain = new Intent(getApplicationContext(), salReg.class);
                            goagain.putExtra("salon",type2);
                            startActivity(goagain);



                        }
                    });



                } else if(checkedId == R.id.CusRadio) {

                    final Button create = (Button) findViewById(R.id.RegBtn);
                    create.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            RadioButton ra = (RadioButton) findViewById(R.id.CusRadio);
                            String type = (String) ra.getText();

                            Intent goagain = new Intent(getApplicationContext(), CusReg.class);
                            goagain.putExtra("customer",type);
                            startActivity(goagain);

                        }
                    });


                }

                else {

                    Toast.makeText(login.this,"Please select your profile and Register",Toast.LENGTH_LONG).show();

                }
            }

        });





    }





}


