package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

public class chucnangMain2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chucnang_main2);

        ImageButton bt1 = findViewById(R.id.bt1);
        ImageButton bt2 = findViewById(R.id.bt2);
        ImageButton bt3 = findViewById(R.id.bt3);

        Button btchange = findViewById(R.id.change);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(chucnangMain2.this, MainActivity2.class);
                i1.putExtra("imageResource", R.drawable.logo);
                startActivity(i1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(chucnangMain2.this, MainActivity2.class);
                i1.putExtra("imageResource", R.drawable.android);
                startActivity(i1);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(chucnangMain2.this, MainActivity2.class);
                i1.putExtra("imageResource", R.drawable.ic_launcher_foreground);
                startActivity(i1);
            }
        });


        btchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(chucnangMain2.this, MainActivity2.class);
                TextView title = findViewById(R.id.textView);
                String getTitle = title.getText().toString();
                i1.putExtra("title", getTitle);
                startActivity(i1);
            }
        });
    }
}