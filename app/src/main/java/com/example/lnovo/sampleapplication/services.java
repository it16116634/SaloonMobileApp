package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class services extends AppCompatActivity {




    Button servbtn;
    DatabaseReference ref;
    Spinner servc;

    EditText serprice;
    TextView uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        ref = FirebaseDatabase.getInstance().getReference("services");



        servc = (Spinner) findViewById(R.id.spinnerServ);
        serprice = (EditText)findViewById(R.id.AddPrice);
        servbtn = (Button) findViewById(R.id.ServiceBtn);



        uname = (TextView) findViewById(R.id.salonUsernameTextView);

        getValues();

        viwusername();
    }



    public void viwusername()
    {
        Intent in = getIntent();
        String UserNAme = in.getStringExtra("uname");
        uname.setText(UserNAme);


    }





    private void getValues() {

        servbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){





                String serviceList = servc.getSelectedItem().toString();
                String price =serprice.getText().toString().trim();




                if(price.isEmpty())
                {
                    Toast.makeText(services.this,"You Should Enter the Price ",Toast.LENGTH_LONG).show();

                }
                else {


                    String id = ref.push().getKey();

                    AddServices services = new AddServices(id, serviceList, price);


                    Intent in = getIntent();
                    String UserNAme = in.getStringExtra("uname");


                    ref.child(UserNAme).child(id).setValue(services);


                    Toast.makeText(services.this, "New Service Added", Toast.LENGTH_LONG).show();

                }










            }
        });


    }

}