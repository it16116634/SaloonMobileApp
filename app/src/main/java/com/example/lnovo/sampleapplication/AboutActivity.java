package com.example.lnovo.sampleapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AboutActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String[] about = new String[]
                {"Privancy Policy","About Us","Term & Condition","Facebook","Instagram","Twitter","YouTube" };
        ListAdapter buckyaAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,about);
        ListView lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(buckyaAdapter);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch (position) {

                   case 0:

                       Intent intent = new Intent(getApplicationContext(), PolicyActivity.class);
                       startActivity(intent);
                       break;
                   case 1:

                      // Intent intent1 = new Intent(getApplicationContext(),.class);
                      // startActivity(intent1);
                       //break;
                   case 2:

                       Intent intent2 = new Intent(getApplicationContext(),TermActivity.class);
                       startActivity(intent2);
                       break;

                   case 3:
                       Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                       myWebLink.setData(Uri.parse("https://www.facebook.com/tharaki.desilva"));
                       startActivity(myWebLink);
                       break;

                   case 4:
                       Intent myWebLink2 = new Intent(android.content.Intent.ACTION_VIEW);
                       myWebLink2.setData(Uri.parse("https://www.instagram.com/tharaki_95/"));
                       startActivity(myWebLink2);
                       break;

                   case 5:
                       Intent myWebLink3 = new Intent(android.content.Intent.ACTION_VIEW);
                       myWebLink3.setData(Uri.parse("https://twitter.com/TharakiDe"));
                       startActivity(myWebLink3);
                       break;
                   case 6:
                       Intent myWebLink4 = new Intent(android.content.Intent.ACTION_VIEW);
                       myWebLink4.setData(Uri.parse("https://www.youtube.com/watch?v=e1n45q-SF0g"));
                       startActivity(myWebLink4);
                       break;

               }
           }
       });
    }
}
