package com.cwt.bmi

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

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
        //Toast.makeText(this, bmi.toString(), Toast.LENGTH_SHORT).show()

        hideKeyboard()

        showAlertBMI(bmi)
    }

    private fun showAlertBMI(bmi: Float) {

        AlertDialog.Builder(this)
            .setMessage("Your BMI is ${bmi}")
            .setTitle("BMI")
            .setPositiveButton("OK", null)
            .setNeutralButton("Cancel", null)
            .show()
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}