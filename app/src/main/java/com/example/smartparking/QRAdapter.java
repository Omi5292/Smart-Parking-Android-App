package com.example.smartparking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QRAdapter extends RecyclerView.Adapter<QRAdapter.Recyclervh> {

    List<QRModel> mqrlist;
    QRModel qrModel;
    private Context mContext;

    public QRAdapter(Context c, List<QRModel> qrModels) {
        this.mContext = c;
        this.mqrlist = qrModels;
    }

    public Recyclervh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.qrrecycler_item, parent, false);
        return new Recyclervh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclervh holder, final int position) {
        qrModel = mqrlist.get(position);
        holder.mName.setText("Name : "+ qrModel.getName());
        holder.mContact.setText("Contact : "+ qrModel.getContact());
        holder.mFlat.setText("Flat No: "+ qrModel.getFlat());
        holder.mVehicle.setText("Vehicle No : "+ qrModel.getVehicle());
        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrModel=mqrlist.get(position);
                String vehicleno = qrModel.getVehicle();
                Intent i = new Intent(mContext,Popup.class);
                i.putExtra("Number",vehicleno);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mqrlist.size();
    }

    public class Recyclervh extends RecyclerView.ViewHolder {
        TextView mName, mContact, mFlat, mVehicle;
        View mview;
        public Recyclervh(View itemview) {
            super(itemview);
            mName = (TextView) itemview.findViewById(R.id.QRname);
            mContact = (TextView) itemview.findViewById(R.id.QRcontact);
            mFlat = (TextView) itemview.findViewById(R.id.QRtflat);
            mVehicle = (TextView) itemview.findViewById(R.id.QRvehi);
            mview=itemview;
        }

    }
}
