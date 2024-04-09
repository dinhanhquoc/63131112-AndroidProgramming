package com.example.th_usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapAdapter landScapAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerland);
        RecyclerView.LayoutManager layoutlinear = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutlinear);
        landScapAdapter = new LandScapAdapter(this,recyclerViewDatas);
        recyclerView.setAdapter(landScapAdapter);

    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<>();
        LandScape lc1 = new LandScape("Hinh1","Hinh 1 Caption");
        LandScape lc2 = new LandScape("Hinh2","Hinh 2 Caption");
        LandScape lc3 = new LandScape("Hinh3","Hinh 3 Caption");
        return dsDuLieu;
    }


}