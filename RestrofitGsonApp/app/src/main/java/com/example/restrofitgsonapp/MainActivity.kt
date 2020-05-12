package com.example.restrofitgsonapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

     var userList = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvName.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val gsonAdapter = GsonAdapter(userList)
        rvName.adapter = gsonAdapter

        val r = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
                /*GsonConveterFactory is an object which takes string converts into json object or vice versa using Gson*/
            .addConverterFactory(GsonConverterFactory.create())
                /*by doing build we get object of Retrofit*/
            .build()

        /*in java we do "interface.class"
        * Kotlin -> "interface :: class.java"*/
        val client = r.create(JsonPlaceholderApi :: class.java)
        /*Use "enqeue" if u are on UI thread as it create asyncTask automatically and implements two method which are same as postExecute in asyncTask
        * if CallBack is successful then onResponse will run otherwise OnFailure is called*/
        /*Use execute only when u are writting the code in AsynTask or Thread(Kotlin) as it donot make async internally as enqeue does */
        client.getUsers().enqueue(
            object : Callback<ArrayList<User>>{
                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Log.e("RESP","Error finding data",t)
                }
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
//                    userList = response.body()!!
//                    gsonAdapter.setUsers(userList)

                    var gsonUser = response.body()
                    gsonAdapter.setUsers(gsonUser)

                }
            }
        )



    }


}

