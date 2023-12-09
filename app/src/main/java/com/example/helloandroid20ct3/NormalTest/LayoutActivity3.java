package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloandroid20ct3.R;

public class LayoutActivity3 extends AppCompatActivity {

    boolean isOn = false; // Sử dụng biến này để theo dõi trạng thái
    int white = Color.BLUE; // Lấy màu trắng từ tên màu
    int black = Color.BLACK;
    // Đối tượng ColorStateList cho màu trắng
    ColorStateList whiteTint = ColorStateList.valueOf(white);
    ColorStateList blackTint = ColorStateList.valueOf(black);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout3);


        Button turnonButton = findViewById(R.id.tuan);
        //boolean isOn = false; // Sử dụng biến này để theo dõi trạng thái

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);



        turnonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn) {
                    // Đổi thành trạng thái "Turn Off"
                    isOn = false;
                    turnonButton.setText("Turn On");

                    // Đổi màu của 8 nút button về màu đen
                    button1.setBackgroundTintList(blackTint);
                    button2.setBackgroundTintList(blackTint);
                    button3.setBackgroundTintList(blackTint);
                    button4.setBackgroundTintList(blackTint);
                    button5.setBackgroundTintList(blackTint);
                    button6.setBackgroundTintList(blackTint);
                    button7.setBackgroundTintList(blackTint);
                    button8.setBackgroundTintList(blackTint);
                }else {
                    // Đổi thành trạng thái "Turn On"
                    isOn = true;
                    turnonButton.setText("Turn Off");

                    // Đổi màu của 8 nút button về màu trắng hoặc màu khác tùy ý
                    button1.setBackgroundTintList(whiteTint);
                    button2.setBackgroundTintList(whiteTint);
                    button3.setBackgroundTintList(whiteTint);
                    button4.setBackgroundTintList(whiteTint);
                    button5.setBackgroundTintList(whiteTint);
                    button6.setBackgroundTintList(whiteTint);
                    button7.setBackgroundTintList(whiteTint);
                    button8.setBackgroundTintList(whiteTint);
                }
            }});

    }

    public void nutden1(View v){
        Button button1 = findViewById(R.id.button1);
        boolean isOn1 = false;
        if (isOn1) {
            // Đổi thành trạng thái "Turn Off"
            isOn1 = false;

            // Đổi màu của 8 nút button về màu đen
            button1.setBackgroundTintList(blackTint);
        }else {
            // Đổi thành trạng thái "Turn On"
            isOn1 = true;
            // Đổi màu của 8 nút button về màu trắng hoặc màu khác tùy ý
            button1.setBackgroundTintList(whiteTint);
        }
    }
    public void nutden2(View v){
        Button button1 = findViewById(R.id.button2);
        boolean isOn1 = false;
        if (isOn1) {
            // Đổi thành trạng thái "Turn Off"
            isOn1 = false;

            // Đổi màu của 8 nút button về màu đen
            button1.setBackgroundTintList(blackTint);
        }else {
            // Đổi thành trạng thái "Turn On"
            isOn1 = true;
            // Đổi màu của 8 nút button về màu trắng hoặc màu khác tùy ý
            button1.setBackgroundTintList(whiteTint);
        }
    }
    public void nutden3(View v){
        Button button1 = findViewById(R.id.button3);
        boolean isOn1 = false;
        if (isOn1) {
            // Đổi thành trạng thái "Turn Off"
            isOn1 = false;

            // Đổi màu của 8 nút button về màu đen
            button1.setBackgroundTintList(blackTint);
        }else {
            // Đổi thành trạng thái "Turn On"
            isOn1 = true;
            // Đổi màu của 8 nút button về màu trắng hoặc màu khác tùy ý
            button1.setBackgroundTintList(whiteTint);
        }
    }
}