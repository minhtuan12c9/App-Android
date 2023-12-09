package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

public class DishActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish6);
        Button btnBack = findViewById(R.id.back);
        TextView tvCT = findViewById(R.id.textView30);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvCT.setText("Bước 1: Chuẩn Bị Thành Phần:\n" +
                "\n" +
                "Trộn thịt bò xay với sốt Worcestershire, hạt tỏi băm nhuyễn, muối, và tiêu theo khẩu vị.\n" +
                "Chuẩn bị rau sống bằng cách rửa sạch và cắt nhỏ.\n" +
                "Chiên nấm cắt lát trên chảo với dầu ăn cho đến khi chúng có màu nâu và giữ được độ giòn.\n" + "\n"+
                "Bước 2: Nướng Thịt Bò:\n" +
                "\n" +
                "Tạo thành viên bánh hamburger và nướng trên chảo nóng hoặc lò nướng với dầu ăn cho đến khi chín và có vẻ giòn.\n" +"\n"+
                "Bước 3: Phủ Phô Mai Swiss:\n" +
                "\n" +
                "Khi thịt gần chín đến mức mong muốn, đặt lớp phô mai Swiss lên trên thịt và che phủ để phô mai tan chảy.\n" +"\n"+
                "Bước 4: Lắp Ghép Burger:\n" +
                "\n" +
                "Đặt bánh hamburger đã nướng lên đĩa.\n" +
                "Xếp lớp thịt gà, nấm chiên, và rau sống lên trên bánh.\n" +"\n"+
                "Bước 5: Hoàn Thiện và Thưởng Thức:\n" +
                "\n" +
                "Thêm các phụ liệu như sốt mayonnaise hoặc ketchup nếu muốn.\n" +
                "Đặt nắp bánh lên trên cùng và thưởng thức Mushroom Swiss Burger ngon miệng.");

    }
}