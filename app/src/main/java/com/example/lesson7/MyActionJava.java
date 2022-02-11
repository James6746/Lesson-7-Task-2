package com.example.lesson7;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.material.textfield.TextInputEditText;

public class MyActionJava {

    public static void myAction(Context context, EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(context, editable.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                Toast.makeText(context, String.valueOf(keyEvent.getAction()), Toast.LENGTH_SHORT).show();
                return true;
            }


        });


    }

    public static void Task4(Context context, TextInputEditText textInputEditText) {

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(context, editable, Toast.LENGTH_SHORT).show();
            }
        });

        textInputEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                Toast.makeText(context, String.valueOf(keyEvent.getAction()), Toast.LENGTH_SHORT).show();
                return true;
            }


        });

    }

    public static void Task5(Context context, TextView textView) {
        String str = "I would #like to do #something similar to the #Twitter app";

        SpannableString text = new SpannableString(str);
        int start = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (i != str.length() - 1 && str.charAt(i + 1) == ' ') {
                    continue;
                }
                start = i;
            } else if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || (i == str.length() - 1 && start != -1)) {
                if (start != -1) {
                    if (i == str.length() - 1) {
                        i++;
                    }

                    final String tag = str.substring(start, i);
                    text.setSpan(new ClickableSpan() {
                        @Override
                        public void onClick(View widget) {
                            Toast.makeText(context, tag, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void updateDrawState(TextPaint ds) {
                            ds.setColor(Color.parseColor("#33b5e5"));
                            ds.setUnderlineText(false);
                        }
                    }, start, i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    start = -1;
                }
            }
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(text);
    }

    public static void Task6(Context context, TextView textView) {
        String str = "I would like to do something similar to the https://twitter.com app and https://telegram.org, got that?";
        SpannableString ss = new SpannableString(str);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String[] arr = str.split("\\,| ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("https://") && arr[i].contains(".")) {
                int finalI = i;
                ss.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, arr[finalI], Toast.LENGTH_SHORT).show();
                    }

                    @RequiresApi(api = Build.VERSION_CODES.Q)
                    @Override
                    public void updateDrawState(@NonNull TextPaint ds) {
                        ds.setColor(Color.BLUE);
                        ds.setUnderlineText(true);
                    }
                }, str.lastIndexOf(arr[i]), str.lastIndexOf(arr[i]) + arr[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        textView.setText(ss);
    }
}

