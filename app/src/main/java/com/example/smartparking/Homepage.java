package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void scanc(View view) {
        Intent homeIntent = new Intent(Homepage.this, Scanclient.class);
        startActivity(homeIntent);
    }

    public void addguest(View view) {
        Intent homeIntent = new Intent(Homepage.this, Addguest.class);
        startActivity(homeIntent);
    }

    public void clientlist(View view) {
        Intent homeIntent = new Intent(Homepage.this, ViewClient.class);
        startActivity(homeIntent);
    }

    public void logout(View view) {
        Intent homeIntent = new Intent(Homepage.this, Loginchoose.class);
        startActivity(homeIntent);
    }
}
