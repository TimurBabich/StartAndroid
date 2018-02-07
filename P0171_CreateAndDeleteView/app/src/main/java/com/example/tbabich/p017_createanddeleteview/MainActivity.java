package com.example.tbabich.p017_createanddeleteview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llMain;
    private Button bAdd, bClear, bInfo;
    private RadioGroup rgGravity;
    private EditText bName;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Find Views");
        llMain = (LinearLayout) findViewById(R.id.llMain);
        bAdd = (Button) findViewById(R.id.bAdd);
        bClear = (Button) findViewById(R.id.bClear);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        bName = (EditText) findViewById(R.id.bName);
        bInfo = (Button) findViewById(R.id.bInfo);

        Log.i(TAG, "Set buttons listener");
        bAdd.setOnClickListener(this);
        bClear.setOnClickListener(this);
        bInfo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bAdd:
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int bGravity = Gravity.LEFT;

                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.radioLeft:
                        bGravity = Gravity.LEFT;
                        break;
                    case R.id.radioCenter:
                        bGravity = Gravity.CENTER;
                        break;
                    case R.id.radioRight:
                        bGravity = Gravity.RIGHT;
                        break;
                }

                layoutParams.gravity = bGravity;

                Button bNew = new Button(this);
                bNew.setText(bName.getText());
                llMain.addView(bNew, layoutParams);

                break;

            case R.id.bClear:
                llMain.removeAllViews();
                Toast.makeText(MainActivity.this, "Remove all viewes", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bInfo:
//                Toast.makeText(MainActivity.this, String.valueOf(llMain.getChildCount()), Toast.LENGTH_SHORT).show();
                int countChild = llMain.getChildCount();
                try {
                    Button view1 = (Button) llMain.getChildAt(countChild - 1);
                    view1.setText("!!!");
                    break;
                }
                catch (Exception e){
                    Log.e(TAG, "No find View");
                }
        }
    }
}
