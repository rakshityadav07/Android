package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout rootLayout;
    ListView lv;
    ArrayList<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);

        strings.add("Harshit");
        strings.add("Arnav");
        strings.add("Swastika");
        strings.add("Abhay");
        strings.add("Saumya");
        strings.add("Sir Dheeraj");
        strings.add("Raghav");
        strings.add("Malika");
        strings.add("Abhinav");
        strings.add("Rohit");
        strings.add("Arpit");
        strings.add("Rakshit");
        strings.add("Ankit");
        strings.add("Lavanya");
        strings.add("Keshav");
        strings.add("Akshay");
        strings.add("Shashikant");
        strings.add("Sahil");
        strings.add("Anuj");
        strings.add("Samarth");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.item_row,R.id.tvName,strings);
        lv.setAdapter(arrayAdapter);
    }
}
