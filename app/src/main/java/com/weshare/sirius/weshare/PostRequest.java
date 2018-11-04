package com.weshare.sirius.weshare;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashSet;

public class PostRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);


        final Spinner PostRequestTagsSpinner = (Spinner) findViewById(R.id.PostRequestTagsSpinner);

        EditText  PostRequestOtherInfoEditText = (EditText) findViewById(R.id.PostRequestOtherInfoEditText);
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.parseColor("#00ffffff"));
        gd.setStroke(2,Color.BLACK);
        PostRequestOtherInfoEditText.setBackground(gd);

        ArrayAdapter<String> PostRequestAdapter = new ArrayAdapter<String>(PostRequest.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PostTags));
        PostRequestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PostRequestTagsSpinner.setAdapter(PostRequestAdapter);

        Button PostRequestButton = (Button) findViewById(R.id.PostRequestButton);
        PostRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String SelectedTag = PostRequestTagsSpinner.getSelectedItem().toString();
                HashSet<String> TagRequest = new HashSet<String>();
                TagRequest.add(SelectedTag);
                EditText PostRequestItemNameEditText = (EditText) findViewById(R.id.PostRequestItemNameEditText);
                String ItemName = PostRequestItemNameEditText.getText().toString();
                int index = User.allusers.size() - 1;

                Request newrequest = new Request(User.allusers.get(index), TagRequest, ItemName);
                Intent startIntent = new Intent(getApplicationContext(), NTTest.class);
//                startIntent.putExtra("com.weshare.provider.name", User.allusers.get(index).getName());
//                startIntent.putExtra("com.weshare.provider.itemName", ItemName);
                startActivity(startIntent);

            }
        });
    }
}
