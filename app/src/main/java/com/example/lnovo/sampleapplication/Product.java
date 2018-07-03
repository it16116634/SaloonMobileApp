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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Product extends AppCompatActivity {

    Button fbut;
    FirebaseDatabase bd;
    DatabaseReference ref;
    AddProduct pro;
    EditText iname,ino,iprice,iqty;

    String id;
    TextView uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);




        iname = (EditText) findViewById(R.id.editText);
        ino= (EditText) findViewById(R.id.editText2);
        iprice = (EditText) findViewById(R.id.editText3);
        iqty = (EditText) findViewById(R.id.editText4);
        pro = new AddProduct();


        fbut=  (Button) findViewById(R.id.btn);
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("product");



        uname = (TextView) findViewById(R.id.salonUsernameTextView2);
        id = ref.push().getKey();
        ino.setText(id);





        fbut.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {




                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        getvalues();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });




        viwusername();



    }

    public void viwusername()
    {
        Intent in = getIntent();
        String UserNAme = in.getStringExtra("uname");
        uname.setText(UserNAme);


    }

    private void getvalues(){


        pro.setIname(iname.getText().toString());
        pro.setIno(ino.getText().toString());
        pro.setIprice(iprice.getText().toString());
        pro.setIqty(iqty.getText().toString());



        if(iname.getText().toString().isEmpty() || ino.getText().toString().isEmpty() || iprice.getText().toString().isEmpty() || iqty.getText().toString().isEmpty() )
        {
            Toast.makeText(Product.this,"You have null fields ",Toast.LENGTH_LONG).show();

        }
        else{
            Intent in = getIntent();
            String UserNAme = in.getStringExtra("uname");


            ref.child(UserNAme).child(id).setValue(pro);
            Toast.makeText(Product.this,"Data inserted",Toast.LENGTH_SHORT).show();


        }
    }


}
