package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {
        if(isNewOp){
            editShowNumber.setText("")
        }
        isNewOp=false
        val buSelect = view as Button
        var buClickValue: String = editShowNumber.text.toString()
        when (buSelect.id) {
            buZero.id -> buClickValue += "0"
            buOne.id -> buClickValue += "1"
            buTwo.id -> buClickValue += "2"
            buThree.id -> buClickValue += "3"
            buFour.id -> buClickValue += "4"
            buFive.id -> buClickValue += "5"
            buSix.id -> buClickValue += "6"
            buSeven.id -> buClickValue += "7"
            buEight.id -> buClickValue += "8"
            buNine.id -> buClickValue += "9"
            //TODO: Prevent adding more than one DOT
            buDot.id -> buClickValue += "."
            buPlusMinus.id -> buClickValue = "-$buClickValue"
        }
        editShowNumber.setText(buClickValue)
    }
    var op:String = "*"
    var oldNumber:String = ""
    var isNewOp=true
    fun buOpEvent(view:View){
        val buSelect = view as Button
        //var buClickValue: String = editShowNumber.text.toString()
        when (buSelect.id) {
            buDiv.id -> op = "/"
            buMul.id -> op = "*"
            buSub.id -> op = "-"
            buAdd.id -> op = "+"
        }
        oldNumber = editShowNumber.text.toString()
        isNewOp=true
        //val show:String = oldNumber + op
        //editShowNumber.setText(show)
    }

    fun buEqualEvent(view:View){
        val newNumber = editShowNumber.text.toString()
        var finalNumber:Double? = null
        when(op){
            "/"-> finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            "*"-> finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            "-"-> finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            "+"-> finalNumber = oldNumber.toDouble() + newNumber.toDouble()
        }
        editShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercent(view:View){
        val number:Double=editShowNumber.text.toString().toDouble()/100

        editShowNumber.setText(number.toString())
        isNewOp=true

    }

    fun buClean(view:View){
        editShowNumber.setText("0")
        isNewOp=true
    }
}
