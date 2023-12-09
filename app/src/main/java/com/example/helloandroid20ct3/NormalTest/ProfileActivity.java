package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView ketqua1;
    private TextView ketqua2;
    private boolean[] selectedNgonNgu;
    private String[] ngonNguItems;
    private String oketqua;
    private TextView hotenEditText;
    private TextView sdtEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ketqua1 = findViewById(R.id.ketqua1);
        ketqua2 = findViewById(R.id.ketqua2);
        selectedNgonNgu = new boolean[]{false, false, false, false};
        ngonNguItems = new String[]{"C++", "Java", "PHP", "HTML"};

        Button chonNganhButton = findViewById(R.id.chonNganh);
        Button chonNgonNguButton = findViewById(R.id.chonNgonNgu);

        chonNganhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNganhDialog();
            }
        });

        chonNgonNguButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNgonNguDialog();
            }
        });

        Button btnThoat = findViewById(R.id.thoat);

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitConfirmationDialog();
            }
        });


        Button btnDangKy = findViewById(R.id.dangKy);
        hotenEditText = findViewById(R.id.hoten);
        sdtEditText = findViewById(R.id.sdt);
        // Lấy dữ liệu từ Intent được truyền từ "user"
        Intent intent = getIntent();
        String ten = intent.getStringExtra("hoten");
        String soDienThoai = intent.getStringExtra("sdt");

        // Hiển thị dữ liệu trong TextViews "hoten" và "sdt" của "profile"
        hotenEditText.setText(ten);
        sdtEditText.setText(soDienThoai);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin từ hotenEditText, sdtEditText và ketqua
                String hoten = hotenEditText.getText().toString();
                String sdt = sdtEditText.getText().toString();
                String ketqua1Text = ketqua1.getText().toString();
                String ketqua2Text = ketqua2.getText().toString();

                // Tạo hộp thoại AlertDialog để hiển thị thông tin đã nhập và chọn
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);

                // Tạo TextView để đặt tiêu đề và căn giữa nó
                TextView title = new TextView(ProfileActivity.this);
                title.setText("THÔNG TIN ĐĂNG KÝ");
                title.setGravity(Gravity.CENTER);
                title.setTextSize(20);

                // Đặt tiêu đề bằng TextView vừa tạo
                builder.setCustomTitle(title);

                // Sử dụng StringBuilder để kết hợp các thông tin thành một chuỗi
                StringBuilder message = new StringBuilder();
                message.append("Họ tên: ").append(hoten).append("\n");
                message.append("Số điện thoại: ").append(sdt).append("\n");
                message.append(ketqua1Text).append("\n");
                message.append(ketqua2Text);

                builder.setMessage(message.toString());

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void showNganhDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn ngành");
        final CharSequence[] items = {"Phần mềm", "Mạng", "Blockchain"};

        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                ketqua1.setText("Đã chọn: " + items[item]);
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();

        alert.show();
    }
    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận thoát");
        builder.setMessage("Bạn có chắc chắn muốn thoát ứng dụng không?");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Đóng ứng dụng khi người dùng xác nhận
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Đóng hộp thoại và không thoát ứng dụng
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showNgonNguDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Chọn ngôn ngữ");

        builder.setMultiChoiceItems(ngonNguItems, selectedNgonNgu, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                selectedNgonNgu[which] = isChecked;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder selectedItems = new StringBuilder();
                for (int i = 0; i < ngonNguItems.length; i++) {
                    if (selectedNgonNgu[i]) {
                        selectedItems.append(ngonNguItems[i]).append(", ");
                    }
                }

                if (selectedItems.length() > 0) {
                    selectedItems.setLength(selectedItems.length() - 2);
                    ketqua2.setText("Ngôn ngữ: " + selectedItems.toString());
                } else {
                    ketqua2.setText("Không chọn ngôn ngữ nào");
                }

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}