package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val API_KEY = "984501863f994d0b9e62c20e49a8ffc7"
    var article = ArrayList<Article>()
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    /**/
    val db by lazy{
        Room.databaseBuilder(this,HeadlineDatabase::class.java,"NewsDb.db")
            .build()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout = findViewById(R.id.swipeRefresh)

        rvView.layoutManager = LinearLayoutManager(this)
        val country = getCountry() ?: "In"

        swipeRefreshLayout.setOnRefreshListener {
            retreiveJson("",country, API_KEY)
        }
        retreiveJson("",country,API_KEY)

        btnSearch.setOnClickListener {

            if(etQuery.text.toString() != ""){
                swipeRefreshLayout.setOnRefreshListener {
                    retreiveJson(etQuery.text.toString(),country, API_KEY)
                }
                retreiveJson(etQuery.text.toString(),country,API_KEY)
            }else{
                swipeRefreshLayout.setOnRefreshListener {
                    retreiveJson("",country, API_KEY)
                }
                retreiveJson("",    country,API_KEY)
            }

        }


    }

    private fun retreiveJson(query : String, country : String, apiKey : String){

        swipeRefreshLayout.isRefreshing = true
        val call: Call<Headline> = if(etQuery.text.toString() != ""){
            ApiClient.getInstance().api.getSpecificData(query, apiKey)
        }else{
            ApiClient.getInstance().api.getHeadlines(country, apiKey)
        }
        call.enqueue(object : Callback<Headline>{
            override fun onFailure(call: Call<Headline>, t: Throwable) {
                swipeRefreshLayout.isRefreshing = false
                Toast.makeText(baseContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Headline>, response: Response<Headline>) {
                if(response.isSuccessful && response.body()?.articles != null){
                    swipeRefreshLayout.isRefreshing = false
                    article.clear()
                    article = response.body()?.articles as ArrayList<Article>

//                    val headline = Headline(article,"",0)
                    /**/
//                    db.headlineDao().insertHeadline(article)

                    val adapter = Adapter(article)
                    rvView.adapter = adapter
                }
            }
        })
    }

    private fun getCountry(): String? {
        val locale = Locale.getDefault()
        val country = locale.country
        return country.toLowerCase()
    }


}










