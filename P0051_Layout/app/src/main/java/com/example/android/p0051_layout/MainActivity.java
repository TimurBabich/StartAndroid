package com.example.android.p0051_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button1, button2;
    CheckBox checkBox, checkBox2;
    Menu myMenu;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Найдены View");
        textView = (TextView) findViewById(R.id.textview1);
        button1 = (Button) findViewById(R.id.button3);
        button2 = (Button) findViewById(R.id.button4);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(MainActivity.this, "Нажата 1", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                LinearLayout linearLayout = (LinearLayout) toast.getView();
//                ImageView imageView = new ImageView(MainActivity.this);
//                imageView.setImageResource(R.drawable.ic_launcher_background);
//                linearLayout.addView(imageView);
//                toast.show();
//                Log.i(TAG, "Нажата 1");
//                textView.setText("Press 1");

            }
        };

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onPrepareOptionsMenu(myMenu);
            }
        };

        checkBox.setOnCheckedChangeListener(checkedChangeListener);
        checkBox2.setOnCheckedChangeListener(checkedChangeListener);

        button1.setOnClickListener(onClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        myMenu = menu;
        getMenuInflater().inflate(R.menu.mymenu, menu);
        menu.add(R.id.group2, 4, 4, "Прочитать").setCheckable(true);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        MenuItem menuItem = menu.findItem(R.id.edit);
//        if (checkBox2.isChecked())
//            menuItem.setVisible(false);
//        else
//            menuItem.setVisible(true);

        menu.setGroupVisible(R.id.group1, !checkBox.isChecked());
        menu.setGroupVisible(R.id.group2, !checkBox2.isChecked());

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.add : Toast.makeText(MainActivity.this, "Добавить", Toast.LENGTH_SHORT).show();
            break;
            case R.id.delete: Toast.makeText(MainActivity.this, "Удалить", Toast.LENGTH_SHORT).show();
            break;
            case 4: item.setChecked(!item.isChecked());
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickButton2(View view) {

        Log.d(TAG, "Нажата 2");
        try {
            int i = 6/0;
            textView.setText(i);
        } catch (Exception e) {
            Log.e(TAG, "Делить на 0 нельзя", e);
        }
    }


}
