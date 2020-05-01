package com.example.listviewperformance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCourses;
    ArrayList<Course> courses = Course.generateNRandomCourses(100);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        CourseAdapter courseAdapter = new CourseAdapter();
        lvCourses.setAdapter(courseAdapter);

    }

    class CourseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int position) {
            return courses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = getLayoutInflater().inflate(
                    R.layout.list_item_course,
                    parent,
                    false
            );

            TextView tvCourseName = itemView.findViewById(R.id.tvCourseName);
            TextView tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            TextView tvLecture = itemView.findViewById(R.id.tvLectures);
            Course course = getItem(position);
            tvCourseName.setText(course.getName());
            tvTeacherName.setText(course.getTeacherName());
            tvLecture.setText(String.valueOf(course.getLecture()));
            return itemView;
        }
    }


}
