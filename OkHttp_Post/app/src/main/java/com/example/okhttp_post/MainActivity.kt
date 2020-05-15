package com.example.okhttp_post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val postUrl = "http://ptsv2.com/t/4hp8b-1589526951/post"
    val gson = Gson()
    val student = Student("Rakshit","Android",21)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient
            .Builder()
            .build()

//        Method Mediatype.parse is now depreciated so we use this new method
        val mediaType = "application/json".toMediaTypeOrNull()
//        Makes Object to json
        val studentJson = gson.toJson(student)

//        First it have two parameters first string "Student json
//        secondly we have of which mediaType as it is abstract class so we have to make or own
//        by going  to website mime...."
        val requestBody = studentJson.toRequestBody(mediaType)

        val request = Request.Builder()
                .url(postUrl)
                .post(requestBody)
                .header("Hello","World")
                .build()

        client.newCall(request).enqueue(object : Callback{

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                client.newCall(request).enqueue(this)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("TAG",response.body?.string())
            }
        })



    }


}
