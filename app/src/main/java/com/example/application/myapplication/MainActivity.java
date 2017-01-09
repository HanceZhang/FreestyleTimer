package com.example.application.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextClock;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout myLayout = new RelativeLayout(this);
        Button myButton = new Button(this);
        Button testButton = new Button(this);
        TextView welcome = new TextView(this);
        TextClock textClk = new TextClock(this);
        final Chronometer chrono = new Chronometer(this);
        Button startButton = new Button (this);
        Button stopButton = new Button (this);
        final TextView mTextField = new TextView(this);

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();

        myButton.setId(1);
        welcome.setId(2);
        textClk.setId(3);
        chrono.setId(4);
        startButton.setId(5);
        stopButton.setId(6);
        testButton.setId(7);

        myButton.setText("LAUNCH");
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(myIntent);
            }
        });

        welcome.setText("Welcome");
        RelativeLayout.LayoutParams welcomeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        welcomeParams.addRule(RelativeLayout.ABOVE, 1);
        welcomeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        welcomeParams.setMargins(0, 0, 0, 100);

        RelativeLayout.LayoutParams clkParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        clkParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        clkParams.addRule(RelativeLayout.ABOVE, 2);
        clkParams.setMargins(0, 0, 0, 100);

        RelativeLayout.LayoutParams chronoParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        chronoParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        chronoParams.addRule(RelativeLayout.BELOW, 1 );
        chronoParams.setMargins(300, 0, 0, 0);

        startButton.setText("START");
        RelativeLayout.LayoutParams startButtonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        startButtonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        startButtonParams.addRule(RelativeLayout.BELOW, 4);
        startButtonParams.setMargins(100, 0, 0, 0);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
            }
        });

        stopButton.setText("STOP");
        RelativeLayout.LayoutParams stopButtonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        stopButtonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        stopButtonParams.addRule(RelativeLayout.BELOW, 5);
        stopButtonParams.setMargins(100, 0, 0, 0);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
            }
        });

        RelativeLayout.LayoutParams mTextFieldParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        mTextFieldParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        mTextFieldParams.addRule(RelativeLayout.BELOW, 6);
        mTextFieldParams.setMargins(200, 0, 0, 0);

        testButton.setText("TEST ACTIVITY");
        RelativeLayout.LayoutParams testParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        testParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        testParams.addRule(RelativeLayout.BELOW, 6);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, TestingActivity.class);
                startActivity(myIntent);
            }
        });

        myLayout.addView(textClk, clkParams);
        myLayout.addView(welcome, welcomeParams);
        myLayout.addView(myButton, buttonParams);
        myLayout.addView(chrono,chronoParams);
        myLayout.addView(startButton,startButtonParams);
        myLayout.addView(stopButton,stopButtonParams);
        myLayout.addView(mTextField,mTextFieldParams);
        myLayout.addView(testButton, testParams);
        setContentView(myLayout);
    }
}
