package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        if (getIntent().hasExtra("com.weshare.sirius.weshare, testtest")) {
            TextView TestTextView = (TextView) findViewById(R.id.SecondPageTextView);
            String text = getIntent().getExtras().getString("com.weshare.sirius.weshare, testtest");
            TestTextView.setText(text);
        }
    }
}
