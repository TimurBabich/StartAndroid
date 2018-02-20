package com.example.tbabich.p0331_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    SharedPreferences sharedPreferences;

    private final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoad = (Button) findViewById(R.id.btnLoad);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        editText = (EditText) findViewById(R.id.editText);

        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoad:
                loadText();
                break;
            case R.id.btnSave:
                saveText();
                break;
            default:
                break;
        }
    }

    private void saveText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putString(SAVED_TEXT, editText.getText().toString());
        editor.commit();
        Toast.makeText(MainActivity.this, "Text saved", Toast.LENGTH_SHORT).show();

    }

    private void loadText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editText.setText(sharedPreferences.getString(SAVED_TEXT, ""));
        Toast.makeText(MainActivity.this, "Text loaded", Toast.LENGTH_SHORT).show();

    }
}
