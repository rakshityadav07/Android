package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    val gson = Gson()
    val API_KEY = "984501863f994d0b9e62c20e49a8ffc7"
    val category = "business"
    var article = ArrayList<Article>()
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipeRefreshLayout = findViewById(R.id.swipeRefresh)

        rvView.layoutManager = LinearLayoutManager(this)
        val country = getCountry() ?: "In"

        swipeRefreshLayout.setOnRefreshListener {
            retreiveJson(country, API_KEY)
        }

        retreiveJson(country,API_KEY)
    }



    fun retreiveJson(country : String,apiKey : String){

        swipeRefreshLayout.isRefreshing = true;
        var call: Call<Headline> = ApiClient.getInstance().api.getHeadlines(country, apiKey)
            call.enqueue(object : Callback<Headline>{
                override fun onFailure(call: Call<Headline>, t: Throwable) {
                    swipeRefreshLayout.isRefreshing = false;
                    Toast.makeText(baseContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Headline>, response: Response<Headline>) {
                    if(response.isSuccessful && response.body()?.articles != null){
                        swipeRefreshLayout.isRefreshing = false;
                        article.clear()
                        article = response.body()?.articles as ArrayList<Article>
                        val adapter = Adapter(article)
                        rvView.adapter = adapter
                    }
                }
            })
    }

    fun getCountry(): String? {
        val locale = Locale.getDefault()
        val country = locale.country
        return country.toLowerCase()
    }


}











