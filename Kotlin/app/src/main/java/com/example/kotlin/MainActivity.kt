package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // can be reassigned
    var count : Int = 0
    // can't be reassigned
    val valCount : Int = 0

    lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdapter = NoteAdapter()

        count++
        count--

        
        tvText1.setOnClickListener{
            tvText2.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
        }

//        valCount++
    }

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }

    fun countSquare() : Int{
        return count*count
    }
    /*OR*/
    fun singleLineFunCountSquare() = count*count


    fun showToast(number : Int){
        showShortToast(this,"Short Toast")
        showLongToast(this,"Long Toast")
        Toast.makeText(this,"the number is $number" , Toast.LENGTH_SHORT).show()
    }

    fun printEvenOrOdd(number: Int){

        val isEven = if (number % 2 == 0) true else false

        Toast.makeText(this,
                "$number is : ${ if (number % 2 == 0 ) "even" else "odd" }"
                ,Toast.LENGTH_SHORT).show()

    }


}
