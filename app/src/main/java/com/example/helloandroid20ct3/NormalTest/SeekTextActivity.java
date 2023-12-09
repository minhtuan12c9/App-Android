package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.helloandroid20ct3.R;

public class SeekTextActivity extends AppCompatActivity {

    private Switch boldSwitch;
    private RadioButton redButton;
    private RadioGroup colorRadioGroup;
    private RadioButton blueButton;
    private SeekBar seekBar;
    private TextView ketqua;
    private TextView tvText;
    private Button giamButton;
    private Button tangButton;
    private int fontSize = 20; // Kích thước chữ mặc định

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_text);

        boldSwitch = findViewById(R.id.bold);
        colorRadioGroup = findViewById(R.id.colorRadioGroup);
        redButton = findViewById(R.id.redButton);
        blueButton = findViewById(R.id.blueButton);
        seekBar = findViewById(R.id.seekBar);
        ketqua = findViewById(R.id.ketqua);
        tvText = findViewById(R.id.textView4);
        giamButton = findViewById(R.id.giam);
        tangButton = findViewById(R.id.tang);

        // Bật/tắt Switch Listener
        boldSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            updateKetqua();
        });

        // RadioButton Listener
        redButton.setOnClickListener(v -> {
            updateKetqua();
        });

        blueButton.setOnClickListener(v -> {
            updateKetqua();
        });

        // SeekBar Listener (nếu bạn muốn thay đổi kích thước chữ, bạn có thể thêm nó)
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateKetqua();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Giam Button Listener
        giamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSize(-5);
            }
        });

        // Tang Button Listener
        tangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSize(5);
            }
        });
    }

    private void updateSize(int number){
        int seekBarValue = seekBar.getProgress();
        seekBar.setProgress(seekBarValue + number);
    }

    private void updateKetqua() {
        StringBuilder result = new StringBuilder();

        if (boldSwitch.isChecked()) {
            result.append("Bold, ");
        }

        int checkedId = colorRadioGroup.getCheckedRadioButtonId();

        if (checkedId == R.id.redButton) {
            result.append("Red, ");
            ketqua.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        } else if (checkedId == R.id.blueButton) {
            result.append("Blue, ");
            ketqua.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        }

        int seekBarValue = seekBar.getProgress();
        result.append(seekBarValue);
        ketqua.setText(result.toString());
        ketqua.setTextSize(TypedValue.COMPLEX_UNIT_SP, seekBarValue);
    }
}