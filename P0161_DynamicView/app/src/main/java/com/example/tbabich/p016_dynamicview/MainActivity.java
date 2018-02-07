package com.example.tbabich.p016_dynamicview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        setContentView(linearLayout, layoutParams);

        ViewGroup.LayoutParams lpView = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(this);
        textView.setText("Hello!");
        textView.setLayoutParams(lpView);
        linearLayout.addView(textView);

        Button button1 = new Button(this);
        button1.setText("Button");
        linearLayout.addView(button1, lpView);

        LinearLayout.LayoutParams layoutParamsMarginL = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsMarginL.leftMargin = 50;

        Button button2 = new Button(this);
        button2.setText("Button2");
        linearLayout.addView(button2, layoutParamsMarginL);

        LinearLayout.LayoutParams layoutParamsGravity = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsGravity.gravity = Gravity.CENTER_HORIZONTAL;

        Button button3 = new Button(this);
        button3.setText("Button3");
        linearLayout.addView(button3, layoutParamsGravity);
    }
}
