package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.TypedValue;
import android.graphics.Color;

import com.example.helloandroid20ct3.R;

import java.util.Random;

public class HelloActivity extends AppCompatActivity {

    private final int[] textSizeOptions = {20, 30, 40}; // Các cỡ chữ
    private final int[] textColorOptions = {Color.RED, Color.BLUE, Color.YELLOW}; // Các màu sắc
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);


        TextView textView = findViewById(R.id.textView);

        // Lấy dữ liệu từ Intent
        Intent intent = getIntent();
        String fullname = intent.getStringExtra("getFullname");
        String year = intent.getStringExtra("getYear");

        textView.setText("Hi, "+fullname+" - "+year);
    }

    public  void  doButtonCLose(View v){

        finish();
    }

    public  void doButtonGoogle(View v){
        Intent i1 = new Intent(Intent.ACTION_VIEW);
        i1.setData(Uri.parse("https://google.com.vn"));
        startActivity(i1);
    }
    public void doButtonChange(View v){
        TextView textView = findViewById(R.id.textView);
//        textView.setText("HPMT - DHKT");
//        Random random = new Random();
//
//        // Chọn ngẫu nhiên một cỡ chữ và một màu sắc
//        int randomTextSize = textSizeOptions[random.nextInt(textSizeOptions.length)];
//        int randomTextColor = textColorOptions[random.nextInt(textColorOptions.length)];
//
//        // Thay đổi kích cỡ chữ và màu sắc
//        textView.setTextSize(randomTextSize);
//        textView.setTextColor(randomTextColor);

        EditText title = findViewById(R.id.edittitle);
        EditText color = findViewById(R.id.editcolor);
        EditText size = findViewById(R.id.editsize);

        textView.setText(title.getText().toString());
        if (color.getText().toString().equals("1"))
            textView.setTextColor(Color.RED);
        if (color.getText().toString().equals("2"))
            textView.setTextColor(Color.BLUE);
        if (color.getText().toString().equals("3"))
            textView.setTextColor(Color.GREEN);
        if (color.getText().toString().equals("#"))
            textView.setTextColor(Color.BLACK);

        try {
            float textSize = Float.parseFloat(size.getText().toString());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập không phải là số hợp lệ từ EditText size
        }
    }
    public void btnLogo1(View v){
        ImageView anhnen = findViewById(R.id.anhnen);

        anhnen.setImageResource(R.drawable.anhnen1);
    }
    public void btnLogo2(View v){
        ImageView anhnen = findViewById(R.id.anhnen);

        anhnen.setImageResource(R.drawable.anhnen2);
    }
}