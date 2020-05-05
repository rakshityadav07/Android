package com.example.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGo.setOnClickListener {

            val stringUrl = etUrl.text.toString()

            val url : URL =  URL(stringUrl)

            thread {
                /*Open a connection between a device and the URL*/
                val urlConnection = url.openConnection() as HttpURLConnection

                /*When we download or upload any file it is in byteArray So input string automatically convert in into that type eg imageType or pdfType*/
                /*Get the stream of data from the connection*/
                val inputStream = urlConnection.inputStream

                /*Create a scanner and initialized with the input stream*/
                val scanner = Scanner(inputStream)
                /*Instruct the scanner to read the entire content in one GO*/
                scanner.useDelimiter("\\A")
                /*Sanity check so that we ensure we dont get "null" from the scanner next() method*/
                if (scanner.hasNext()){
                    val result = scanner.next()
                    runOnUiThread {
                        tvContent.text = result
                    }
                }
            }

//            var response : StringBuilder = StringBuilder()

//            /*Until the last element of Stream is reached, keep on reading from the stream and
//            * append the data to StringBuilder*/
//            while (scanner.hasNext()){
//                response.append(scanner.next())
//            }
//
//            /*Save the result as a String*/
//            val result = response.toString()

        }

    }
}
