package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

import org.w3c.dom.Text;

public class OperaActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opera3);

        Button daucong = findViewById(R.id.daucong);
        Button dautru = findViewById(R.id.dautru);
        Button daunhan = findViewById((R.id.daunhan));
        Button dauchia = findViewById(R.id.dauchia);

        EditText so1 = findViewById(R.id.so1);
        EditText so2 = findViewById(R.id.so2);

        Button reset = findViewById(R.id.nutreset);
        Button close = findViewById(R.id.nutclose);

        TextView hienthi = findViewById(R.id.textview1);

        daucong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float oso1 = Float.parseFloat(so1.getText().toString());
                float oso2 = Float.parseFloat(so2.getText().toString());
                float kq = oso1+oso2;
                String ketqua = Float.toString(kq);
                String oketqua = so1.getText().toString() + " " + "+ " + so2.getText().toString() + " " + "= " + ketqua;
                hienthi.setText(oketqua);
            }
        });

        dautru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float oso1 = Float.parseFloat(so1.getText().toString());
                float oso2 = Float.parseFloat(so2.getText().toString());
                float kq = oso1-oso2;
                String ketqua = Float.toString(kq);
                String oketqua = so1.getText().toString() + " " + "- " + so2.getText().toString() + " " + "= " + ketqua;
                hienthi.setText(oketqua);
            }
        });

        daunhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float oso1 = Float.parseFloat(so1.getText().toString());
                float oso2 = Float.parseFloat(so2.getText().toString());
                float kq = oso1*oso2;
                String ketqua = Float.toString(kq);
                String oketqua = so1.getText().toString() + " " + "x " + so2.getText().toString() + " " + "= " + ketqua;
                hienthi.setText(oketqua);
            }
        });

        dauchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float oso1 = Float.parseFloat(so1.getText().toString());
                float oso2 = Float.parseFloat(so2.getText().toString());
                float kq = oso1/oso2;
                String ketqua = Float.toString(kq);
                String oketqua = so1.getText().toString() + " " + "÷ " + so2.getText().toString() + " " + "= " + ketqua;
                hienthi.setText(oketqua);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so1.setText("");
                so2.setText("");
                hienthi.setText("");
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}