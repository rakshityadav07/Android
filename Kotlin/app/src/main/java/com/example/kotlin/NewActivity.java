package com.example.kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        if(savedInstanceState != null){
            savedInstanceState.putFloat("Keh",1F);

        }

    }
}
