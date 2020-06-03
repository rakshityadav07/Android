package com.example.newsapp.ui.Activity

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detailed.*


class NewsDetailed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val i = intent
        val title = i.getStringExtra("title")
        val name = i.getStringExtra("source")
        val time = i.getStringExtra("time")
        val desc = i.getStringExtra("desc")
        val imageUrl = i.getStringExtra("imageUrl")
        val url = i.getStringExtra("url")

        tvDate.text = time
        tvSource.text = name
        tvDescription.text = desc
        tvTitle.text = title

        Picasso.get().load(imageUrl).into(imageView)

        webProgressBar.visibility = View.VISIBLE

        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        /*This tells the WebviewClient that you've overloaded the URL loading
         (and in fact caused it to load the URL that you wish instead of the url supplied).*/
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
        if(webView.isShown){
            webProgressBar.visibility = View.INVISIBLE
        }

    }

}
