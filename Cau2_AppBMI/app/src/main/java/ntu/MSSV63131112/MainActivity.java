package ntu.MSSV63131112;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_hovaten;
    EditText edt_cc;
    EditText edt_cn;
    TextView tv_mota;
    Button btn_tinhtoan;
    ListView lv_history;
    ArrayAdapter<String> boNguon;
    ArrayList<String> list;

    RadioButton rbtn_nam;
    RadioButton rbtn_nu;
    RadioButton rbtn_khac;

    String name;
    String gioitinh;
    double cc;
    double cn;
    double my_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpView();
        ActionOfButton();
        boNguon = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lv_history.setAdapter(boNguon);

    }
    public void setUpView(){
        edt_hovaten = findViewById(R.id.edt_hovaten);
        edt_cc = findViewById(R.id.edt_cc);
        edt_cn = findViewById(R.id.edt_cn);
        tv_mota = findViewById(R.id.tv_mota);
        lv_history = findViewById(R.id.lv_history);
        rbtn_nam = findViewById(R.id.rbtn_nam);
        rbtn_nu = findViewById(R.id.rbtn_nu);
        rbtn_khac = findViewById(R.id.rbtn_khac);
        btn_tinhtoan = findViewById(R.id.btn_tinhtoan);
        list = new ArrayList<>();
    }

    private String getValueOfRadionButton(){
        if(rbtn_nam.isChecked()) return "Nam";
        if(rbtn_nu.isChecked()) return "Nữ";
        if(rbtn_khac.isChecked()) return "Khác";
        return "Nam";
    }
    private double CaculateBMI(double cc,double cn){
        return cn/Math.pow(cc,2);
    }
    private void CompareBMI(double bmi){
        DecimalFormat df= new DecimalFormat("#.#");
        if(bmi < 18.5){
            double cnyeucau =  18.5 * Math.pow(cc, 2) - cn;
            cnyeucau = Double.parseDouble(df.format(cnyeucau));
            String yeucau ="Bạn gầy hơn so với quy định cần tăng "+cnyeucau+" Kg";
            tv_mota.setText(yeucau);
            return;
        }
        if(bmi>=18.5 && bmi<25){
            String yeucau ="Bạn có thân hình cân đối";
            tv_mota.setText(yeucau);
            return;
        }
        if(bmi>=25&& bmi<30){

            double cnyeucau = cn - 24.9 * Math.pow(cc, 2);
            cnyeucau = Double.parseDouble(df.format(cnyeucau));
            String yeucau ="Bạn bị thừa cân cần giảm "+cnyeucau+" Kg";
            tv_mota.setText(yeucau);
            return;
        }
        double cnyeucau = cn - 24.9 * Math.pow(cc, 2);
        cnyeucau = Double.parseDouble(df.format(cnyeucau));
        String yeucau ="Bạn bị béo phì cần giảm "+cnyeucau+" Kg";
        tv_mota.setText(yeucau);
    }
    public void ActionOfButton(){
        btn_tinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyOutput();
            }
        });

    }
    private void notifyOutput(){
        name = edt_hovaten.getText().toString();
        gioitinh = getValueOfRadionButton();
        cc =Double.parseDouble( edt_cc.getText().toString());
        cn =Double.parseDouble( edt_cn.getText().toString());
        my_bmi = CaculateBMI(cc,cn);
        CompareBMI(my_bmi);

        String space = "  ";
        StringBuilder builder = new StringBuilder();
        builder.append(name).
                append(space).
                append(gioitinh).
                append(space).
                append(cc).append("m").
                append(space).append(cn).
                append("kg").append(space).
                append(my_bmi);
        AddItemIntoList(builder.toString());
    }
    private void AddItemIntoList(String item){
        list.add(item);
        boNguon.notifyDataSetChanged();
    }

}