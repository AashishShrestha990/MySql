package com.aashish.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etword, etmeaning;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etword = findViewById(R.id.etword);
        etmeaning = findViewById(R.id.etmeaning);
        btnadd = findViewById(R.id.btnaddword);

        btnadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
