package com.example.calculatorxmlapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private var numberButtons= mutableListOf<Button>()
    private var operatorButtons= mutableListOf<Button>()
    private var numbers= mutableListOf<Int>()
    private var tvInput:TextView?=null;
    private var clrBtn:Button?=null;
    private var resultButton:Button?=null;
    private var lastNumeric:Boolean=false;
    private var hasDot:Boolean=false;
    private var dotButton:Button?=null;
    private val operations = arrayOf("Div","Mult","Add","Min");
    private val operators = arrayOf("/","+","-","*");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput= findViewById(R.id.result);
        clrBtn = findViewById(R.id.buttonCLR);
        dotButton = findViewById(R.id.buttonDot);
        resultButton = findViewById(R.id.buttonRES);
        clrBtn?.setOnClickListener { onClear() }
        dotButton?.setOnClickListener { onDecimalPoint() }
        resultButton?.setOnClickListener { onEqual(it) }
        for (i in operations)
        {
            val btn: Button = (findViewById(resources.getIdentifier("button$i", "id", packageName)));
            numberButtons.add(btn);
            btn.setOnClickListener { onOperator(btn) }
        }
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
    private fun onOperator(view:View) {
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text);
                lastNumeric=false;
                hasDot=false;
            }
        }

    }

    private fun isOperatorAdded(value:String):Boolean
    {
        return if(value.startsWith("-"))
        {
            false
        }
        else
        {
            val match = operators.filter{it in value  }
            return match.isNotEmpty()
        }
    }
    private fun onEqual(view:View) {
        if (lastNumeric) {
            var tvValue: String = tvInput?.text.toString();
            var prefix = ""
            try
            {
                if (tvValue.startsWith("-"))
                {
                    prefix = "-";
                    tvValue = tvValue.substring(1);
                }
                if (tvValue.contains("-"))
                {
                    var splitValue = mutableListOf("");
                    splitValue  = tvValue.split("-").toMutableList();
                    if(prefix.isNotEmpty())
                    {
                        splitValue[0]=prefix+splitValue[0];
                    }

                    tvInput?.text = (splitValue[0].toDouble() - splitValue[1].toDouble()).toString();
                }

            }
            catch (e: ArithmeticException)
            {
                e.printStackTrace();
            }
        }
    }
}