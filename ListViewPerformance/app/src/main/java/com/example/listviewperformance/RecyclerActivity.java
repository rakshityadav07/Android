package com.example.listviewperformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    public static final String TAG = "RV";

    ArrayList<Course> courses = Course.generateNRandomCourses(100);
    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this)); // also take reverseLayout means last input will be at the top and will show in reverse order

        CourseRecyclerAdapter courseAdapeter = new CourseRecyclerAdapter(courses);
        rvCourses.setAdapter(courseAdapeter);
    }

}
