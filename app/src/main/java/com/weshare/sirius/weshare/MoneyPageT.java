package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoneyPageT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_page_t);

        String providername= "";
        String provideditem = "";

        if(getIntent().hasExtra("com.weshare.borrower.provider.name")){
            TextView tv10 = (TextView) findViewById(R.id.textView10);
            TextView tv11 = (TextView) findViewById(R.id.textView11);
            providername = getIntent().getExtras().getString("com.weshare.borrower.provider.name");
            provideditem = getIntent().getExtras().getString("com.weshare.borrower.willreceive.item");
            tv10.setText(providername + " will lend you the "+ provideditem);
            tv11.setText("Click to have $5 on hold and proceed borrowing!");
        }


        Intent startIntent = new Intent(getApplicationContext(), FinishandChatT.class);
        startIntent.putExtra("com.weshare.borrower.providername",providername);
        startActivity(startIntent);
    }
}
