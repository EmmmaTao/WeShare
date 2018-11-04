package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceiveHelpT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_help_t);




        Button wtf = (Button) findViewById(R.id.wtf);
        wtf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent thisIntent = new Intent(getApplicationContext(), MoneyPageT.class);

                //this request is called r

                thisIntent.putExtra("com.weshare.borrower.provider.name","a");
                thisIntent.putExtra("com.weshare.borrower.willreceive.item","a");
                startActivity(thisIntent);
            }
        });
    }
}
