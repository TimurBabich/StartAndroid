package com.example.android.p0271_manyaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAndDateActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_date);

        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        SimpleDateFormat sdf;
        String result = "";

        switch (intent.getAction()){
            case "info.tbabich.intent.action.time":
                sdf = new SimpleDateFormat("HH:mm:ss");
                result = "Time: " + sdf.format(new Date(System.currentTimeMillis()));
                break;
            case "info.tbabich.intent.action.date":
                sdf = new SimpleDateFormat("dd.MM.yyyy");
                result = "Date: " + sdf.format(new Date(System.currentTimeMillis()));
                break;
        }

        textView.setText(result);

    }
}
