package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

public class DishActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish2);
        Button btnBack = findViewById(R.id.back);
        TextView tvCT = findViewById(R.id.textView30);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvCT.setText("1/Làm bột pizza:\n" +
                "\n" +
                "Nếu tự làm bột, trộn một lượng bột mỳ với nước, men nở, dầu olive, và muối. Trộn đều để tạo thành một cục bột mềm mại.\n" +"\n"+
                "2/Chuẩn bị bánh pizza:\n" +
                "\n" +
                "Trải bột thành một lớp mỏng, tạo thành hình tròn hoặc hình chữ nhật trên một tấm nướng pizza.\n" +"\n"+
                "3/Phủ sốt cà chua:\n" +
                "\n" +
                "Phổ biến một lớp sốt cà chua pizza đều trên bề mặt bánh. Sốt cà chua Margherita thường được làm từ cà chua tươi và ít gia vị.\n" +"\n"+
                "4/Thêm phô mai:\n" +
                "\n" +
                "Phủ đều lớp phô mai Mozzarella tươi hoặc Fior di Latte lên trên sốt cà chua.\n" +"\n"+
                "5/Thêm lá rau basil:\n" +
                "\n" +
                "Đặt lá rau basil tươi lên trên lớp phô mai. Cố gắng giữ lá rau basil nguyên vẹn để tạo nên hình ảnh trang trí đẹp mắt.\n" +"\n"+
                "6/Nướng pizza:\n" +
                "\n" +
                "Hâm nóng lò trước ở nhiệt độ cao (khoảng 220-240 độ C). Đặt pizza vào lò và nướng cho đến khi bánh và phô mai chảy và có màu vàng đẹp (thường mất khoảng 10-12 phút).\n" +"\n"+
                "7/Kết thúc và thưởng thức:\n" +
                "\n" +
                "Trước khi thưởng thức, rưới một ít dầu olive lên trên pizza. Nếu muốn, bạn có thể thêm một chút muối và hạt tiêu để tăng thêm hương vị.");

    }
}