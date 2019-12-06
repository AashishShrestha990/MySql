package com.aashish.mysql.myhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.aashish.mysql.model.Word;

import java.util.ArrayList;
import java.util.List;

public class MyHelper extends SQLiteOpenHelper {

    private static final String dbName = "Dictionary";
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

//        db = getWritableDatabase();

        String createtable = "CREATE TABLE " + tblWord +
                "("
                + WordId + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                Word + " TEXT,"
                + Meaning + " TEXT" +
                ")";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//
//    public boolean InsertData(String word, String meaning, SQLiteDatabase db) {
//        try {
//            String query = "insert into Words(Word,Meaning) values('" + word + "','" + meaning + "')";
//            db.execSQL(query);
//            return true;
//        } catch (Exception e) {
//            Log.d("error: ", e.toString());
//            return false;
//        }
//    }
    public long InsertData(String word, String meaning, SQLiteDatabase db){
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Word,word);
        contentValues.put(Meaning,meaning);
        id = db.insert(tblWord, null, contentValues);
        return id;

    }

    public List<com.aashish.mysql.model.Word> GetAllWords(SQLiteDatabase db) {
        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from tblWord",null);
        if (cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                dictionaryList.add(new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }
        }
        return dictionaryList;
    }
}
