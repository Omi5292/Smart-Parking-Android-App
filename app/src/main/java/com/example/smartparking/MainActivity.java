package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button adminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.ed1);
        password = findViewById(R.id.ed2);
        adminlogin = findViewById(R.id.btnlogin);

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkdata();
            }
        });
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkdata(){
        boolean isValid = true;
        if (isEmpty(username)){
            Toast t = Toast.makeText(MainActivity.this,"Username is required",Toast.LENGTH_SHORT);
            t.show();
            isValid = false;
        }
        if (isEmpty(password)){
            Toast t = Toast.makeText(MainActivity.this,"Password is required",Toast.LENGTH_SHORT);
            t.show();
            isValid = false;
        }
        if (isValid){
            String usernamevalue = username.getText().toString();
            String passwordvalue = password.getText().toString();
            if (usernamevalue.equals("omkar92") && passwordvalue.equals("5292")){
                Intent i = new Intent(MainActivity.this, Homeadmin.class);
                startActivity(i);
           } else {
                Toast t = Toast.makeText(MainActivity.this,"Enter valid credentials!",Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
}
