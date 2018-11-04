package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.TextView;

public class NotificationTrigger extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 66666;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_trigger);

        TextView tv6 = (TextView) findViewById(R.id.textView6);
        TextView tv = (TextView) findViewById(R.id.textView4);
        tv6.setText("Congratulations! Your request is on the way...");
        tv.setText("No one respond?? Try the magic button below!");
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void kbuttonClicked(View view){
        notification.setSmallIcon(R.drawable.ic_home_black_24dp);
        notification.setTicker("...");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("(name)is helping you!");
        notification.setContentText("(parameters of the item)");

        Intent intent = new Intent(this, ReceiveHelp.class);
        PendingIntent pd = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        notification.setContentIntent(pd);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());
    }
}
