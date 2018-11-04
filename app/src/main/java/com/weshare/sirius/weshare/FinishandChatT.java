package com.weshare.sirius.weshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FinishandChatT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishand_chat_t);

        TextView tv = (TextView) findViewById(R.id.textView12);
        String providername = getIntent().getExtras().getString("com.weshare.borrower.providername");
        tv.setText("Your share with " + providername + "is all set!");
        Button chat= (Button) findViewById(R.id.buttonchat2);
        chat.setText("Chat with "+ providername);
    }
}
