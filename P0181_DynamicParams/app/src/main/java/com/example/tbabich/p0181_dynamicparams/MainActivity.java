package com.example.tbabich.p0181_dynamicparams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar seekBar;
    Button button1, button2;
    LinearLayout.LayoutParams lParams1, lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        seekBar.setOnSeekBarChangeListener(this);

        lParams1 = (LinearLayout.LayoutParams) button1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) button2.getLayoutParams();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int leftValue = i;
        int rightValue = 100 - i;

        lParams1.weight = leftValue;
        lParams2.weight = rightValue;

        button1.setText(String.valueOf(leftValue));
        button2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
