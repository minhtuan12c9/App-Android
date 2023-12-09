package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

public class DishActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish5);
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
                "Đặt thịt gà bò xay ra khỏi tủ lạnh để nóng lên phòng nhiệt độ.\n" +
                "Chuẩn bị rau sống bằng cách rửa sạch và cắt nhỏ.\n" +
                "Chia avocado làm đôi, loại bỏ hạt và dùng thìa để lấy phần thịt.\n" +"\n"+
                "Bước 2: Tạo Bánh Burger:\n" +
                "\n" +
                "Chia thịt gà bò thành các phần nhỏ và tạo thành những viên bánh hamburger có đường kính phù hợp.\n" +
                "Ướp thịt bằng muối và tiêu theo khẩu vị cá nhân.\n" +"\n"+
                "Bước 3: Nướng Thịt Gà:\n" +
                "\n" +
                "Trước khi nướng, hâm nóng chảo hoặc lò nướng.\n" +
                "Nướng bánh hamburger trên chảo nóng với dầu ăn khoảng 4-5 phút mỗi bên hoặc cho đến khi thịt chín đều.\n" +"\n"+
                "Bước 4: Phủ Avocado và Xếp Ghép:\n" +
                "\n" +
                "Khi thịt gà đã chín đến mức mong muốn, đặt lớp avocado lên trên bánh.\n" +
                "Xếp rau sống, cà chua, và hành tây lên trên lớp avocado.\n" +"\n"+
                "Bước 5: Tạo Sốt Dijon Mustard và Mayonnaise:\n" +
                "\n" +
                "Trong một tô nhỏ, trộn đều Dijon mustard và mayonnaise để tạo thành sốt đặc trưng.\n" +"\n"+
                "Bước 6: Lắp Ghép và Thưởng Thức:\n" +
                "\n" +
                "Đặt bánh hamburger đã nướng lên đĩa.\n" +
                "Xếp lớp thịt gà, avocado, rau sống, và chấm sốt Dijon Mustard và Mayonnaise lên trên.");

    }
}