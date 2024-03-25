package ntu.MSSV63131112;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn_getstarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn_getstarted = findViewById(R.id.btn_getstarted);
        btn_getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đối tượng dùng để tham khởi tạo màn hình mới
                
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                // Khởi chạy activity mới
                startActivity(intent);
                finishAffinity();
            }
        });
    }
}