package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.helloandroid20ct3.R;

public class QuotationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotations);

        String english[] = {"You must be the change you wish to see in the world", "Spread love everywhere you go. Let no one ever come to you without leaving happier", "The only thing we have to fear is fear itself", "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that", "Do one thing every day that scares you", "Well done is better than well said"};
        int size[] = {20, 30, 40};
        int color[] = {Color.RED, Color.YELLOW, Color.BLUE};
        int textcolor[] = {Color.BLACK, Color.GREEN, Color.GRAY};
        int gravity[] = {Gravity.LEFT, Gravity.CENTER_HORIZONTAL, Gravity.RIGHT};

        
    }
}