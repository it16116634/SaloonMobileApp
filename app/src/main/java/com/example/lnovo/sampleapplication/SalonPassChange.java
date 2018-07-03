package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SalonPassChange extends AppCompatActivity {



    TextView temp;

    EditText current;
    EditText newpass;
    EditText conpass;

    Button save;

    DatabaseReference DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_pass_change);


        DB = FirebaseDatabase.getInstance().getReference("user");

        current = (EditText) findViewById(R.id.currentPw);
        newpass = (EditText) findViewById(R.id.newPw);
        conpass = (EditText) findViewById(R.id.confirmPw);

        save = (Button) findViewById(R.id.SavePbtn);



        temp = (TextView) findViewById(R.id.Usernametxt);


        temptext();
        checkingCurrentPassword();
        checkingLengthOfNewPassword();
        changepasswordButton();











    }



    public void checkingLengthOfNewPassword()
    {


        conpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String nwp = newpass.getText().toString();
                if(nwp.length()<5)
                {
                    newpass.setError("Atleast need 5 characters!");

                }


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    //change password button
    public void changepasswordButton()
    {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkNewPassword();

            }
        });


    }


    //checking new password and all the validations
    public void checkNewPassword()
    {
        String cur = current.getText().toString().trim();
        String nwp = newpass.getText().toString().trim();
        final String cnp = conpass.getText().toString().trim();


        if(cur.isEmpty())
        {
            current.setError("Enter the current password");

        }
        else
        {

            if(nwp.isEmpty())
            {
                newpass.setError("Enter new password");
            }
            else
            {
                if(cnp.isEmpty())
                {
                    conpass.setError("Please confirm the password");

                }
                else
                {
                    if(!(nwp.equals(cnp)))
                    {
                        conpass.setError("password not match to the new password");

                    }
                    else
                    {
                        if(nwp.length()<5)
                        {
                            newpass.setError("Atleast need 5 characters!");

                        }
                        else {


                            Intent go = getIntent();
                            final String username = go.getStringExtra("uname");

                            DB.orderByChild("name").equalTo(username).addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    if (dataSnapshot.exists()) {
                                        dataSnapshot.getRef().child("pass").setValue(cnp);
                                        Toast.makeText(SalonPassChange.this, "Password is changed!", Toast.LENGTH_LONG).show();
                                        Intent in = new Intent(getApplicationContext(), SalonProfile.class);
                                        in.putExtra("uname", username);
                                        startActivity(in);

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

                    }





                }

            }


        }


    }

    public void checkingCurrentPassword()
    {

        newpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Intent go = getIntent();
                final String username = go.getStringExtra("uname");


                DB.orderByChild("name").equalTo(username).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String getpass = dataSnapshot.child("pass").getValue(String.class);




                        String cur = current.getText().toString();

                        if(!(getpass.equals(cur)))
                        {
                            current.setError("Password not match");

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

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }

    //get username
    public void temptext()
    {
        Intent go = getIntent();

        String username = go.getStringExtra("uname");

        temp.setText(username);


    }

}
