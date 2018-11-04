package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishAcceptRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_accept_request);

        Button FinishAcceptRequestBackToMainPageButton = (Button) findViewById(R.id.FinishAcceptRequestBackToMainPageButton);
        FinishAcceptRequestBackToMainPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Back = new Intent(getApplicationContext(), WelcomePage.class);
                startActivity(Back);
            }
        });
    }
}
