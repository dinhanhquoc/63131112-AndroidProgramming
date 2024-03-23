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

    }

}