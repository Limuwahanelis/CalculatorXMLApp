package com.example.calculatorxmlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(),OnClickListener{
    private var numberButtons= mutableListOf<Button>()
    private var numbers= mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 1..9) {

            val btn: Button = (findViewById(resources.getIdentifier("button$i", "id", packageName)));
            numberButtons.add(btn);
            btn.setOnClickListener { onClick(btn) }
        }

    }

     override fun onClick(view:View) {

         val btn:Button = view as Button;
         Toast.makeText(this,btn.text,Toast.LENGTH_LONG).show();

    }
}