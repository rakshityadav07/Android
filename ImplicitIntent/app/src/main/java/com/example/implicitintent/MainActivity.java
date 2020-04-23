package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPhone,btnBrowser,btnEmail;
    EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowser = findViewById(R.id.btnBrowser);
        btnEmail = findViewById(R.id.btnEmail);
        btnPhone = findViewById(R.id.btnPhone);
        etInput = findViewById(R.id.etInput);

        btnPhone.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String input = etInput.getText().toString();
        Intent intent = new Intent();

        switch(v.getId()){
            case R.id.btnPhone :
                /*Start the input based on the input*/
                if(!input.startsWith("tel:")){
                    input = "tel:" + input;
                }
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(input));
                break;

            case R.id.btnBrowser :
                /*Start the input based on the input*/
                if(!input.startsWith("https://") || !input.startsWith("http://")){
                    input = "https://" + input;
                }
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(input));
                break;

            case R.id.btnEmail :
                /*Start the input based on the input*/
                if(!input.startsWith("mailto:")){
                    input = "mailto:" + input;
                }
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse(input));
                break;
        }
        startActivity(intent);

    }
}
