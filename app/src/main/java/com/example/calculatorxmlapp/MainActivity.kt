package com.example.calculatorxmlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    private var numberButtons= mutableListOf<Button>()
    private var numbers= mutableListOf<Int>()
    private var tvInput:TextView?=null;
    private var clrBtn:Button?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput= findViewById(R.id.result);
        clrBtn = findViewById(R.id.buttonCLR);
        clrBtn?.setOnClickListener { onClear() }
        for(i in 0..9) {

            val btn: Button = (findViewById(resources.getIdentifier("button$i", "id", packageName)));
            numberButtons.add(btn);
            btn.setOnClickListener { onDigit(btn) }
        }

    }
    fun onClear()
    {
        tvInput?.text="";
    }

     fun onText(view:View) {


    }
      fun onDigit(view:View) {

          val btn: Button = view as Button;
          //Toast.makeText(this, btn.text, Toast.LENGTH_LONG).show();
          tvInput?.append(btn.text);
      }
}