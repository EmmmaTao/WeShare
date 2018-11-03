package com.weshare.sirius.weshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SignUpButton = (Button) findViewById(R.id.SignUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText SignUpPageUserNamePlainText = (EditText) findViewById(R.id.SignUpPageUserNamePlainText);
                EditText SignUpPagePasswordPassword = (EditText) findViewById(R.id.SignUpPagePasswordPassword);
                TextView result = (TextView) findViewById(R.id.SignUpPageTestTextView);

                result.setText("Congrats");
            }
        });
    }
}
