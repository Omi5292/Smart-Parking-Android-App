package com.example.smartparking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SPdatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "spdata.db";
    public static final String TABLE_NAME = "agentlist";
    public static final String TABLE_NAME2 = "clientlist";
    public static final String TABLE_NAME3 = "guestlist";
    //-------agent table
    public static final String COL1 = "ID";
    public static final String COL2 = "AGENT_NAME";
    public static final String COL3 = "PASSWORD";
    public static final String COL4 = "CONTACT";
    public static final String COL5 = "EMAIL";
    //-------client table
    public static final String COL6 = "CLIENT_NAME";
    public static final String COL7 = "CONTACT";
    public static final String COL8 = "FLAT_NO";
    public static final String COL9 = "VEHICLE_NO";
    //-------guest table
    public static final String COL10 = "GUEST_NAME";
    public static final String COL11 = "CONTACT";
    public static final String COL12 = "FLAT_NO";
    public static final String COL13 = "VEHICLE_NO";


    public SPdatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //-------agent table
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2+" TEXT, "+COL3+" TEXT, "+COL4+" VARCHAR, "+COL5+" VARCHAR)");
        //-------client table
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME2+" ("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL6+" TEXT, "+COL7+" VARCHAR, "+COL8+" VARCHAR, "+COL9+" VARCHAR)");
        //-------guest table
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME3+" ("+COL1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL10+" TEXT, "+COL11+" VARCHAR, "+COL12+" VARCHAR, "+COL13+" VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }

    //--agentable
    public boolean addData(String item2,String item3,String item4,String item5){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2,item2);
        cv.put(COL3,item3);
        cv.put(COL4,item4);
        cv.put(COL5,item5);
        long result = db.insert(TABLE_NAME,null,cv);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    //--clienttable
    public boolean addData2(String item6,String item7,String item8,String item9) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL6,item6);
        cv.put(COL7,item7);
        cv.put(COL8,item8);
        cv.put(COL9,item9);
        long result2 = db.insert(TABLE_NAME2, null, cv);

        if (result2 == -1) {
            return false;
        } else {
            return true;
        }
    }

    //--guestable
    public boolean addData3(String item10,String item11,String item12,String item13){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL10,item10);
        cv.put(COL11,item11);
        cv.put(COL12,item12);
        cv.put(COL13,item13);
        long result3 = db.insert(TABLE_NAME3,null,cv);

        if (result3 == -1){
            return false;
        }else {
            return true;
        }
    }
//==================================================================================================
    //==agenttable
    public ArrayList<AgentModel> getallagentdata(){
        ArrayList<AgentModel> list = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                AgentModel agentModel = new AgentModel();
                agentModel.setName(c.getString(1));
                agentModel.setContact(c.getString(3));
                agentModel.setMail(c.getString(4));
                list.add(agentModel);
            }while (c.moveToNext());
        }
        return  list;
    }
    //---clienttable
    public ArrayList<ClientModel> getallclientdata(){
        ArrayList<ClientModel> list = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                ClientModel clientModel = new ClientModel();
                clientModel.setName(c.getString(1));
                clientModel.setContact(c.getString(2));
                clientModel.setFlat(c.getString(3));
                clientModel.setVehicle(c.getString(4));
                list.add(clientModel);
            }while (c.moveToNext());
        }
        return  list;
    }
    //---guesttable
    public ArrayList<GuestModel> getallguestdata(){
        ArrayList<GuestModel> list = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME3;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                GuestModel guestModel = new GuestModel();
                guestModel.setName(c.getString(1));
                guestModel.setContact(c.getString(2));
                guestModel.setFlat(c.getString(3));
                guestModel.setVehicle(c.getString(4));
                list.add(guestModel);
            }while (c.moveToNext());
        }
        return  list;
    }
//==================================================================================================
    //---qrgeneration
    public ArrayList<QRModel> getallqrdata(){
        ArrayList<QRModel> list = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME2;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                QRModel qrModel = new QRModel();
                qrModel.setName(c.getString(1));
                qrModel.setContact(c.getString(2));
                qrModel.setFlat(c.getString(3));
                qrModel.setVehicle(c.getString(4));
                list.add(qrModel);
            }while (c.moveToNext());
        }
        return  list;
    }
//==================================================================================================
    //agent validattion---
    public boolean valid(String item2,String item3){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE AGENT_NAME=? AND PASSWORD=?",
                new String[]{item2,item3});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                mCursor.close();
                return true;
            }
        }
        return false;
    }
    //QR result matching
    public boolean matchQR(String vehicleno){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME2 + " WHERE VEHICLE_NO=?",
                new String[]{vehicleno});
        if (c != null){
            if(c.getCount() > 0){
                c.close();
                return true;
            }
        }
            return false;
    }
    //deleting data
    public boolean deleteData(String autoid) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dcursor = db.rawQuery("DELETE FROM " + TABLE_NAME + " WHERE AGENT_NAME=?"
                , new String[] {autoid});
        if (dcursor != null) {
            if(dcursor.getCount() > 0)
            {
                dcursor.close();
                return true;
            }
        }
        return false;
    }
}
