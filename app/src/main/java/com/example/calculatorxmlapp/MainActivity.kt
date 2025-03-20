package com.example.calculatorxmlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private var numberButtons= mutableListOf<Button>()
    private var numbers= mutableListOf<Int>()
    private var tvInput:TextView?=null;
    private var clrBtn:Button?=null;
    private var lastNumeric:Boolean=false;
    private var hasDot:Boolean=false;
    private var dotButton:Button?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput= findViewById(R.id.result);
        clrBtn = findViewById(R.id.buttonCLR);
        dotButton = findViewById(R.id.buttonDot);
        clrBtn?.setOnClickListener { onClear() }
        dotButton?.setOnClickListener { onDecimalPoint() }
        for(i in 0..9) {

            val btn: Button = (findViewById(resources.getIdentifier("button$i", "id", packageName)));
            numberButtons.add(btn);
            btn.setOnClickListener { onDigit(btn) }
        }

    }
    fun onClear()
    {
        tvInput?.text="";
        lastNumeric=false;
    }

     fun onDecimalPoint() {
         if(lastNumeric&& !hasDot)
         {
             tvInput?.append(".")
             hasDot=true;
             lastNumeric=false;
         }

     }
      fun onDigit(view:View) {

          val btn: Button = view as Button;
          lastNumeric=true;
          //Toast.makeText(this, btn.text, Toast.LENGTH_LONG).show();
          tvInput?.append(btn.text);
      }
}