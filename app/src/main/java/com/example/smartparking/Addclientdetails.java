package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addclientdetails extends AppCompatActivity {

    EditText name,contact,flat,vehicle;
    Button btnsubclient;
    SPdatabase mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclientdetails);

        name = (EditText) findViewById(R.id.edname);
        contact = (EditText) findViewById(R.id.edcon);
        flat = (EditText) findViewById(R.id.edflat);
        vehicle = (EditText) findViewById(R.id.edvehi);
        btnsubclient = findViewById(R.id.btnsubclient);
        mDatabaseHelper = new SPdatabase(this);

        btnsubclient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameEntry = name.getText().toString();
                String contactEntry = contact.getText().toString();
                String flatEntry = flat.getText().toString();
                String vehicleEntry = vehicle.getText().toString();
                if (nameEntry.length() != 0 && contactEntry.length() == 10 && flatEntry.length() != 0 && vehicleEntry.length() != 0){
                    AddData2(nameEntry,contactEntry,flatEntry,vehicleEntry);
                    name.setText("");
                    contact.setText("");
                    flat.setText("");
                    vehicle.setText("");
                }else {
                    Toast.makeText(Addclientdetails.this,"Plz enter valid credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void AddData2(String nameEntry,String contactEntry,String flatEntry,String vehicleEntry){
        boolean insertData = mDatabaseHelper.addData2(nameEntry,contactEntry,flatEntry,vehicleEntry);
        if (insertData == true){
            Toast.makeText(Addclientdetails.this,"Client registered successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(Addclientdetails.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
}
