package com.example.ex4_addsubmuldiv_onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button cong;
    Button tru;
    Button nhan;
    Button chia;

    EditText inputa;
    EditText inputb;
    TextView outputKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setview();
        setButtonCong();
        setButtonTru();
        setButtonNhan();
        setButtonChia();

    }

    public void setview(){
        cong = (Button) findViewById(R.id.cong);
        tru = findViewById(R.id.tru);
        nhan = findViewById(R.id.nhan);
        chia = findViewById(R.id.chia);
        inputa = findViewById(R.id.inputa);
        inputb = findViewById(R.id.inputb);
        outputKq = findViewById(R.id.outputkq);
    }

    public void setButtonCong(){
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = Integer.parseInt(inputa.getText().toString()) + Integer.parseInt(inputb.getText().toString());
                outputKq.setText(String.valueOf(kq));
            }
        });
    }
    public void setButtonTru(){
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = Integer.parseInt(inputa.getText().toString()) - Integer.parseInt(inputb.getText().toString());
                outputKq.setText(String.valueOf(kq));
            }
        });
    }
    public void setButtonNhan(){
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = Integer.parseInt(inputa.getText().toString()) * Integer.parseInt(inputb.getText().toString());
                outputKq.setText(String.valueOf(kq));
            }
        });
    }
    public void setButtonChia(){
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Float.parseFloat(inputb.getText().toString())!=0){
                    float kq = Float.parseFloat(inputa.getText().toString()) /  Float.parseFloat(inputb.getText().toString());
                    outputKq.setText(String.valueOf(kq));
                }
                else
                    outputKq.setText("Không chia được vì b = 0");


            }
        });
    }

}