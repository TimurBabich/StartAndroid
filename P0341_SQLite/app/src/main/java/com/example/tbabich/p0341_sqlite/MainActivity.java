package com.example.tbabich.p0341_sqlite;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnRead, btnClear, btnUpdate, btnDelete;
    EditText etName, etEmail, etId;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etName = (EditText) findViewById(R.id.etName);
        etId = (EditText) findViewById(R.id.etId);

        btnAdd.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etId.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_EMAIL, email);
                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;
            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);

                    do {
                        Log.d("myLogs", cursor.getInt(idIndex) + ", " + cursor.getString(nameIndex) + ", " + cursor.getString(emailIndex));
                    }
                    while (cursor.moveToNext());
                }
                cursor.close();
                break;
            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
            case R.id.btnUpdate:
                if (id.equals(""))
                    break;
                contentValues.put(DBHelper.KEY_EMAIL, email);
                contentValues.put(DBHelper.KEY_NAME, name);
                int updCount = database.update(DBHelper.TABLE_CONTACTS, contentValues, DBHelper.KEY_ID + "= ?", new String[]{id});
                Log.d("myLogs", "updated rows count = " + updCount);
                break;
            case R.id.btnDelete:
                if (id.equals(""))
                    break;
                int delCount = database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_NAME + " = ?", new String[]{name});
                Log.d("myLogs", "deleted rows count = " + delCount);
                break;
        }
        dbHelper.close();
    }
}
