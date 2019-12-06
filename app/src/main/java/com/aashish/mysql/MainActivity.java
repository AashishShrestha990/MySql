package com.aashish.mysql;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aashish.mysql.myhelper.MyHelper;

public class MainActivity extends AppCompatActivity {
    EditText etword, etmeaning;
    Button btnadd,btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etword = findViewById(R.id.etword);
        etmeaning = findViewById(R.id.etmeaning);
        btnadd = findViewById(R.id.btnaddword);
        btnshow = findViewById(R.id.show);
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = myHelper.InsertData(etword.getText().toString(), etmeaning.getText().toString(), sqLiteDatabase);
                if(id > 0){
                    Toast.makeText(MainActivity.this, "Sucessful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }


}
