package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewAgent extends AppCompatActivity {

RecyclerView recyclerView;
SPdatabase dbopenhelper;
List<AgentModel> agentlist;
AgentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_agent);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        agentlist = new ArrayList<>();

        dbopenhelper = new SPdatabase(this);
        agentlist = dbopenhelper.getallagentdata();

        adapter = new AgentAdapter(this,agentlist);
        recyclerView.setAdapter(adapter);
    }
}
