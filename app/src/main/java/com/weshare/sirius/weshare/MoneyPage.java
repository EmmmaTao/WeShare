package com.weshare.sirius.weshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    }
}
