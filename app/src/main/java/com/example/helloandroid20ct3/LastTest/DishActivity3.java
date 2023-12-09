package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

public class DishActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish3);
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
                "Trong một tô lớn, trộn đều bột mỳ, đường, men nở, và muối.\n" +
                "Thêm nước ấm và dầu olive, trộn đều cho đến khi tạo thành một cục bột mềm và mịn.\n" +
                "Đặt bột trong một tô, che phủ bằng khăn sạch và để nở trong khoảng 1 đến 1.5 giờ hoặc cho đến khi bột gấp đôi kích thước.\n" +"\n"+
                "2/Chuẩn bị sốt cà chua:\n" +
                "\n" +
                "Trong một nồi nhỏ, hâm nóng dầu olive và đun nóng tỏi cho đến khi thơm.\n" +
                "Thêm cà chua purée, thảo mộc, đường, muối, và hạt tiêu. Đun sôi và hạ lửa, nấu trong khoảng 15-20 phút hoặc cho đến khi sốt sôi đặc.\n" +"\n"+
                "3/Làm bánh pizza:\n" +
                "\n" +
                "Khi bột đã nở đủ, trải bột ra trên bảng nhà bếp đã lót bột mỡ và bột mỳ.\n" +
                "Nướng lò ở 220-240 độ C.\n" +
                "Trải bột thành hình tròn hoặc hình chữ nhật và đặt lên tấm nướng pizza.\n" +
                "Phổ biến sốt cà chua trên bề mặt bánh.\n" +"\n"+
                "4/Phủ lớp phô mai và nguyên liệu khác:\n" +
                "\n" +
                "Đặt lớp Mozzarella trên sốt cà chua, sau đó phủ bằng phô mai Parmesan.\n" +
                "Xếp lớp pepperoni, súp lơ, và ớt chuông lên trên.\n" +"\n"+
                "5/Nướng pizza:\n" +
                "\n" +
                "Đặt pizza vào lò đã được nóng trước đó và nướng cho đến khi bánh giòn và phô mai tan chảy và có màu vàng đẹp (khoảng 15-20 phút).\n" +"\n"+
                "6/Kết thúc và thưởng thức:\n" +
                "\n" +
                "Rưới dầu olive lên trên bánh nóng hổi và thêm một ít thảo mộc tươi nếu bạn muốn.\n" +
                "Cắt thành từng miếng và thưởng thức Pizza New York thơm ngon và hấp dẫn.");

    }
}