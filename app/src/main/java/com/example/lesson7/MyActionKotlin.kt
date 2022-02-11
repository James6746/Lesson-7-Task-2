package com.example.lesson7

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast

class MyActionKotlin {
    companion object {
        fun myAction(context: Context?, editText: EditText) {

            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {

                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

                override fun afterTextChanged(editable: Editable) {

                    Toast.makeText(context, editable.toString(), Toast.LENGTH_SHORT).show()
                }
            })

            editText.setOnKeyListener { view, keyCode, keyEvent ->
                Toast.makeText(context, keyEvent.action.toString(), Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

}