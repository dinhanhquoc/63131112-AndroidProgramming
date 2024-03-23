package ntu.MSSV63131112;

import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setUpView();
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
        list = new ArrayList<>();
    }
}