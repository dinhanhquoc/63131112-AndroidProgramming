package com.example.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputa;
    EditText inputb;
    TextView outputkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setview();


    }
    public void setview (){
    inputa = findViewById(R.id.inputa);
    inputb = findViewById(R.id.inputb);
    outputkq = findViewById(R.id.outputkq);
}
    public void TinhTong(View view){
        int a = Integer.parseInt(inputa.getText().toString());
        int b = Integer.parseInt(inputb.getText().toString());
        outputkq.setText(String.valueOf(a+b));
    }
    public void TinhTru(View view){
        int a = Integer.parseInt(inputa.getText().toString());
        int b = Integer.parseInt(inputb.getText().toString());
        outputkq.setText(String.valueOf(a-b));
    }
    public void TinhNhan(View view){
        int a = Integer.parseInt(inputa.getText().toString());
        int b = Integer.parseInt(inputb.getText().toString());
        outputkq.setText(String.valueOf(a*b));
    }
    public void TinhChia(View view){
        float a = Float.parseFloat(inputa.getText().toString());
        float b = Float.parseFloat(inputb.getText().toString());
        if(b!=0)
            outputkq.setText(String.valueOf(a/b));
        else
            outputkq.setText("Không chia được vì b = 0!");
    }
}