package com.example.thuchanh_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_input;
    Button btn_inputnhap;
    ListView lv_danhsach;
    ArrayList<String> dsTen;
    ArrayAdapter<String> bo_nguon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();// Hàm khởi tạo tham chiếu sử dụng các đối tượng
        dsTen = new ArrayList<>();// Chuẩn bị danh sách nạp vào để nạp vào ListView
        dsTen.add("Mai");
        dsTen.add("Cúc");
        dsTen.add("Đào");

        // You forgot to pass the ArrayList to the ArrayAdapter
        bo_nguon = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, dsTen); // Loại xếp hàng dọc, và hiển thị ds

        // You missed setting the adapter to the ListView
        lv_danhsach.setAdapter(bo_nguon);
    }

    public void getControls() {
        edt_input = findViewById(R.id.edt_input);
        btn_inputnhap = findViewById(R.id.btn_inputnhap);
        lv_danhsach = findViewById(R.id.lv_danhsach);
    }

    public void ThemPhanTu(View v) {
        // You don't need to find the EditText again, you already have it
        String tenNhap = edt_input.getText().toString();
        dsTen.add(tenNhap);
        // Notify the adapter that the dataset has changed
        bo_nguon.notifyDataSetChanged();
    }
}
