package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
    }



    private lateinit var sendButton : Button
    private lateinit var sendView : TextView
    private lateinit var sendWeight : EditText
    private lateinit var sendHeight : EditText
    private lateinit var showStatus : TextView
    private var weight = 0
    private var  height = 0
    private var BMI = 0.0

    private fun bind() {
        sendButton = findViewById(R.id.result_button)
        sendView = findViewById(R.id.result_text_view)
        sendWeight = findViewById(R.id.weight_edit_text)
        sendHeight = findViewById(R.id.height_edit_text)
        showStatus = findViewById(R.id.status_text_view)

        sendButton.setOnClickListener{
            weight = Integer.parseInt(sendWeight.getText().toString())
            height = Integer.parseInt(sendHeight.getText().toString())

            BMI = weight.toDouble() / (height*height)
            println(BMI*10000)
            sendView.text = (BMI*10000).toString()

            if ((BMI*10000) < 18.5) {
                println("Hola")
                showStatus.text = "Underweight"
            showStatus.setTextColor(resources.getColor(R.color.under_weight))}

            else if ((BMI*10000) >= 18.5 && (BMI*10000) < 24.99){
                showStatus.text = "Healthy"
                showStatus.setTextColor(resources.getColor(R.color.normal_weight))}

            else if ((BMI*10000) >= 25 && (BMI*10000) < 29.99){
                showStatus.text = "Overweight"
                showStatus.setTextColor(resources.getColor(R.color.over_weight))}
            
            else if ((BMI*10000) >= 30){
                showStatus.text = "Obese"
                showStatus.setTextColor(resources.getColor(R.color.obese))}
        }


        }
    }

