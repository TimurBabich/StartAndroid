package com.example.tbabich.p0301_onactivityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class TextAlignmentActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRight, btnCenter, btnLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_alignment);

        btnRight = (Button) findViewById(R.id.btnRight);
        btnCenter = (Button) findViewById(R.id.btnCenter);
        btnLeft = (Button) findViewById(R.id.btnLeft);

        btnRight.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btnRight:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
            case R.id.btnCenter:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.btnLeft:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
        }

        setResult(RESULT_OK, intent);
        finish();

    }
}
