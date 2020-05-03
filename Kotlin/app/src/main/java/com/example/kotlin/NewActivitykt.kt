package com.example.kotlin

import android.content.Context
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class NewActivitykt : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_kt)

//        nullable so we put ? or !!
        savedInstanceState?.putFloat("Key",1F)

        val color = getColor(R.color.colorAccent)

        getMyColor(this,R.color.colorAccent);
    }

}


fun getMyColor(context: Context,@ColorRes color : Int): Int {

//    val color = ContextCompat.getColor(context,R.color.colorAccent)

    val returnedColor : Int

    context?.let {ctx ->
        returnedColor = ContextCompat.getColor(ctx,R.color.colorAccent)
    }

    return color
}
