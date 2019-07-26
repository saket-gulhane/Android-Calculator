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
    private int state=0;
    private String str="";

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
//        buttonAddSub = (Button) findViewById(R.id.buttonPlusMinus);



        //////////////////////////////////////////////////////////////
        //Buttons onClickListener() functions


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "0"); state=0;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "1"); state=0;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "2"); state=0;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "3"); state=0;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "4"); state=0;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "5"); state=0;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "6"); state=0;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "7"); state=0;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "8"); state=0;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textOut.setText(textOut.getText() + "9"); state=0;
            }
        });


        //clear all button
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
               str= textOut.getText().toString();
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
                str= textOut.getText().toString();
                if(state==1){
                    str = str.substring(0, str.length() - 1);
                }
                textOut.setText(str + "."); state=1;
            }
        });

        //multiplication button
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str= textOut.getText().toString();
                if(state==1){
                    str = str.substring(0, str.length() - 1);
                }
                textOut.setText(str + "*"); state=1;
            }
        });

        //division button
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str= textOut.getText().toString();
                if(state==1){
                    str = str.substring(0, str.length() - 1);
                }
                textOut.setText(str + "/"); state=1;
            }
        });

        //addition button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str= textOut.getText().toString();
                if(state==1){
                    str = str.substring(0, str.length() - 1);
                }
                textOut.setText(str + "+"); state=1;
            }
        });

        //subtraction button
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str= textOut.getText().toString();
                if(state==1){
                    str = str.substring(0, str.length() - 1);
                }
                textOut.setText(str + "-"); state=1;
            }
        });


        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        //Copy Text Button
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



//        b1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String text;
//                text = ed1.getText().toString();
//
//                myClip = ClipData.newPlainText("text", text);
//                myClipboard.setPrimaryClip(myClip);
//
//                Toast.makeText(getApplicationContext(), "Text Copied",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        //percentage button


        //change plus minus sign
//        buttonAddSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String addSub = textOut.getText().toString();
//
//                if(addSub.charAt(0) != '-') {
//                    textOut.setText("-" + textOut.getText());
//                }
//                else{
//                    String s = addSub.substring(2, addSub.length() - 1);
//                    textOut.setText(s);
//                }
//            }
//        });





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


