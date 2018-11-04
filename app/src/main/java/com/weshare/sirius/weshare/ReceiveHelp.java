package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceiveHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_help);




        Button borrowBtn = (Button) findViewById(R.id.borrowtoproceed);
        borrowBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MoneyPage.class);

                //this request is called r
                Request r = Request.allRequests.get(Request.allRequests.size() - 1);

                startIntent.putExtra("com.weshare.borrower.provider.name",r.getProvider().getName());
                startIntent.putExtra("com.weshare.borrower.willreceive.item",r.getItemName());
                startActivity(startIntent);
            }
        });
    }
}
