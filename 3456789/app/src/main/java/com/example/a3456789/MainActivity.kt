package com.example.a3456789

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }
        button.setOnClickListener {
            editTextNumber.hideKeyboard()
            editTextNumber2.hideKeyboard()
            try {
                if (editTextNumber.text.toString().toInt() > editTextNumber2.text.toString().toInt()) {
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, "Перове число должно быть больше второго", duration)
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show()
                } else {
                    val rnds =
                        (editTextNumber.text.toString().toInt()..editTextNumber2.text.toString().toInt()).random()
                    textView.text = rnds.toString()
                }
            } catch (e: Exception) {
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, "Введите оба числа", duration)
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show()
            }
        }

    }

}