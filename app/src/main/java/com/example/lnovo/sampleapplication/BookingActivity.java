package com.example.lnovo.sampleapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.lnovo.sampleapplication.NotificationActivity.NOTIFICATION_DATA;

public class BookingActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView Price, date,price,user,salon;
    Button addButton,btnView;
    Spinner Timeslot;
    Appointment appointment;

    String name,tota;

    private static final String TAG = "Booking1Activity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);




        user = (TextView) findViewById(R.id.usertxt);

        salon = (TextView)  findViewById(R.id.salontxt);
        Price = (TextView) findViewById(R.id.pricetxt);

        Timeslot = (Spinner) findViewById(R.id.time);
        date = (TextView) findViewById(R.id.tvDate);
        addButton = (Button) findViewById(R.id.addbutton);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Appointment");
        //Booking booking = new Booking();

        List<String> list = new ArrayList<>();
        list.add("Choose Time Slot");
        list.add("9.00a.m - 10.00a.m");
        list.add("10.00a.m - 11.00a.m");
        list.add("11.00a.m - 12.00a.m");
        list.add("1.00p.m - 2.0p.m");
        list.add("2.00p.m - 3.00p.m");
        list.add("3.00p.m - 4.00p.m");


        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Timeslot.setAdapter(adapter1);

        Timeslot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemvalue = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mDisplayDate = (TextView) findViewById(R.id.tvDate);


        getString();
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(BookingActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yy:" + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        addButton.setOnClickListener(new View.OnClickListener() {
            String fg ="your Booking successfull, Thank you!!!!";
            @Override
            public void onClick(View v) {
                getValues();
                createNotification(Calendar.getInstance().getTimeInMillis(),fg);

                Intent rok=new Intent(getApplicationContext(),payment.class);

                rok.putExtra("uname",user.getText());
                rok.putExtra("ywwa",price.getText());
                startActivity(rok);
            }
        });

    }
    private void getValues() {
        String un =user.getText().toString().trim();
        String sname = salon.getText().toString().trim();
        String price= Price.getText().toString().trim();
        String time = Timeslot.getSelectedItem().toString().trim();
        String Date = date.getText().toString().trim();

        if(!TextUtils.isEmpty(un) && !TextUtils.isEmpty(sname)  && !TextUtils.isEmpty(time) && !TextUtils.isEmpty(Date)){
           String id= databaseReference.push().getKey();
            Booking booking = new Booking(un,sname,price,time,Date);
            databaseReference.child(id).setValue(booking);

            Toast.makeText(this,"Data Inserted..",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "You should enter all fields  ",Toast.LENGTH_LONG).show();
        }


    }
    private void createNotification(long time, String text){
        String notificationContent = "Detail : press to show detail ";
        String notificationTitle = "Notification";

        Bitmap largeicon = BitmapFactory.decodeResource(getResources(),R.drawable.ic_menu_gallery);
        int smallicon = R.drawable.ic_menu_camera;

        //set data and call intent notification
        Intent intent = new Intent(getApplicationContext(),NotificationDetailActivity.class);
        intent.putExtra(NOTIFICATION_DATA,"Detail : "+ text);
        intent.setData(Uri.parse("content://" + time));


        @SuppressLint("WrongConstant") PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        //create a request notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(getApplicationContext());

        builder.setWhen(time).setContentText(notificationContent).setContentTitle(notificationTitle).setSmallIcon(smallicon).setAutoCancel(true).setTicker(notificationTitle).setLargeIcon(largeicon).setDefaults(Notification.DEFAULT_LIGHTS
                | Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent);

        Notification notification = builder.build();
        notificationManager.notify((int)time,notification);
    }
    public void getString()
    {
        Intent in = getIntent();
        String tot= in.getStringExtra("ywwa");
        String name= in.getStringExtra("uname");
        price.setText(tot);
        user.setText(name);



    }
}
