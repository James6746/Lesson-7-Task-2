package com.example.lesson7

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.textfield.TextInputEditText
import org.intellij.lang.annotations.RegExp

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

        fun Task4(context: Context?, textInputEditText: TextInputEditText) {
            textInputEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
                override fun afterTextChanged(editable: Editable) {
                    Toast.makeText(context, editable, Toast.LENGTH_SHORT).show()
                }
            })
            textInputEditText.setOnKeyListener { view, keyCode, keyEvent ->
                Toast.makeText(context, keyEvent.action.toString(), Toast.LENGTH_SHORT).show()
                true
            }
        }

        fun Task5(context: Context?, textView: TextView) {
            val str = "I would #like to do #something similar to the #Twitter app"
            val text = SpannableString(str)
            var start = -1
            var i = 0
            while (i < str.length) {
                if (str[i] == '#') {
                    if (i != str.length - 1 && str[i + 1] == ' ') {
                        i++
                        continue
                    }
                    start = i
                } else if (str[i] == ' ' || str[i] == '\n' || i == str.length - 1 && start != -1) {
                    if (start != -1) {
                        if (i == str.length - 1) {
                            i++
                        }
                        val tag = str.substring(start, i)
                        text.setSpan(object : ClickableSpan() {
                            override fun onClick(widget: View) {
                                Toast.makeText(context, tag, Toast.LENGTH_SHORT).show()
                            }

                            override fun updateDrawState(ds: TextPaint) {
                                ds.color = Color.parseColor("#33b5e5")
                                ds.isUnderlineText = false
                            }
                        }, start, i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        start = -1
                    }
                }
                textView.movementMethod = LinkMovementMethod.getInstance()
                textView.text = text
                i++
            }
        }

        fun Task6(context: Context?, textView: TextView) {
            val str =
                "I would like to do something similar to the https://twitter.com app and https://telegram.org, got that?"
            val ss = SpannableString(str)
            textView.movementMethod = LinkMovementMethod.getInstance()

            val arr = str.split(" ", ",").toTypedArray()
            for (i in arr.indices) {
                if (arr[i].contains("https://") && arr[i].contains(".")) {
                    ss.setSpan(
                        object : ClickableSpan() {
                            override fun onClick(view: View) {
                                Toast.makeText(context, arr[i], Toast.LENGTH_SHORT).show()
                            }

                            @RequiresApi(api = Build.VERSION_CODES.Q)
                            override fun updateDrawState(ds: TextPaint) {
                                ds.color = Color.BLUE
                                ds.isUnderlineText = true
                            }
                        },
                        str.lastIndexOf(arr[i]),
                        str.lastIndexOf(arr[i]) + arr[i].length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
            textView.text = ss
        }
    }
}