package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnC = findViewById<Button>(R.id.btn_clearid).setOnClickListener(this)
        val btndot = findViewById<Button>(R.id.btn_dotid).setOnClickListener(this)
        val btnallclr = findViewById<Button>(R.id.btn_acid).setOnClickListener(this)
        val btnopenparen = findViewById<Button>(R.id.btn_openparenid).setOnClickListener(this)
        val btncloseparen = findViewById<Button>(R.id.btn_closeparenid).setOnClickListener(this)
        val btndiv = findViewById<Button>(R.id.btn_divid).setOnClickListener(this)
        val btnadd = findViewById<Button>(R.id.btn_addid).setOnClickListener(this)
        val btnsub = findViewById<Button>(R.id.btn_subid).setOnClickListener(this)
        val btnmul = findViewById<Button>(R.id.btn_mulid).setOnClickListener(this)
        val btnequ = findViewById<Button>(R.id.btn_equalid).setOnClickListener(this)

        val btn1 = findViewById<Button>(R.id.btn_1id).setOnClickListener(this)
        val btn2 = findViewById<Button>(R.id.btn_2id).setOnClickListener(this)
        val btn3 = findViewById<Button>(R.id.btn_3id).setOnClickListener(this)
        val btn4 = findViewById<Button>(R.id.btn_4id).setOnClickListener(this)
        val btn5 = findViewById<Button>(R.id.btn_5id).setOnClickListener(this)
        val btn6 = findViewById<Button>(R.id.btn_6id).setOnClickListener(this)
        val btn7 = findViewById<Button>(R.id.btn_7id).setOnClickListener(this)
        val btn8 = findViewById<Button>(R.id.btn_8id).setOnClickListener(this)
        val btn9 = findViewById<Button>(R.id.btn_9id).setOnClickListener(this)
        val btn0 = findViewById<Button>(R.id.btn_0id).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val equationView = findViewById<TextView>(R.id.equationTextId)
        val resultView = findViewById<TextView>(R.id.resultTextId)
        fun calculatedResult(data:String){
            return try {
                var result = ExpressionBuilder(data).build().evaluate()
                resultView.text=result.toString()
            } catch(e:Exception){
                Toast.makeText(this,"Error Occurred", Toast.LENGTH_SHORT).show()
            }
        }
        if (v is Button) {
            var buttonText = v.text.toString()
            var data2calc = equationView.text.toString()
            if(buttonText=="D"){
                equationView.text=""
                resultView.text="0"
                return
            }
            if(buttonText=="="){
//                resultView.text = equationView.text
                calculatedResult(equationView.text.toString())

            }
            if(buttonText=="C"){
//                if(equationView.text.length<=1 || equationView.text=="0")
//                    equationView.text=""
//                else
//                    equationView.text = data2calc.substring(0,data2calc.length-1)
                equationView.text = if (data2calc.length <= 1) "" else data2calc.dropLast(1)
            }
//
            else{
                if(buttonText=="×") {
                    buttonText="*"
                }
                data2calc+=buttonText
                equationView.text = data2calc
            }
        }
    }
}

