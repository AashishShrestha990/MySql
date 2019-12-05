package com.aashish.mysql.myhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbName = "Database";
    private static final int dbVersion = 1;

    private static final String tblWord = "tblWord";
    private static final String WordId = "WordId";
    private static final String Word = "Word";
    private static final String Meaning = "Meaning";


    public MyHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
