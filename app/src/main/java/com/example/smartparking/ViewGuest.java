package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewGuest extends AppCompatActivity {
    RecyclerView recyclerView;
    SPdatabase dbopenhelper;
    List<GuestModel> guestlist;
    GuestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_guest);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_guest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        guestlist = new ArrayList<>();

        dbopenhelper = new SPdatabase(this);
        guestlist = dbopenhelper.getallguestdata();

        adapter = new GuestAdapter(this,guestlist);
        recyclerView.setAdapter(adapter);
    }
}
