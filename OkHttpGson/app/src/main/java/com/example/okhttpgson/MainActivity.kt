package com.example.okhttpgson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val catFacts = "https://pokeapi.co/api/v2/pokemon/25"
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(catFacts)
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                call.enqueue(this)
            }

            override fun onResponse(call: Call, response: okhttp3.Response) {
                /*ResponseBody extends closable which extends an interface
                * which means we can only read once that what we saved in result*/
                val responseBody = response?.body
                val result = responseBody?.string()
                val parseObject = gson.fromJson(result,Response::class.java)
                Log.e("TAG",parseObject.moves.)
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
