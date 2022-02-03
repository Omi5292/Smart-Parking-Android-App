package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GenerateQR extends AppCompatActivity {

    RecyclerView recyclerView;
    SPdatabase dbopenhelper;
    List<QRModel> qrModelList;
    QRAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_q_r);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_qr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        qrModelList = new ArrayList<>();

        dbopenhelper = new SPdatabase(this);
        qrModelList = dbopenhelper.getallqrdata();

        adapter = new QRAdapter(this,qrModelList);
        recyclerView.setAdapter(adapter);
    }
}
