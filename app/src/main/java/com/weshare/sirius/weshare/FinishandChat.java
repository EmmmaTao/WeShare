package com.weshare.sirius.weshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinishandChat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishand_chat);

        TextView tv = (TextView) findViewById(R.id.textView5);
        String providername = getIntent().getExtras().getString("com.weshare.borrower.providername");
        tv.setText("Your share with " + providername + "is all set!");
        Button chat= (Button) findViewById(R.id.buttonchat);
        chat.setText("Chat with "+ providername);
    }
}
