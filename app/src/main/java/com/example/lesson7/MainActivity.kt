package com.example.lesson7

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import io.github.armcha.autolink.AutoLinkTextView

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var textInputEditText: TextInputEditText
    lateinit var tv_task5: TextView
    lateinit var tv_task6: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editText = findViewById(R.id.et_mine)
        textInputEditText = findViewById(R.id.name)
        tv_task5 = findViewById(R.id.tv_task5)
        tv_task6 = findViewById(R.id.tv_task6)


        MyActionJava.myAction(this, editText)  // Task3

        //MyActionKotlin.myAction(this, editText)  // Kotlin uchun

        MyActionJava.Task4(this, textInputEditText); // Task4

//        MyActionKotlin.Task4(this, textInputEditText); // Kotlin uchun

        MyActionJava.Task5(this, tv_task5)

//        MyActionKotlin.Task5(this, tv_task5); // Kotlin uchun

//        MyActionJava.Task6(this, tv_task6)



        MyActionKotlin.Task6(this, tv_task6)


    }

}