package ntu.MSSV63131112;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    Button btn_logout;
    Switch sw_color;
    ConstraintLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        btn_logout = findViewById(R.id.btn_logout);
        main = findViewById(R.id.main);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đóng màn hình hiện tại
                finishAffinity();
            }
        });
        sw_color = findViewById(R.id.sw_color);
        sw_color.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
               
                    main.setBackgroundColor(Color.parseColor("#290D42")); // Set màu trắng khi switch được bật
                } else {
                    main.setBackgroundColor(Color.parseColor(" #1A072B")); // Set màu đen khi switch được tắt
                }
            }
        });
    }
}