package ntu.MSSV63131112;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    ImageView icon_vietnam,icon_my,icon_nhat;
    int ngonngu = 1;
    TextView txt_chuongtrinh,txt_hoten,txt_gioitinh,txt_chieucao,txt_cannang,txt_lichsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpView();
        ActionOfButton();
        boNguon = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        lv_history.setAdapter(boNguon);
        ActionOfIconVN();
        ActionOfIconEN();
        ActionOfIconJP();
    }
    public void ActionOfIconVN(){
        icon_vietnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngonngu = 1;
                XuLyNgonNgu(ngonngu);
            }
        });
    }
    public void ActionOfIconEN(){
        icon_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngonngu = 2;
                XuLyNgonNgu(ngonngu);
            }
        });
    }
    public void ActionOfIconJP(){
        icon_nhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngonngu = 3;
                XuLyNgonNgu(ngonngu);
            }
        });
    }
    private void XuLyNgonNgu(int nn) {
        switch (nn) {
            case 1: // Tiếng Việt
                edt_hovaten.setHint("Hãy nhập họ và tên");
                rbtn_nam.setText("Nam");
                rbtn_nu.setText("Nữ");
                rbtn_khac.setText("Khác");
                txt_chuongtrinh.setText("CHƯƠNG TRÌNH TÍNH VÀ THEO DÕI BMI CƠ THỂ");
                txt_hoten.setText("Họ và tên");
                txt_gioitinh.setText("Giới tính");
                txt_chieucao.setText("Chiều cao (M)");
                txt_cannang.setText("Cân nặng (Kg)");
                btn_tinhtoan.setText("Tính toán");
                edt_cc.setHint("Hãy nhập chiều cao");
                edt_cn.setHint("Hãy nhập cân nặng");
                tv_mota.setText("Thông tin");
                txt_lichsu.setText("Lịch sử BMI");
                break;
            case 2: // Tiếng Anh
                txt_chuongtrinh.setText("BMI CALCULATOR PROGRAM");
                txt_hoten.setText("Name");
                txt_gioitinh.setText("Gender");
                txt_chieucao.setText("Height (M)");
                txt_cannang.setText("Weight (Kg)");
                rbtn_nam.setText("Male");
                rbtn_nu.setText("Female");
                rbtn_khac.setText("Other");
                btn_tinhtoan.setText("Calculate");
                edt_cc.setHint("Enter height");
                edt_cn.setHint("Enter weight");
                tv_mota.setText("Information");
                txt_lichsu.setText("BMI History");
                break;
            case 3: // Tiếng Nhật
                txt_chuongtrinh.setText("BMI体重計算プログラム");
                txt_hoten.setText("名前");
                txt_gioitinh.setText("性別");
                txt_chieucao.setText("身長(m)");
                txt_cannang.setText("体重(kg)");
                rbtn_nam.setText("男性");
                rbtn_nu.setText("女性");
                rbtn_khac.setText("その他");
                btn_tinhtoan.setText("計算");
                edt_cc.setHint("身長を入力してください");
                edt_cn.setHint("体重を入力してください");
                tv_mota.setText("情報");
                txt_lichsu.setText("BMIの履歴");
                break;
        }
    }

    public void setUpView(){
        txt_chuongtrinh = findViewById(R.id.txt_chuongtrinh);
        txt_hoten = findViewById(R.id.txt_hoten);
        txt_gioitinh = findViewById(R.id.txt_gioitinh);
        txt_chieucao = findViewById(R.id.txt_chieucao);
        txt_cannang = findViewById(R.id.txt_cannang);
        txt_lichsu = findViewById(R.id.txt_lichsu);

        icon_vietnam = findViewById(R.id.icon_vietnam);
        icon_my = findViewById(R.id.icon_my);
        icon_nhat = findViewById(R.id.icon_nhat);
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

    private String getValueOfRadioButton(int nn) {
        if (rbtn_nam.isChecked()) {
            if (nn == 1) return "Nam";
            if (nn == 2) return "Male";
            if (nn == 3) return "男性"; // Chuyển sang tiếng Nhật
        }
        if (rbtn_nu.isChecked()) {
            if (nn == 1) return "Nữ";
            if (nn == 2) return "Female";
            if (nn == 3) return "女性"; // Chuyển sang tiếng Nhật
        }
        if (rbtn_khac.isChecked()) {
            if (nn == 1) return "Khác";
            if (nn == 2) return "Other";
            if (nn == 3) return "その他"; // Chuyển sang tiếng Nhật
        }
        return "Nam"; // Giá trị mặc định
    }
    private double CaculateBMI(double cc,double cn){
        return cn/Math.pow(cc,2);
    }
    private void CompareBMI(double bmi) {
        DecimalFormat df = new DecimalFormat("#.#");

        if (bmi < 18.5) {
            double cnyeucau = 18.5 * Math.pow(cc, 2) - cn;
            cnyeucau = Double.parseDouble(df.format(cnyeucau));
            switch (ngonngu) {
                case 1: {
                    String yeucau = "Bạn gầy hơn so với quy định cần tăng " + cnyeucau + " Kg";
                    tv_mota.setText(yeucau);
                    break;
                }
                case 2: {
                    String yeucau = "You are underweight and need to gain" + cnyeucau + " Kg";
                    tv_mota.setText(yeucau);
                    break;
                }
                case 3: {
                    String yeucau3 = "あなたは基準より痩せており、" + cnyeucau + " キログラム増やす必要があります";
                    break;
                }
            }
            return;
        }


        if (bmi >= 18.5 && bmi < 25) {
            switch (ngonngu) {
                case 1:
                    String yeucauVi = "Bạn có thân hình cân đối";
                    tv_mota.setText(yeucauVi);
                    break;
                case 2:
                    String yeucauEn = "You have a balanced body shape";
                    tv_mota.setText(yeucauEn);
                    break;
                case 3:
                    String yeucauJa = "バランスの取れた体型です";
                    tv_mota.setText(yeucauJa);
                    break;
            }
            return;
        }
        if (bmi >= 25 && bmi < 30) {
            double cnyeucau = cn - 24.9 * Math.pow(cc, 2);
            cnyeucau = Double.parseDouble(df.format(cnyeucau));
            switch (ngonngu) {
                case 1:
                    String yeucauObeseVi = "Bạn bị béo phì cần giảm " + cnyeucau + " Kg";
                    tv_mota.setText(yeucauObeseVi);
                    break;
                case 2:
                    String yeucauObeseEn = "You are obese and need to lose " + cnyeucau + " Kg";

                    tv_mota.setText(yeucauObeseEn);
                    break;
                case 3:
                    String yeucauObeseJa = "あなたは肥満で、" + cnyeucau + " キログラム減らす必要があります";
                    tv_mota.setText(yeucauObeseJa);
                    break;
            }
            return;
        }
        // Xử lý phần còn lại
        double cnyeucau = cn - 24.9 * Math.pow(cc, 2);
        cnyeucau = Double.parseDouble(df.format(cnyeucau));
        switch (ngonngu) {
            case 1:
                String yeucauObeseVi = "Bạn bị béo phì cần giảm " + cnyeucau + " Kg";

                tv_mota.setText(yeucauObeseVi);
                break;
            case 2:
                String yeucauObeseEn = "You are obese and need to lose " + cnyeucau + " Kg";
                tv_mota.setText(yeucauObeseEn);
                break;
            case 3:
                String yeucauObeseJa = "あなたは肥満で、" + cnyeucau + " キログラム減らす必要があります";
                tv_mota.setText(yeucauObeseJa);
                break;
        }
    }
    public void ActionOfButton(){
        btn_tinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edt_hovaten.getText().toString();
                String chieucao = edt_cc.getText().toString();
                String cannang = edt_cn.getText().toString();
                if(!hoten.isEmpty() && !chieucao.isEmpty() && !cannang.isEmpty())
                    notifyOutput();
                else{

                    tv_mota.setText("Hãy nhập thông tin cần thiết");
                }
            }
        });

    }
    private void notifyOutput(){
        name = edt_hovaten.getText().toString();
        gioitinh = getValueOfRadioButton(ngonngu);
        cc =Double.parseDouble( edt_cc.getText().toString());
        cn =Double.parseDouble( edt_cn.getText().toString());
        my_bmi = CaculateBMI(cc,cn);
        CompareBMI(my_bmi);
        DecimalFormat df= new DecimalFormat("#.#");
        my_bmi = Double.parseDouble(df.format(my_bmi));
        String space = "   ";
        StringBuilder builder = new StringBuilder();
        builder.append(name).
                append(space).
                append(gioitinh).
                append(space).
                append(cc).append("m").
                append(space).append(cn).
                append("kg").append(space).
                append("BMI ").append(my_bmi);
        AddItemIntoList(builder.toString());
    }
    private void AddItemIntoList(String item){
        list.add(item);
        boNguon.notifyDataSetChanged();
    }

}