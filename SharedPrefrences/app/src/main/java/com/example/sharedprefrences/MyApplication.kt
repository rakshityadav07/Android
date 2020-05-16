package com.example.sharedprefrences

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = getSharedPreferences("mysharePreference", Context.MODE_PRIVATE)

        val isLoggedIn  = sharedPreferences.contains("IS_LOGGED_IN")

        if(isLoggedIn){
            //Start the intent for the home Screen
        }else{
            //Start intent for the login screen
            //Set the flag IS_LOGGED_IN to 'true' once the user has logged in
        }

    }

}
