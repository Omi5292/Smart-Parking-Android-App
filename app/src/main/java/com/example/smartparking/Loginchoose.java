package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Loginchoose extends AppCompatActivity {
    ImageButton about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginchoose);
        about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void login(View view) {
        Intent homeIntent = new Intent(Loginchoose.this, MainActivity.class);
        startActivity(homeIntent);
    }

    public void cust(View view) {
        Intent homeIntent = new Intent(Loginchoose.this, Custlogin.class);
        startActivity(homeIntent);
    }

    public void openDialog(){
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.show(getSupportFragmentManager(),"About_info");
    }
}
