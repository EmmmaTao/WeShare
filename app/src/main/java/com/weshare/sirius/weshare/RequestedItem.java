package com.weshare.sirius.weshare;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RequestedItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_item);

        EditText  RequestedItemAdditionalEditText = (EditText) findViewById(R.id.RequestedItemAdditionalEditText);
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.parseColor("#00ffffff"));
        gd.setStroke(2,Color.BLACK);
        RequestedItemAdditionalEditText.setBackground(gd);

        TextView RequestedItemNameTextView = (TextView) findViewById(R.id.RequestedItemNameTextView);
        String ItemName = getIntent().getExtras().getString("com.weshare.sirius.weshare, requestedname");
        RequestedItemNameTextView.setText("The name of this item:" + ItemName);

        Button RequestedItemSaveButton= (Button) findViewById(R.id.RequestedItemSaveButton);
        RequestedItemSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
