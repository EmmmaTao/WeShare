package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        if (getIntent().hasExtra("com.weshare.sirius.weshare, username")) {
            TextView TestTextView = (TextView) findViewById(R.id.SecondPageTextView);
            String text = getIntent().getExtras().getString("com.weshare.sirius.weshare, welcomeusername");
            TestTextView.setText(text);
        }

        Button ViewRequestButton = (Button) findViewById(R.id.ViewRequestButton);
        ViewRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent StartIntent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(StartIntent);
            }
        });

        Button PostRequestButton = (Button) findViewById(R.id.PostRequestButton);
        PostRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PostIntent = new Intent(getApplicationContext(), PostRequest.class);
                startActivity(PostIntent);
            }
        });

        Button ViewAllRequestButton = (Button) findViewById(R.id.ViewAllRequestButton);
        ViewAllRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ViewAllRequest = new Intent(getApplicationContext(), DetailRequest.class);
                startActivity(ViewAllRequest);
            }
        });
    }
}
