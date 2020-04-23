package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStartIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartIntent = findViewById(R.id.btnStartIntent);

        btnStartIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Start the new Activity
//                1. Create an object of the intent class
//                2. Start the intent

                Intent i = new Intent(getBaseContext(),NewActivity.class);
                startActivity(i);

            }
        });
    }
}
