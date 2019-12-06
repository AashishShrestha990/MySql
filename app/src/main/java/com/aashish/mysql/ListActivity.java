package com.aashish.mysql;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.aashish.mysql.model.Word;
import com.aashish.mysql.myhelper.MyHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = findViewById(R.id.listword);
        loadword();



    }

    private void loadword() {
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Word> wordlist = new ArrayList<>();
        wordlist = myHelper.GetAllWords(sqLiteDatabase);
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < wordlist.size(); i++) {

            hashMap.put(wordlist.get(i).getWord(), wordlist.get(i).getMeaning());
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        list.setAdapter(stringArrayAdapter);
    }
}
