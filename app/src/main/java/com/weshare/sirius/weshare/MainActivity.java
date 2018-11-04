package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User.initdummyusers();
        Request.initializeAllRequest();
        Button SignUpButton = (Button) findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText SignUpPageUserNamePlainText = (EditText) findViewById(R.id.SignUpPageUserNamePlainText);
                EditText SignUpPagePasswordPassword = (EditText) findViewById(R.id.SignUpPagePasswordPassword);

                Intent StartIntent = new Intent(getApplicationContext(), SignUpPage.class);
                StartIntent.putExtra("com.weshare.sirius.weshare, username", SignUpPageUserNamePlainText.getText().toString());
                StartIntent.putExtra("com.weshare.sirius.weshare, userpassword", SignUpPagePasswordPassword.getText().toString());
                startActivity(StartIntent);
            }
        });
    }
}
