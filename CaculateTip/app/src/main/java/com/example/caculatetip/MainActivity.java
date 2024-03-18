package com.example.caculatetip;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.caculatetip.R;

public class MainActivity extends AppCompatActivity {
    EditText edt_money;
    RadioGroup radioGroup;
    TextView tv_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view từ layout
        edt_money = findViewById(R.id.edt_money);
        radioGroup = findViewById(R.id.radioGroup4);
        tv_tip = findViewById(R.id.tv_tip);

        // Đặt sự kiện click cho nút tính toán
        findViewById(R.id.btn_caculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        // Lấy số tiền từ EditText
        String moneyString = edt_money.getText().toString();
        if (moneyString.isEmpty()) {
            // Nếu không có số tiền nhập vào, không thực hiện tính toán
            tv_tip.setText("Please enter an amount");
            return;
        }

        // Chuyển đổi số tiền từ chuỗi sang số
        double money = Double.parseDouble(moneyString);

        // Lấy tỉ lệ tip dựa trên RadioButton được chọn
        int tipPercentage = getTipPercentage();

        // Tính toán tip dựa trên số tiền và tỉ lệ tip
        double tip = money * (tipPercentage / 100.0);

        // Hiển thị tip trên TextView
        tv_tip.setText(String.format("%.2f", tip));
    }

    private int getTipPercentage() {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // Tìm RadioButton được chọn
        RadioButton selectedRadioButton = findViewById(selectedId);

        // Lấy văn bản của RadioButton được chọn
        String tipPercentageString = selectedRadioButton.getText().toString();

        // Xóa ký tự '%' và chuyển đổi sang số nguyên
        return Integer.parseInt(tipPercentageString.replace("%", ""));
    }
}
