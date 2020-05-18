package com.example.roomdb

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton2.setOnClickListener {
            showCustomAlert()
        }

    }

    fun showSimpleAlert(){

        val simpleAlertDialog = AlertDialog.Builder(this)
            .setTitle("Hi I'am a simple alert")
            .setMessage("Nice to meet you...")
            .setPositiveButton("Ok"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setNegativeButton("Close"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)
            .create()

        simpleAlertDialog.show()
        
    }

    private val itemArray = arrayOf("item1","item2","item3","item4")
    private val checkedArray = booleanArrayOf(false,false,false,false)

    fun showMultipleChoice(){
        val multiChoiceAlert = AlertDialog.Builder(this)
            .setMultiChoiceItems(itemArray
            , checkedArray
            ) { dialog, which, isChecked ->
                //You can see which item is been selected
                Toast.makeText(this,itemArray[which],Toast.LENGTH_SHORT).show()
            }
            .setTitle("Multi Select Dialog")
//            .setMessage("Hi!") //It will overide the itemArray
            .setPositiveButton("Ok"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setNegativeButton("Close"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)
            .create()

        multiChoiceAlert.show()
    }

    private fun showSingleChoiceAlert(){
        val singleChoiceAlert = AlertDialog.Builder(this)
            .setSingleChoiceItems(itemArray,0
            ) { dialog, which ->
                Toast.makeText(this,itemArray[which],Toast.LENGTH_SHORT).show()
            }
            .setTitle("Multi Select Dialog")

            .setPositiveButton("Ok"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setNegativeButton("Close"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)
            .create()

        singleChoiceAlert.show()

    }

    fun showCustomAlert(){

        val dialogView = layoutInflater.inflate(R.layout.view_dialog,null,false)

        val customAlertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from the Custom Alert")
            .setPositiveButton("Ok"
            ) { dialog, _ ->
                dialog.cancel()

                Toast.makeText(this,"Title : ${dialogView.etTitle.text} ," +
                        " Subtitle : ${dialogView.etSubTitle.text}"
                    , Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Close"
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setView(dialogView)
            .create()

        customAlertDialog.show()

    }
}
