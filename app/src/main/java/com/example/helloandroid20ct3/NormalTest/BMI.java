package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }
    public void btnKetqua(View v){
        EditText chieucao = findViewById(R.id.chieucao);
        float chieucao2 = Float.parseFloat(chieucao.getText().toString());

        EditText cannang = findViewById(R.id.cannang);
        float cannang2 = Float.parseFloat(cannang.getText().toString());

        float bmi = cannang2/(chieucao2*chieucao2);

        String array[] = getResources().getStringArray(R.array.message);

        TextView ketqua = findViewById(R.id.ketqua);

        ketqua.setVisibility(View.VISIBLE);
        if (bmi<18)
            ketqua.setText(array[0]);
        else if (18<=bmi&&bmi<24.9)
            ketqua.setText(array[1]);
        else if (24.9<=bmi&&bmi<=29.9)
            ketqua.setText(array[2]);
        else
            ketqua.setText(array[3]);
    }
}