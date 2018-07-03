package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SalonActivity extends AppCompatActivity {
    private ArrayList<String> username = new ArrayList<>();
    FirebaseDatabase bd;
    DatabaseReference ref;
    paymentt pay;
    public ListView lview;
    String value1,value2,value;
    TextView kk;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        //but = (Button) findViewById(R.id.button4);



        kk =(TextView) findViewById(R.id.txtr);
        Intent in = getIntent();
        String uname = in.getStringExtra("uname");
        kk.setText(uname);

        //auth = FirebaseAuth.getInstance();

       /* lview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent run1 = new Intent(getApplicationContext(), payment.class);
                run1.putExtra("position",pos);
                startActivity(run1);
            }
        });*/



        pay = new paymentt();
        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("services");

        lview = (ListView) findViewById(R.id.viw);
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,username);


        lview.setAdapter(arrayAdapter);
        //String value = dataSnapshot.getValue(String.class);
        //username.add(value);
        //arrayAdapter.notifyDataSetChanged();

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value = dataSnapshot.getKey();
                //value1= dataSnapshot.child("pg").getValue(String.class);
                //value2= dataSnapshot.child("").getValue(String.class);
                //String val = "Package :"+"\t\t"+value1+"\n"+"\t\t\t\t\t\t\t\t\t\t\t\t"+value2+"\n";
                username.add(value);
                arrayAdapter.notifyDataSetChanged();
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
        });lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected =((TextView)view).getText().toString();

                //String nam ="Kumari salon";
                Intent run1 = new Intent(getApplicationContext(), addtocart.class);
                //run1.putExtra("position", lview.getItemIdAtPosition(i));
                run1.putExtra("take", selected);
                startActivity(run1);

            }
        });


        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Intent run1 = new Intent(getApplicationContext(),BookingFormActivity.class);
                run1.putExtra("possition",listView.getItemIdAtPosition(i));
                startActivity(run1);

            }
        });*/
    }
}
