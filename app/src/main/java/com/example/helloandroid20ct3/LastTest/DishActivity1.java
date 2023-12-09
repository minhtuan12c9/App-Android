package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

public class DishActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish1);
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
                "Nếu bạn muốn tự làm bột pizza, hãy trộn một lượng bột mỳ với nước, men nở, dầu olive và một ít muối. Đảm bảo trộn đều để tạo thành một cục bột mềm mại.\n" + "\n"+
                "2/Chuẩn bị bánh pizza:\n" +
                "\n" +
                "Nếu sử dụng bột mua sẵn, mở gói và làm theo hướng dẫn trên bao bì. Nếu tự làm bột, hãy trải bột thành một lớp mỏng, tạo thành hình tròn hoặc hình chữ nhật trên một tấm nướng pizza.\n" +"\n"+
                "3/Phủ sốt cà chua:\n" +
                "\n" +
                "Phổ biến một lớp sốt cà chua pizza đều trên bề mặt bánh, để lại khoảng mép ngoài để tạo thành vị giòn khi nướng.\n" +"\n"+
                "4/Thêm phô mai:\n" +
                "\n" +
                "Phủ đều lớp phô mai Mozzarella lên trên sốt cà chua. Bạn cũng có thể thêm các loại phô mai khác để tăng thêm hương vị.\n" +"\n"+
                "5/Thêm pepperoni và các nguyên liệu khác:\n" +
                "\n" +
                "Xếp lớp pepperoni lên trên phô mai. Nếu muốn, bạn cũng có thể thêm hành tây, ớt chuông hoặc các nguyên liệu khác theo sở thích cá nhân.\n" +"\n"+
                "6/Nướng pizza:\n" +
                "\n" +
                "Trước khi nướng, hâm nóng lò trước ở nhiệt độ cao (khoảng 220-240 độ C). Đặt pizza vào lò và nướng cho đến khi bánh và phô mai chảy và có màu vàng đẹp (thường mất khoảng 12-15 phút).\n" +"\n"+
                "7/Kết thúc và thưởng thức:\n" +
                "\n" +
                "Khi pizza nướng chín, rưới một ít dầu olive lên trên để làm tăng thêm hương vị. Cắt thành từng miếng và thưởng thức nóng hổi.");

    }
}