package com.example.tbabich.p0361_sqlitequery;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "MyLogs";

    String name[] = {"Беларусь", "Россия", "США", "Мексика", "Япония", "ЮАР", "Австралия"};
    int popul[] = {10, 20, 30, 40, 50, 60, 70};
    String region[] = {"Европа", "Европа", "Северная Америка", "Южная Америка", "Азия", "Африка", "Австралия"};

    Button btnAll, btnFunc, btnPopul, btnPopulReg, btnPopulReg2, btnSort;
    EditText etFunc, etPopulReg2, etPopul;
    RadioButton rbName, rbPopul, rbReg;
    RadioGroup rgSort;

    DBHelper dbHelper;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAll = (Button) findViewById(R.id.btnAll);
        btnFunc = (Button) findViewById(R.id.btnFunc);
        btnPopul = (Button) findViewById(R.id.btnPopul);
        btnPopulReg = (Button) findViewById(R.id.btnPopulReg);
        btnPopulReg2 = (Button) findViewById(R.id.btnPopulReg2);
        btnSort = (Button) findViewById(R.id.btnSort);

        etFunc = (EditText) findViewById(R.id.etFunc);
        etPopul = (EditText) findViewById(R.id.etPopul);
        etPopulReg2 = (EditText) findViewById(R.id.etPopulReg2);

        rbName = (RadioButton) findViewById(R.id.rbName);
        rbPopul = (RadioButton) findViewById(R.id.rbPopul);
        rbReg = (RadioButton) findViewById(R.id.rbReg);

        rgSort = (RadioGroup) findViewById(R.id.rgSort);

        btnAll.setOnClickListener(this);
        btnSort.setOnClickListener(this);
        btnPopulReg2.setOnClickListener(this);
        btnPopulReg.setOnClickListener(this);
        btnPopul.setOnClickListener(this);
        btnFunc.setOnClickListener(this);

        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();

        Cursor c = database.query(DBHelper.TABLE_COUNTRY, null, null, null, null, null, null);
        database.delete(DBHelper.TABLE_COUNTRY, null, null);
        if (c.getCount() == 0) {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < 7; i++) {
                contentValues.put(DBHelper.KEY_NAME, name[i]);
                contentValues.put(DBHelper.KEY_POPUL, popul[i]);
                contentValues.put(DBHelper.KEY_REGION, region[i]);
                Log.d(LOG_TAG, "id = " + database.insert(DBHelper.TABLE_COUNTRY, null, contentValues));
            }
        }
        c.close();
        dbHelper.close();
        onClick(btnAll);
    }

    @Override
    public void onClick(View v) {

        database = dbHelper.getWritableDatabase();

        String sFunc = etFunc.getText().toString();
        String sPopul = etPopul.getText().toString();
        String sPopulReg = etPopulReg2.getText().toString();

        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor c = null;

        switch (v.getId()) {
            case R.id.btnAll:
                Log.d(LOG_TAG, "---All---");
                c = database.query(DBHelper.TABLE_COUNTRY, null, null, null, null, null, null);
                break;
            case R.id.btnFunc:
                Log.d(LOG_TAG, "---Function " + sFunc + "---");
                columns = new String[]{sFunc};
                c = database.query(DBHelper.TABLE_COUNTRY, columns, null,null,null,null,null);
                break;
            case R.id.btnPopul:
                Log.d(LOG_TAG, "---Popul> " + sPopul + "---");
                selection = "popul > ?";
                selectionArgs = new String[] { sPopul };
                c = database.query(DBHelper.TABLE_COUNTRY, null, selection, selectionArgs, null, null, null, null);
                break;
            case R.id.btnPopulReg:

                break;
            case R.id.btnPopulReg2:
                break;
            case R.id.btnSort:
                break;
        }

        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = " + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(LOG_TAG, str);
                } while (c.moveToNext());
            }
            c.close();
        } else
            Log.d(LOG_TAG, "Cursor is null");
        dbHelper.close();
    }
}
