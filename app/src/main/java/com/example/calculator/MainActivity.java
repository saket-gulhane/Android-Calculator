package com.example.calculator;

import java.io.*;
import java.math.*;
import java.util.*;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttonDecimal, buttonC, buttonEqual, buttonBack, buttonAddSub, buttonPercent, buttonCopy;

    EditText textOut;

    private ClipboardManager myClipboard;


    //on start
    @Override
    protected void onStart() {
        super.onStart();
        Log.wtf("a", "onStart");
    }

    //onResume
    @Override
    protected void onResume() {
        super.onResume();
        Log.wtf("a", "onResume");
    }

    //onPause
    @Override
    protected void onPause() {
        super.onPause();
        Log.wtf("a", "onPause");
    }

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button link with id
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDecimal = (Button) findViewById(R.id.buttonDecimal);
        buttonAdd = (Button) findViewById(R.id.buttonPlus);
        buttonSub = (Button) findViewById(R.id.buttonMinus);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonDivision = (Button) findViewById(R.id.buttonDiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        textOut = (EditText) findViewById(R.id.textOut);
        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonCopy = (Button) findViewById(R.id.buttonCopyText);




        //////////////////////////////////////////////////////////////
        //Buttons onClickListener()


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "9");
            }
        });


        //'Clear All' button
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clear = "";
                textOut.setText(clear);
            }
        });


        //clear last char button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String str= textOut.getText().toString();
               if(str.isEmpty()) {
                   String clear = "";
                   textOut.setText(clear);
               }
               else{
                   str = str.substring(0, str.length() - 1);
                   textOut.setText(str);
               }

            }
        });


        //decimal button
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + ".");
            }
        });

        //multiplication button
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "*");
            }
        });

        //division button
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "/");
            }
        });

        //addition button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "+");
            }
        });

        //subtraction button
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "-");
            }
        });


        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        //'Copy Text' Button
        buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("cop", "onCopyText");

                ClipData myClip;
                String copy = textOut.getText().toString();
                myClip = ClipData.newPlainText("String", copy);
                myClipboard.setPrimaryClip(myClip);
            }
        });






        /////////////////////////////////////////////////////////////////
        //equals button for answer
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textOut.getText().toString();
                if(str.isEmpty()){
                    textOut.setText("No input Press C");
                }
                else{
                    //class obj to calculate expression value
                    ConsoleCalc wrt = new ConsoleCalc();
                    String fin = wrt.sak(str);
                    if(fin.equals("000000")){
                        String out = "Invalid expression";
                        textOut.setText(out);

                    }
                    else{
                        textOut.setText(fin);
                    }

                }
            }
        });
    }
}


