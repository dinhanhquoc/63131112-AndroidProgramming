package com.example.baikiemtra1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_user;
    EditText edt_pass;
    Button btn_login;
    TextView tv_number;
    int number = 5;
    String user = "a";
    String pass = "b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getControl();

    }
    public void getControl(){


        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);
        btn_login = findViewById(R.id.btn_login);
        tv_number = findViewById(R.id.tv_number);
        tv_number.setText(String.valueOf(number));
    }
    public void KiemTraTaiKhoan(View v){
        if(edt_user.getText().toString().equals(user)&&
                edt_pass.getText().toString().equals(pass))
        {
            Toast.makeText(this,"User and Password is correct",Toast.LENGTH_SHORT).show();
        }
        else{
            if(number>0){
            number-=1;
            tv_number.setText(String.valueOf(number));
            Toast.makeText(this,"User and Password is not correct",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"User is blocked",Toast.LENGTH_SHORT).show();
            }
        }
    }
}