package com.example.listviewperformance;

import java.util.ArrayList;
import java.util.Random;

public class Course {
    String name;
    String teacherName;
    int lecture;

    public Course(String name, String teacherName, int lecture) {
        this.name = name;
        this.teacherName = teacherName;
        this.lecture = lecture;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLecture() {
        return lecture;
    }

    public static final String[] teacher = {"Harshit","Arnav","Prateek","Aayush","deepak","Garima"};

    public static final String[] courseName = {"Launchpad","Crux","Android","NodeJS","Python","AngularJS"};

    public static ArrayList<Course> generateNRandomCourses(int n){

        ArrayList<Course> courses = new ArrayList<>();
        Random r = new Random();
        for (int i=0;i<n;i++){
            Course course = new Course(
                    teacher[r.nextInt(6)],
                    courseName[r.nextInt(6)],
                    10 + r.nextInt(10)
            );
            courses.add(course);
        }
        return courses;
    }


}
