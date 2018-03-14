package com.example.tbabich.p0361_sqlitequery;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by t.babich on 14.03.2018.
 */

class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_COUNTRY = "country";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_POPUL = "popul";
    public static final String KEY_REGION = "region";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_COUNTRY + "(" + KEY_ID + " integer primary key, " + KEY_NAME + " text, " + KEY_POPUL + " text, "  + KEY_REGION + " text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_COUNTRY);
        onCreate(db);
    }
}
