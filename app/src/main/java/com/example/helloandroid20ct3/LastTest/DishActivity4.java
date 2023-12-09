package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

public class DishActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish4);
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
                "Đặt thịt bò xay ra khỏi tủ lạnh để nóng lên phòng nhiệt độ.\n" +
                "Chuẩn bị rau sống bằng cách rửa sạch và cắt nhỏ.\n" +
                "Nướng bacon trong chảo hoặc lò nướng cho đến khi giòn và chín vàng.\n" +"\n"+
                "Bước 2: Tạo Bánh Burger:\n" +
                "\n" +
                "Chia thịt bò thành các phần nhỏ và tạo thành những viên bánh hamburger có đường kính phù hợp.\n" +
                "Ướp thịt bằng muối và tiêu theo khẩu vị cá nhân.\n" +"\n"+
                "Bước 3: Nướng Thịt Bò:\n" +
                "\n" +
                "Trước khi nướng, hâm nóng chảo hoặc lò nướng.\n" +
                "Nướng bánh hamburger trên chảo nóng với dầu ăn khoảng 4-5 phút mỗi bên hoặc cho đến khi thịt chín đều.\n" +"\n"+
                "Bước 4: Phủ Phô Mai:\n" +
                "\n" +
                "Trước khi thịt bò chín đến mức mong muốn, đặt lớp phô mai lên trên bánh hamburger và che phủ để phô mai tan chảy.\n" +"\n"+
                "Bước 5: Lắp Ghép Burger:\n" +
                "\n" +
                "Đặt bánh hamburger đã nướng lên đĩa.\n" +
                "Xếp thịt bò lên trên bánh, sau đó đặt lớp bacon, rau sống, và sốt.\n" +"\n"+
                "Bước 6: Hoàn Thiện và Thưởng Thức:\n" +
                "\n" +
                "Đặt nắp bánh lên trên cùng để giữ cho các thành phần không bị rơi ra khỏi burger.\n" +
                "Dùng tay hoặc que đinh để giữ cho burger không bị trôi ra khi ăn.\n" +
                "Thưởng thức Bacon Cheeseburger ngon miệng cùng với khoai tây chiên hoặc salad nếu muốn.");

    }
}