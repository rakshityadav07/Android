package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.concurrent.thread



class MainActivity : AppCompatActivity() {

    val responses = arrayListOf<Response>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvJson.layoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        var adapter: ResponseAdapter = ResponseAdapter(responses)
        rvJson.adapter = adapter



        btnGo.setOnClickListener{

            thread {
                var result : String = makeNetworkCall()

                /*Extract JSON from the result*/

                val jsonResult = JSONObject(result)

                val resultArray = jsonResult.optJSONArray("all")

                for (i in 0 until resultArray.length()-1){
                    val curResult = resultArray.optJSONObject(i)

                    val text  = curResult.optString("text")

                    val jsonUser  = curResult?.optJSONObject("user")

                    val jsonName = jsonUser?.optJSONObject("name")

                    /* ?: (elvis operator) is an alternate for the 'else' block from the null check*/
                    val first = jsonName?.optString("first") ?: ""

                    val last = jsonName?.optString("last") ?: ""

                    val name = Name(first,last)

                    val user = User(name)

                    val response = Response(text,user)
                    responses.add(response)
                    val i = i + 1;
                    break;
                }
                runOnUiThread {

                    adapter.notifyDataSetChanged()

//                    val i = Random().nextInt(responses.size-1)
//                    Log.e("TAG", "Text : ${responses[i].text}")
//                    Log.e("TAG","user : ${responses[i].user.name.first}  ${responses[i].user.name.last}")
//                    /*notify the adapter*/
                }

            }
        }
    }


    fun makeNetworkCall(): String {

//        val stringUrl = etUrl.text.toString()

        val stringUrl = "https://cat-fact.herokuapp.com/facts"

        val url : URL =  URL(stringUrl)

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

        var result : String = ""

        if (scanner.hasNext()){
            result = scanner.next()
        }
        return result
    }

}
