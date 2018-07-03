package com.example.lnovo.sampleapplication;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {
    EditText txtInfo;
    Button btnSend;
    public final static String NOTIFICATION_DATA = "NOTIFICATION_DATA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        txtInfo = (EditText) findViewById(R.id.textInfo);
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification(Calendar.getInstance().getTimeInMillis(),txtInfo.getText().toString());
            }
        });
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
}
