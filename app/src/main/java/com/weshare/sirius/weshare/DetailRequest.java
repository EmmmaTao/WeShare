package com.weshare.sirius.weshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_request);

        final int testint = 5;
        Button DetailRequestBack = (Button) findViewById(R.id.DetailRequestGoBackButtion);
        Button DetailAccept = (Button) findViewById(R.id.DetailRequestAcceptButton);

        String BorrowerName = Request.allRequests.get(testint).getBorrower().getName();
        TextView DetailRequestBorrowerTextView = (TextView) findViewById(R.id.DetailRequestBorrowerNameTextView);
        String Name = BorrowerName;
        TextView DetailRequestTagTextView = (TextView) findViewById(R.id.DetailrequestTagTextView);
        TextView DetailRequestItemNameTextView = (TextView) findViewById(R.id.DetailRequestItemNameTextView);
        //String Tag = Request.allRequests.get(testint).getTags();
        final String Requested = Request.allRequests.get(testint).getItemName();;

        DetailRequestBorrowerTextView.setText("Name of the borrower: " + Name);
        //DetailRequestTagTextView.setText("Tag of the item requested: " + Tag);
        DetailRequestItemNameTextView.setText("Name of the item requested: " + Requested);

        DetailAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RequestedItem = new Intent(getApplicationContext(), RequestedItem.class);

                RequestedItem.putExtra("com.weshare.sirius.weshare, requestedname", Requested);
                //RequestedItem.putExtra("com.weshare.sirius.weshare, requestedtag", Tag);
                startActivity(RequestedItem);
            }
        });




    }
}
