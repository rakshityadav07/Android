package com.example.sharedprefrences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Most modes are present in context*/
        val sharedPreferences = getSharedPreferences("mysharePreference",Context.MODE_PRIVATE)

        /*So when the app restarts again so we have sharedPreferences so we retrieve*/
        val retrieve = sharedPreferences.getString("Name","")
        etText.setText(retrieve)

        btnButton.setOnClickListener {

            val input = etText.text.toString()
            /*Store this in shared preferences*/

            val editor = sharedPreferences.edit()

            editor.putString("Name",input)
            editor.apply()

        }

    }
}
