package com.example.gemyni.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Image> images = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Add data
        String[] names = {"Lina", "Luna", "PA", "Puck", "QoP", "WR"};
        int[] ids = {R.drawable.lina, R.drawable.luna, R.drawable.pa, R.drawable.puck, R.drawable.qop, R.drawable.wr};


        for (int i = 0; i < 6; i++) {
            Image tmp = new Image();
            tmp.setName(names[i]);
            tmp.setId(ids[i]);

            images.add(tmp);
        }


        recyclerView = findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CustomAdapter(this, images);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
