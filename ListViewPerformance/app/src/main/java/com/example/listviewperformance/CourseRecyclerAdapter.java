package com.example.listviewperformance;

import  android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import static com.example.listviewperformance.RecyclerActivity.TAG;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    ArrayList<Course> courses;

    public CourseRecyclerAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course,parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvLectures.setText(String.valueOf(course.getLecture()));
        holder.tvTeacherName.setText(course.getName());
        holder.tvCourseName.setText(course.getTeacherName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder {

        TextView tvCourseName,tvTeacherName,tvLectures;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvLectures = itemView.findViewById(R.id.tvLectures);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
        }
    }
}
