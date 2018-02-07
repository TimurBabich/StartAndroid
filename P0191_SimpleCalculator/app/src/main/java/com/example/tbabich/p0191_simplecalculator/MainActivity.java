package com.example.tbabich.p0191_simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numberA, numberB;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide;
    private TextView textResult;
    private float a, b, result;
    private String oper = "";

    private static final String TAG = "myLogs";
    private static final int MENU_RESET_ID = 1;
    private static final int MENU_EXIT_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberA = (EditText) findViewById(R.id.numberA);
        numberB = (EditText) findViewById(R.id.numberB);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        textResult = (TextView) findViewById(R.id.textResult);

        btnPlus.setOnClickListener(onClickListener);
        btnMinus.setOnClickListener(onClickListener);
        btnMultiply.setOnClickListener(onClickListener);
        btnDivide.setOnClickListener(onClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_EXIT_ID, 0, "Exit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case MENU_RESET_ID:
                numberA.setText("");
                numberB.setText("");
                textResult.setText("");
                break;
            case MENU_EXIT_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try{
                a = Float.parseFloat(numberA.getText().toString());
                b = Float.parseFloat(numberB.getText().toString());
            }
            catch (Exception e){
                Toast.makeText(MainActivity.this, "Введите а и b", Toast.LENGTH_SHORT).show();
                return;
            }

            switch (view.getId()) {
                case R.id.btnPlus:
                    result = a + b;
                    oper = "+";
                    break;
                case R.id.btnMinus:
                    result = a - b;
                    oper = "-";
                    break;
                case R.id.btnMultiply:
                    result = a * b;
                    oper = "*";
                    break;
                case R.id.btnDivide:
                    result = a / b;
                    oper = "/";
                    break;
            }

            textResult.setText(String.format("%f %s %f = %.5f", a, oper, b, result));
        }
    };


}
