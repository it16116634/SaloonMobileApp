package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class addtocart extends AppCompatActivity {
    private ArrayList<String> serv = new ArrayList<>();
    private ArrayList<String> arr = new ArrayList<>();
    FirebaseDatabase bd;
    DatabaseReference ref;
    public ListView lview;
    String value1;
    String value2;
    Button bt,bt2;
    String tot,tot1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);

        bt2=(Button)findViewById(R.id.abc);
        bt=(Button)findViewById(R.id.btt);
        bd = FirebaseDatabase.getInstance();
        Intent in = getIntent();
        tot= in.getStringExtra("take");
        tot1= in.getStringExtra("uname");

        ref = bd.getReference("services").child(tot);

        lview = (ListView) findViewById(R.id.kkm);
        lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] item={};
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,R.layout.rowlayout,R.id.txtln,serv);
        lview.setAdapter(arrayAdapter);


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value1= dataSnapshot.child("service").getValue(String.class);
                value2= dataSnapshot.child("price").getValue(String.class);
                String val = value1+"\t\t\t\t\t\t\t\t\t\t\t\t"+value2;
                 serv.add(value1);
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
        });

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selected =((TextView)view).getText().toString();
                if(arr.contains(selected)){
                    arr.remove(selected);
                }
                else
                    arr.add(selected);

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shw(v);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {
              Intent rl=new Intent();
              rl.putExtra("went",arr);
              //startActivity(rl);
                Intent rok=new Intent(getApplicationContext(),cart.class);
                rok.putStringArrayListExtra("went",arr);
                rok.putExtra("take", tot);
                rok.putExtra("uname", tot1);
                startActivity(rok);
            }
        });



    }
    public void shw(View view){
        String items="";

        for (String item:arr){
            items+="-"+item+"\n";
            //Intent rn=new Intent();
            //rn.putExtra("go",item);
            //startActivity(rn);

        }
        Toast.makeText(this,"you have \n"+items,Toast.LENGTH_LONG).show();
    }
}
