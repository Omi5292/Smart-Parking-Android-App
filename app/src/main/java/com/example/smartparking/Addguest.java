package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addguest extends AppCompatActivity {

    EditText gname,gcontact,gflat,gvehicle;
    Button btnsubguest;
    SPdatabase mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addguest);

        gname = (EditText) findViewById(R.id.edguestname);
        gcontact = (EditText) findViewById(R.id.edguestcon);
        gflat = (EditText) findViewById(R.id.edguestflat);
        gvehicle = (EditText) findViewById(R.id.edguestvehi);
        btnsubguest = findViewById(R.id.btnsubguest);
        mDatabaseHelper = new SPdatabase(this);

        btnsubguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gnameEntry = gname.getText().toString();
                String gcontactEntry = gcontact.getText().toString();
                String gflatEntry = gflat.getText().toString();
                String gvehicleEntry = gvehicle.getText().toString();
                if (gnameEntry.length() != 0 && gcontactEntry.length() == 10 && gflatEntry.length() != 0 && gvehicleEntry.length() != 0){
                    AddData3(gnameEntry,gcontactEntry,gflatEntry,gvehicleEntry);
                    gname.setText("");
                    gcontact.setText("");
                    gflat.setText("");
                    gvehicle.setText("");
                }else {
                    Toast.makeText(Addguest.this,"Plz enter valid credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void AddData3(String gnameEntry,String gcontactEntry,String gflatEntry,String gvehicleEntry){
        boolean insertData = mDatabaseHelper.addData3(gnameEntry,gcontactEntry,gflatEntry,gvehicleEntry);
        if (insertData == true){
            Toast.makeText(Addguest.this,"Guest registered successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(Addguest.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
}
