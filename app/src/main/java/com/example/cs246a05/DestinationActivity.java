package com.example.cs246a05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.cs246a05.R;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        TextView values = (TextView)findViewById(R.id.txtValues);
        TextView shared = (TextView)findViewById(R.id.txtShared);

        // extract any data passed by the caller
        Intent callingIntent = getIntent();
        if (callingIntent != null) {

                String book = callingIntent.getStringExtra("book");
                /*Integer chapter = callingIntent.getIntExtra("chapter", -1);
                Integer verse = callingIntent.getIntExtra("verse", -1);*/
                String chapter = callingIntent.getStringExtra("chapter");
                String verse = callingIntent.getStringExtra("verse");

                String passedData = book + ": " + chapter + ":" + verse;
                values.setText(passedData);
                Log.i("Display: ", ("Received intent with " + passedData));
        }

        SharedPreferences sharedPref = getSharedPreferences("quote", Context.MODE_PRIVATE);
        if (sharedPref != null) {
            String book = sharedPref.getString("book", "");
            String chapter = sharedPref.getString("chapter", "");
            String verse = sharedPref.getString("verse", "");

            String passedData = book + ": " + chapter + ":" + verse;
            shared.setText(passedData);
        }


    }
}
