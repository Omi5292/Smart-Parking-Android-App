package com.example.smartparking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.Recyclervh> {
    List<ClientModel> mclientlist;
    ClientModel clientModel;
    private Context mContext;

    public ClientAdapter(Context c, List<ClientModel> clientModels) {
        this.mContext = c;
        this.mclientlist = clientModels;
    }
    public Recyclervh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.clientrecycler_item, parent, false);
        return new Recyclervh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclervh holder, int position) {
        clientModel = mclientlist.get(position);
        holder.mName.setText("Name : "+ clientModel.getName());
        holder.mContact.setText("Contact : "+ clientModel.getContact());
        holder.mFlat.setText("Flat No: "+ clientModel.getFlat());
        holder.mVehicle.setText("Vehicle No : "+ clientModel.getVehicle());
    }

    @Override
    public int getItemCount() {
        return mclientlist.size();
    }

    public class Recyclervh extends RecyclerView.ViewHolder {
        TextView mid, mName, mContact, mFlat, mVehicle;
        public Recyclervh(View itemview) {
            super(itemview);
            mName = (TextView) itemview.findViewById(R.id.clientname);
            mContact = (TextView) itemview.findViewById(R.id.clientcontact);
            mFlat = (TextView) itemview.findViewById(R.id.clientflat);
            mVehicle = (TextView) itemview.findViewById(R.id.clientvehi);
        }

    }
}
