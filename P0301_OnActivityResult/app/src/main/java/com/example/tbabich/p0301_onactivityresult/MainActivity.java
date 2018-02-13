package com.example.tbabich.p0301_onactivityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_CODE_COLOR = 1;
    private final int REQUEST_CODE_ALIGNMENT = 2;

    TextView tvText;
    Button btnTextColor, btnTextAlignment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvText);
        btnTextColor = (Button) findViewById(R.id.btnTextColor);
        btnTextAlignment = (Button) findViewById(R.id.btnTextAlignment);

        btnTextColor.setOnClickListener(this);
        btnTextAlignment.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    tvText.setTextColor(data.getIntExtra("color", Color.WHITE));
                    break;
                case REQUEST_CODE_ALIGNMENT:
                    tvText.setGravity(data.getIntExtra("alignment", Gravity.CENTER));
            }
        } else {
            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.btnTextColor:
                intent = new Intent(this, TextColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnTextAlignment:
                intent = new Intent(this, TextAlignmentActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGNMENT);
                break;
        }
    }
}
