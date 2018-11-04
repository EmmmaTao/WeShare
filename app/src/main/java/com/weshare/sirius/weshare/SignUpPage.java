package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        TextView UserName = (TextView) findViewById(R.id.SignUpPageUserNameTextView);
        String text = getIntent().getExtras().getString("com.weshare.sirius.weshare, username");
        UserName.setText("User name:" + text);


        Spinner SignUpPageTagsSpinner = (Spinner) findViewById(R.id.SignUpPageTagsSpinner);

        ArrayAdapter<String> SignUpAdapter = new ArrayAdapter<String>(SignUpPage.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PostTags));
        SignUpAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SignUpPageTagsSpinner.setAdapter(SignUpAdapter);

        Button SignUpButton = (Button) findViewById(R.id.SignUpPageButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent StartIntent = new Intent(getApplicationContext(), WelcomePage.class);
                String username = getIntent().getExtras().getString("com.weshare.sirius.weshare, username");
                String userpassword = getIntent().getExtras().getString("com.weshare.sirius.weshare, userpassword");
                StartIntent.putExtra("com.weshare.sirius.weshare, welcomeusername", "Hello, " + username + "!");
                StartIntent.putExtra("com.weshare.sirius.weshare, username", username);

                startActivity(StartIntent);

            }
        });
    }
}
