package com.example.okhttpgson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    val catFacts = "https://cat-fact.herokuapp.com/facts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(catFacts)
            .build()


        val call : Call = client.newCall(request)

        call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                call.enqueue(this)
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                Log.e("TAG",result)
            }
        })

//        val response = client.newCall(request).execute()
//        val responseBody = response.body
//        val result = responseBody?.string()
//
//        Log.e("TAG",result)

//        val request2 = Request.Builder()
//            .url(catFacts)
//            .build()
//
//        val response1 = client.newCall(request2).execute()
//        val responseBody2 = response1.message.toString()
//        Log.e("response2",responseBody2)
    }
}
