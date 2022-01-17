package com.cwt.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edWeight: EditText
    lateinit var edHeight: EditText
    lateinit var bHelp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
    }

    private fun findViews() {
        edWeight = findViewById(R.id.ed_weight)
        edHeight = findViewById(R.id.ed_height)
        bHelp = findViewById(R.id.b_help)
    }

    fun bmi(view: View) {
        val weight = edWeight.text.toString().toFloat()
        val height = edHeight.text.toString().toFloat()
        val bmi = weight / (height * height)

        Log.d("MainActivity", "BMI: ${bmi}")
        Toast.makeText(this, bmi.toString(), Toast.LENGTH_SHORT).show()
    }
}