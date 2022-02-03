package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Custlogin extends AppCompatActivity {

    EditText username, password;
    Button clientlogin;
    SPdatabase mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custlogin);

        username = findViewById(R.id.ed3);
        password = findViewById(R.id.ed4);
        clientlogin = findViewById(R.id.btncust);
        mDatabaseHelper = new SPdatabase(this);

        clientlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = username.getText().toString();
                String passEntry = password.getText().toString();
                if (newEntry.length() != 0 && passEntry.length() != 0){
                    valid(newEntry,passEntry);
                    username.setText("");
                    password.setText("");
                }else {
                    Toast.makeText(Custlogin.this,"Plz enter the details",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

            public void valid(String newEntry,String passEntry){
            boolean insertData = mDatabaseHelper.valid(newEntry,passEntry);
            if (insertData == true){
                Toast.makeText(Custlogin.this,"Login successfull",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Custlogin.this, Homepage.class);
                startActivity(i);
            }else {
                Toast.makeText(Custlogin.this,"Oops!, you have not registered",Toast.LENGTH_SHORT).show();
            }
    }
}
