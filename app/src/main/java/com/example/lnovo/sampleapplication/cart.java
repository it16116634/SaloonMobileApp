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

public class cart extends AppCompatActivity {
    ArrayList<String> arr1;
    ArrayList<Integer> arr2 = new ArrayList<>();
   // ArrayList<String> arr3 = new ArrayList<>();
    Button bt3,b4;

    TextView k;
    FirebaseDatabase bd;
    DatabaseReference ref;
    public ListView lview1,lview2;
    String value1,value2,name,ww;

    int v2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        bt3=(Button) findViewById(R.id.button6);
        b4=(Button) findViewById(R.id.ghg);
        Intent in = getIntent();
        arr1 = in.getStringArrayListExtra("went");

        name= in.getStringExtra("take");
        ww= in.getStringExtra("uname");

        bd = FirebaseDatabase.getInstance();
        ref = bd.getReference("services").child(name);

        k = (TextView) findViewById(R.id.t14);
        //k.setText(una[1]);
        //for (int i=0;i<una){
        lview1 = (ListView) findViewById(R.id.cartvw);
        //lview1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr1);
        lview1.setAdapter(arrayAdapter);


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value1= dataSnapshot.child("service").getValue(String.class);
                for (int i=0;i<arr1.size();i++) {
                if(value1.equals(arr1.get(i))) {
                    value2 = dataSnapshot.child("price").getValue(String.class);
                    v2=Integer.parseInt(value2);
                    arr2.add(v2);
                }
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












       // arr3=arr1;


/*
        lview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selected =((TextView)view).getText().toString();


                if(arr2.contains(selected)){
                    arr2.remove(selected);
                }
                else
                    arr2.add(selected);





            }
        });*/
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arr3.removeAll(arr2);

               total(v);
            }
        });
        //final ArrayAdapter<String> arrayAdapter1= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr3);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent run1 = new Intent(getApplicationContext(), payment.class);

                run1.putExtra("ywwa",k.getText());
                run1.putExtra("uname",ww);
                startActivity(run1);



            }
        });


    }
    public void shw(View view){
        String items="";


        for (int item:arr2){

                items += "-" + item + "\n";



        }
        Toast.makeText(this,"Removed items \n"+items,Toast.LENGTH_SHORT).show();
    }

    public void total(View view){
        int items = 0;


        for (int item:arr2){

            items += item;

            }
            k.setText("Rs. "+items);
        //Toast.makeText(this,"Total Price \n"+items,Toast.LENGTH_SHORT).show();
    }
}
