package com.science.mylogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.science.myloggerlibrary.MyLogger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyLogger.e("Application Start!");

        test();
    }

    private void test() {
        MyLogger.IS_DEBUG = false; // cancel the log
        MyLogger.e("test method!");
    }
}
