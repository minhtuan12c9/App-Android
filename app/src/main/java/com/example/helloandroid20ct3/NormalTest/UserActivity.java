package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

public class UserActivity extends AppCompatActivity {

    private TextView number, name;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private StringBuilder numberBuilder = new StringBuilder();
    private  Button btnNext, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        number = findViewById(R.id.number);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        // Thiết lập sự kiện lắng nghe cho các nút số
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("9");
            }
        });


        Button btnNext = findViewById(R.id.next);
        name = findViewById(R.id.name);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy nội dung của TextView "number"
                String numberText = number.getText().toString();

                // Tạo Intent để chuyển đến giao diện "profile"
                Intent intent = new Intent(UserActivity.this, ProfileActivity.class);

                // Truyền nội dung từ "user" sang "profile" thông qua Intent
                intent.putExtra("hoten", name.getText().toString());
                intent.putExtra("sdt", numberText);

                // Khởi động giao diện "profile"
                startActivity(intent);
            }
        });


        btnCancel = findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng ứng dụng khi nút "Thoát" được nhấn
            }
        });
    }

    // Phương thức để thêm số vào chuỗi số hiện tại
    private void appendNumber(String digit) {
        numberBuilder.append(digit);
        number.setText(numberBuilder.toString());
    }
}