package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.ocpsoft.prettytime.PrettyTime
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    val gson = Gson()
    val API_KEY = "984501863f994d0b9e62c20e49a8ffc7"
    val category = "business"
    var article = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvView.layoutManager = LinearLayoutManager(this)
        val country = getCountry()
        if (country != null) {
            retreiveJson(country,API_KEY)
        }
    }

    fun retreiveJson(country : String,apiKey : String){

        var call: Call<Headline> = ApiClient.getInstance().api.getHeadlines(country, apiKey)
            call.enqueue(object : Callback<Headline>{
                override fun onFailure(call: Call<Headline>, t: Throwable) {
                    Toast.makeText(baseContext, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Headline>, response: Response<Headline>) {
                    if(response.isSuccessful && response.body()?.articles != null){
                        article.clear()
                        article = response.body()?.articles as ArrayList<Article>
                        val adapter = Adapter(article)
                        rvView.setAdapter(adapter)
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
