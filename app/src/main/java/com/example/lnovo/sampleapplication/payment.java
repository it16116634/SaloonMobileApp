package com.example.lnovo.sampleapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.media.MediaCas;
import android.media.tv.TvInputService;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lnovo.sampleapplication.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Properties;


public class payment extends AppCompatActivity {
    //int k=1;
    Button butt,butt1;
    FirebaseDatabase bd;
    DatabaseReference ref;
    paymentt pay;
    TextView tmo;


    //PackageInstaller.Session session =null;
   // ProgressDialog pdialog=null;
   // Context context =null;


    EditText firstname,lastname,address,phnnumber,city,mail,cardnum,visa,master;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        firstname = (EditText) findViewById(R.id.fname);
        lastname = (EditText) findViewById(R.id.lname);
        address = (EditText) findViewById(R.id.add);
        city = (EditText) findViewById(R.id.city);
        mail = (EditText) findViewById(R.id.email);
        phnnumber =(EditText) findViewById(R.id.phn);
        cardnum =(EditText) findViewById(R.id.crdnum);
        tmo=(TextView)findViewById(R.id.toamo);
        pay = new paymentt();


        butt = (Button) findViewById(R.id.button2);
        butt1 = (Button) findViewById(R.id.button1);
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("paymentt");

        //context = this;

        //getDefaultIns



        butt.setOnClickListener( new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                /*String to = mail.getText().toString();
                String message = "hellowww kohomada oyatka";

                /*Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                intent.putExtra(Intent.EXTRA_TEXT,message);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"select email app"));*/

                /*Properties props=new Properties();
                props.put("mail.smtp.host","smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port","456");
                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth","true");
                props.put("mail.smtp.port","456");*/






            ref.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        getvalues();


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                Intent s=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/signin?country.x=US&locale.x=en_US"));
                startActivity(s);

            }
        });
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent run1 = new Intent(getApplicationContext(), selection.class);
                startActivity(run1);
            }
        });




        getString();

    }

    public void getString()
    {
        Intent in = getIntent();
        String tot= in.getStringExtra("ywwa");
        String name = in.getStringExtra("uname");
        firstname.setText(name);
        tmo.setText(tot);


    }

    private void getvalues(){
        pay.setFirstname(firstname.getText().toString());
        pay.setLastname(lastname.getText().toString());
        pay.setAddress(address.getText().toString());
        pay.setCity(city.getText().toString());
        pay.setPhnnumber(phnnumber.getText().toString());
        pay.setEmail(mail.getText().toString());
        pay.setCardnum(cardnum.getText().toString());

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || address.getText().toString().isEmpty() || city.getText().toString().isEmpty() || phnnumber.getText().toString().isEmpty() || mail.getText().toString().isEmpty()|| cardnum.getText().toString().isEmpty())
        {
            Toast.makeText(payment.this,"You have null fields ",Toast.LENGTH_LONG).show();

        }
        else if (!(mail.getText().toString().matches(emailPattern)))
        {

            mail.setError("Invalid email Adddress");

        }
        else if (phnnumber.getText().toString().length()<10)
        {
            mail.setError("Invalid Phone Number");

        }
        else if (cardnum.getText().toString().length()>16)
        {
            cardnum.setError("Atmost 16 characters!");

        }

        else
        {
            ref.child("user"+phnnumber.getText()).setValue(pay);
            Toast.makeText(payment.this,"Data inserted",Toast.LENGTH_LONG).show();


        }

    }



}
