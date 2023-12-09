package com.example.helloandroid20ct3.LastTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.helloandroid20ct3.R;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void getStarted(View v){
        Intent i1 = new Intent(this, TrangChu.class);
        startActivity(i1);
    }
}