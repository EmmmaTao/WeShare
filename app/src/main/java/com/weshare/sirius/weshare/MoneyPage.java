package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//import com.paypal.api.payments.Amount;
//import com.paypal.api.payments.Payer;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.RedirectUrls;
//import com.paypal.api.payments.Transaction;
//import com.paypal.android.sdk.payments.PayPalConfiguration;

public class MoneyPage extends AppCompatActivity {
    public static final int PAYPAL_REQUEST_CODE = 7171;
//    PAYMENTACTION = Authorization
//
//    private static PayPalConfiguration config = new PayPalConfiguration()
//            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
//            .clientId(Config.PAYPAL_CLIENT_ID);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_page);

        String providername= "";
        String provideditem = "";

        if(getIntent().hasExtra("com.weshare.borrower.provider.name")){
            TextView tv = (TextView) findViewById(R.id.textView);
            TextView tv3 = (TextView) findViewById(R.id.textView3);
            providername = getIntent().getExtras().getString("com.weshare.borrower.provider.name");
            provideditem = getIntent().getExtras().getString("com.weshare.borrower.willreceive.item");
            tv.setText(providername + " will lend you the "+ provideditem);
            tv3.setText("Click to have $5 on hold and proceed borrowing!");
        }


        Intent startIntent = new Intent(getApplicationContext(), FinishandChat.class);
        startIntent.putExtra("com.weshare.borrower.providername",providername);
    }
}
