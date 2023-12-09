package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView img = findViewById(R.id.img);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        int imageResource = intent.getIntExtra("imageResource", 0);

        // Đặt ảnh cho ImageView
        if (imageResource != 0) {
            img.setImageResource(imageResource);
        }

        String title = intent.getStringExtra("title");
        TextView textView = findViewById(R.id.tv);
        textView.setText(title);
    }

    public void doButtonCharacter(View v){
        Intent i1 = new Intent(this, chucnangMain2.class);
        startActivity(i1);
    }
    public void doButtonBottom(View v){
        Intent i1 = new Intent(this, chucnangMain2.class);
        startActivity(i1);
    }
}