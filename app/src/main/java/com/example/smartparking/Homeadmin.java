package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homeadmin extends AppCompatActivity {

    CardView cvagent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeadmin);

        cvagent = findViewById(R.id.cvagent);

        cvagent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homeadmin.this,ViewAgent.class);
                startActivity(i);
            }
        });
    }
    public void client(View view) {
        Intent homeIntent = new Intent(Homeadmin.this, Addclientdetails.class);
        startActivity(homeIntent);
    }

    public void qr(View view) {
        Intent homeIntent = new Intent(Homeadmin.this, GenerateQR.class);
        startActivity(homeIntent);
    }

    public void clientlist(View view) {
        Intent homeIntent = new Intent(Homeadmin.this, ViewClient.class);
        startActivity(homeIntent);
    }

    public void guestlist(View view) {
        Intent homeIntent = new Intent(Homeadmin.this, ViewGuest.class);
        startActivity(homeIntent);
    }

    public void agent(View view) {
       // new SPdatabase(Homeadmin.this);
        Intent homeIntent = new Intent(Homeadmin.this, Addagentdetails.class);
        startActivity(homeIntent);
    }

    public void vagentd(View view) {
        Intent homeIntent = new Intent(Homeadmin.this, ViewAgent.class);
        startActivity(homeIntent);
    }

    public void logout(View view) {
        Intent homeIntent = new Intent(Homeadmin.this, Loginchoose.class);
        startActivity(homeIntent);
    }
}
