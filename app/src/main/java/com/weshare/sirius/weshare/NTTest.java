package com.weshare.sirius.weshare;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;

public class NTTest extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 66666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nttest);
        TextView tv7 = (TextView) findViewById(R.id.textView7);
        TextView tv8 = (TextView) findViewById(R.id.textView8);
        tv7.setText("Congratulations! Your request is on the way...");
        tv8.setText("No one respond?? Try the magic button below!");
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(false);

        Button kbtn = (Button) findViewById(R.id.kbutton2);
        kbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification.setSmallIcon(R.drawable.ic_home_black_24dp);
                notification.setTicker("uhg");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("(name)is helping you!");
                notification.setContentText("(parameters of the item)");

                Intent intent = new Intent(getApplicationContext(), ReceiveHelpT.class);
                PendingIntent pd = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                startActivity(intent);
                notification.setContentIntent(pd);

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(uniqueID, notification.build());

            }
        });
    }

}
