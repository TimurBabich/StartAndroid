package com.example.tbabich.p015;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textColor, textSize;
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Find TextView");
        textColor = (TextView) findViewById(R.id.textColor);
        textSize = (TextView) findViewById(R.id.textSize);

        registerForContextMenu(textColor);
        registerForContextMenu(textSize);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.textColor:
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.text_color, menu);
                break;
            case R.id.textSize:
                menu.add(0, 4, 0, "22");
                menu.add(0, 5, 0, "26");
                menu.add(0, 6, 0, "30");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.red: textColor.setTextColor(Color.RED);
            break;
            case R.id.green: textColor.setTextColor(Color.GREEN);
            break;
            case R.id.blue: textColor.setTextColor(Color.BLUE);
            break;
            case 4: textSize.setTextSize(22);
            break;
            case 5: textSize.setTextSize(26);
            break;
            case 6: textSize.setTextSize(30);
            break;

        }
        return super.onContextItemSelected(item);
    }
}
