package com.example.tbabich.p0291_returndataactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetNameActivity extends AppCompatActivity{

    EditText setName;
    Button btnSendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        Log.i("MyLogs", "onCreate GetNameActivity OK");

        setName = (EditText) findViewById(R.id.tvSetName);
        btnSendName = (Button) findViewById(R.id.btnSendName);

        Log.i("MyLogs", this.toString());

        btnSendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", setName.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Log.i("MyLogs", "btnSendName.setOnClickListener GetNameActivity OK");
    }

}
