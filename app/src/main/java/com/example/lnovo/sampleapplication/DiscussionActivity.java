package com.example.lnovo.sampleapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DiscussionActivity extends AppCompatActivity {

    Button btnSendMsg;
    EditText etMsg;

    ListView lvDiscussion;
    ArrayList<String> listConversation = new ArrayList<String>();
    ArrayAdapter arrayAdpt;
    private DatabaseReference dbr;
    String UserName,SelectedTopic, user_msg_key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        btnSendMsg = (Button)findViewById(R.id.btnSendMsg);
        etMsg = (EditText) findViewById(R.id.etMessage);
        lvDiscussion = (ListView) findViewById(R.id.lvConversation) ;
        arrayAdpt = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listConversation);
        lvDiscussion.setAdapter(arrayAdpt);

        UserName = getIntent().getExtras().get("UserName").toString();
        SelectedTopic = getIntent().getExtras().get("Select Salon").toString();
        setTitle("SalonName : "+ SelectedTopic);
        dbr = FirebaseDatabase.getInstance().getReference("Android App").child("Android App Development");

        btnSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> map = new HashMap<String,Object>();
                user_msg_key = dbr.push().getKey();
                dbr.updateChildren(map);

                DatabaseReference dbr2 = dbr.child(user_msg_key);
                Map<String,Object> map2 = new HashMap<String,Object>();
                map2.put("msg",etMsg.getText().toString());
                map2.put("user",UserName);
                dbr2.updateChildren(map2);

            }
        });
        dbr.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                UpdateConversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                UpdateConversation(dataSnapshot);
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

    public void UpdateConversation(DataSnapshot dataSnapshot) {
        String msg,user,conversation;
        Iterator i = dataSnapshot.getChildren().iterator();
        while (i.hasNext()){
            msg =  (String) ((DataSnapshot)i.next()).getValue();
            user = (String) ((DataSnapshot)i.next()).getValue();

            conversation = user + ":"+ msg;
            arrayAdpt.insert(conversation,0);
            arrayAdpt.notifyDataSetChanged();

        }

    }
}
