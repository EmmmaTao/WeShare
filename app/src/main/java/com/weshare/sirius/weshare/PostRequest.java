package com.weshare.sirius.weshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PostRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);


        Spinner PostRequestTagsSpinner = (Spinner) findViewById(R.id.PostRequestTagsSpinner);

        ArrayAdapter<String> PostRequestAdapter = new ArrayAdapter<String>(PostRequest.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PostTags));
        PostRequestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PostRequestTagsSpinner.setAdapter(PostRequestAdapter);

        Button PostRequestButton = (Button) findViewById(R.id.PostRequestButton);
        


    }
}
