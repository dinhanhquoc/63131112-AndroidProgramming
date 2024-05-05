package com.example.itentexample1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class XemKetQuaActivity extends AppCompatActivity {
    Button chuyenManHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xem_ket_qua);

    }
    public void ChuyenManHinh(View view){
        Intent i = new Intent(this,NhapLieuActivity.class);
        startActivity(i);
    }
}