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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CusReg extends AppCompatActivity {

    EditText CusName,CusPhNo,CusCity,CusEmail,CusPPass,CusCConPass;

    Button buttonAdd;
    FirebaseDatabase customer;
    DatabaseReference ref;
    AddUser user;

    Spinner cusgend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_reg);

        ref = FirebaseDatabase.getInstance().getReference("user");



        CusName = (EditText) findViewById(R.id.CusName);

        cusgend = (Spinner) findViewById(R.id.GenSpinner);
        CusPhNo = (EditText) findViewById(R.id.CusPhNo);
        CusCity= (EditText) findViewById(R.id.CusCity);
        CusEmail= (EditText) findViewById(R.id.CusEmail);
        CusPPass = (EditText) findViewById(R.id.CusPass);
        CusCConPass= (EditText) findViewById(R.id.CusConPass);
        buttonAdd= (Button) findViewById(R.id.btnInsert);



           AddValues();





     checkAlreadyExistUserName();

    }


    public void checkAlreadyExistUserName()
    {

        CusPhNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                String Name = CusName.getText().toString().trim();

                ref.orderByChild("name").equalTo(Name).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists())
                        {

                            CusName.setError("User Name is already exist!");

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

        String Name = CusName.getText().toString().trim();

        String Gender = cusgend.getSelectedItem().toString();
        String PhoneNo = CusPhNo.getText().toString().trim();
        String City = CusCity.getText().toString().trim();
        String Email = CusEmail.getText().toString().trim();
        String password = CusPPass.getText().toString().trim();
        String Conpass = CusCConPass.getText().toString().trim();


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if(Name.isEmpty() || PhoneNo.isEmpty() || City.isEmpty() || Email.isEmpty() || password.isEmpty() || Conpass.isEmpty())
            {
                Toast.makeText(CusReg.this,"You have null fields ",Toast.LENGTH_LONG).show();

            }
            else if (!(Email.matches(emailPattern)))
            {

                CusEmail.setError("Invalid email Adddress");

            }
            else if (PhoneNo.length()<10)
            {
                CusPhNo.setError("Invalid Phone Number");

            }
            else if (password.length()<5)
            {
                CusPPass.setError("Atleast need 5 characters!");

            }

            else if(!password.equals(Conpass))
            {
                CusCConPass.setError("password Not Match");


            }





        else
        {
            Intent go  = getIntent();
            String type = go.getStringExtra("customer");

            String id = ref.push().getKey();

            AddUser user = new AddUser(id,Name,Gender,PhoneNo,City,Email,password,Conpass,type);

            ref.child(id).setValue(user);

            Toast.makeText(CusReg.this,"New user added",Toast.LENGTH_LONG).show();


            String uname = CusName.getText().toString();
            Intent in = new Intent(getApplicationContext(),temp1.class);
            in.putExtra("uname",uname);
            startActivity(in);


        }








    }



});


}


}


