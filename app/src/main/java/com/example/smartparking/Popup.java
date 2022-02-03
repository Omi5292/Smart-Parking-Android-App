package com.example.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class Popup extends AppCompatActivity {
    String TAG="GenerateQRCode";
    ImageView QRimage;
    String number,inputvalue;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        QRimage = findViewById(R.id.QRimage);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.9), (int)(height*.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);

        Intent i = getIntent();
        number = i.getStringExtra("Number");

        inputvalue = number;

        if (inputvalue.length()>0){
            int smallerdimension = width<height ? width:height;
            smallerdimension = smallerdimension*3/4;
            qrgEncoder = new QRGEncoder(inputvalue,null, QRGContents.Type.TEXT,smallerdimension);
            try{
                bitmap = qrgEncoder.encodeAsBitmap();
                QRimage.setImageBitmap(bitmap);
            }
            catch (WriterException e){
                Log.v(TAG,e.toString());
            }
        }
    }
}
