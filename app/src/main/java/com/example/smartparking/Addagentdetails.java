package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addagentdetails extends AppCompatActivity {

    EditText edt,pass,con,email;
    Button btnsubagent;
    SPdatabase mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addagentdetails);

        edt = (EditText) findViewById(R.id.editText2);
        pass = (EditText) findViewById(R.id.text_password);
        con = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.mail);
        btnsubagent = findViewById(R.id.btnsubagent);
        mDatabaseHelper = new SPdatabase(this);


        btnsubagent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = edt.getText().toString();
                String passEntry = pass.getText().toString();
                String phoneEntry = con.getText().toString();
                String mailEntry = email.getText().toString();
                if (newEntry.length() != 0 && passEntry.length() != 0 && phoneEntry.length() == 10){
                    AddData(newEntry,passEntry,phoneEntry,mailEntry);
                    edt.setText("");
                    pass.setText("");
                    con.setText("");
                    email.setText("");
                } else {
                    Toast.makeText(Addagentdetails.this,"Plz enter valid credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String newEntry,String passEntry,String phoneEntry,String mailEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry,passEntry,phoneEntry,mailEntry);
        if (insertData == true){
            Toast.makeText(Addagentdetails.this,"Agent registered successfully",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(Addagentdetails.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }
}
