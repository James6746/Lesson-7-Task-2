package com.example.lesson7

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var textInputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editText = findViewById(R.id.et_mine)
        textInputEditText = findViewById(R.id.name)

        MyActionJava.myAction(this, editText)  // Task3

        //MyActionKotlin.myAction(this, editText)  // Kotlin uchun

        MyActionJava.Task4(this, textInputEditText); // Task4

//        MyActionKotlin.Task4(this, textInputEditText); // Kotlin uchun



    }


}