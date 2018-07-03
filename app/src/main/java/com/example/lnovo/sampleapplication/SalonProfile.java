package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SalonProfile extends AppCompatActivity {


    DatabaseReference ref;
    EditText getOName,getSalregNo,getAddress,getEmail,getPhno;
    Button saveButton,pbtn;
    TextView getSalName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_profile);



        getSalName = (TextView) findViewById(R.id.SalName);
        getOName = (EditText) findViewById(R.id.SalOwn);

        getSalregNo = (EditText) findViewById(R.id.SalRegNo);

        getAddress= (EditText) findViewById(R.id.SalAddress);
        getEmail = (EditText) findViewById(R.id.SalEmail);
        getPhno = (EditText) findViewById(R.id.SalPhone);
  //      getPass = (EditText) findViewById(R.id.SalPass);
  //      getConPass = (EditText)findViewById(R.id.SalConPass);

        saveButton = (Button)findViewById(R.id.SalonSave) ;



        pbtn = (Button)findViewById(R.id.savePass) ;


    getValue();

    changePassBtn();

    editData();



    }
// UPDATE SALON NAME IN DATABASE

    public void changePassBtn(){


        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = getIntent();
                String uname = in.getStringExtra("uname");
                Intent go = new Intent(getApplicationContext(),SalonPassChange.class);
                go.putExtra("uname",uname);

                startActivity(go);
            }
        });

    }



    public void editData(){

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                updateAddress();
                updateRegNo();
                updateOwnerName();

                updatePhone();

                updateEmail();

            }
        });




    }




//     UPDATE SALON NAME IN DATABASE
    public void updateOwnerName (){


                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

                DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String Owner = getOName.getText().toString();
                        if(dataSnapshot.exists()){

                            dataSnapshot.getRef().child("owner").setValue(Owner);
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


    public void updateRegNo(){



                Intent in = getIntent();
                String uname = in.getStringExtra("uname");

                DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

                DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String SalRegNo = getSalregNo.getText().toString();
                        if(dataSnapshot.exists()){

                            dataSnapshot.getRef().child("regNo").setValue(SalRegNo);
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

                    String address  = getAddress.getText().toString();
                    if(dataSnapshot.exists()){

                        dataSnapshot.getRef().child("address").setValue(address);

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

                    if (!(Email.matches(emailPattern)))
                    {

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

public void updatePhone(){



            Intent in = getIntent();
            String uname = in.getStringExtra("uname");

            DatabaseReference DB = FirebaseDatabase.getInstance().getReference("user");

            DB.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    String phoneNo  = getPhno.getText().toString();
                    if(phoneNo.length()<10){
                        getPhno.setError("Invalid Phone Number");


                    }

                    else if(dataSnapshot.exists()){

                        dataSnapshot.getRef().child("phone").setValue(phoneNo);

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






//GET VALUES IN DB TO SALON PROFILE
public void getValue (){


    Intent in = getIntent();
    String uname = in.getStringExtra("uname");



        ref = FirebaseDatabase.getInstance().getReference("user");

        ref.orderByChild("name").equalTo(uname).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String Name = dataSnapshot.child("name").getValue(String.class);
                String OwnerName = dataSnapshot.child("owner").getValue(String.class);
                String Salreg = dataSnapshot.child("regNo").getValue(String.class);
                String Address = dataSnapshot.child("address").getValue(String.class);
                String Email = dataSnapshot.child("email").getValue(String.class);
                String Phno = dataSnapshot.child("phone").getValue(String.class);


                getSalName.setText(Name);
                getOName.setText(OwnerName);
                getSalregNo.setText(Salreg);
                getAddress.setText(Address);
                getEmail.setText(Email);
                getPhno.setText(Phno);
  //              getPass.setText(Pass);
 //               getConPass.setText(Conpass);











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
