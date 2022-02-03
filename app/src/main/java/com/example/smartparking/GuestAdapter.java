package com.example.smartparking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.Recyclervh> {
    List<GuestModel> mguestlist;
    GuestModel guestModel;
    private Context mContext;

    public GuestAdapter(Context c, List<GuestModel> guestModels) {
        this.mContext = c;
        this.mguestlist = guestModels;
    }
    @Override
    public GuestAdapter.Recyclervh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.guestrecycler_item, parent, false);
        return new Recyclervh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestAdapter.Recyclervh holder, int position) {
        guestModel = mguestlist.get(position);
        holder.mName.setText("Name : "+ guestModel.getName());
        holder.mContact.setText("Contact : "+ guestModel.getContact());
        holder.mFlat.setText("Flat No: "+ guestModel.getFlat());
        holder.mVehicle.setText("Vehicle No : "+ guestModel.getVehicle());
    }

    @Override
    public int getItemCount() {
        return mguestlist.size();
    }

    public class Recyclervh extends RecyclerView.ViewHolder {
        TextView mid, mName, mContact, mFlat, mVehicle;
        public Recyclervh(View itemview) {
            super(itemview);
            mName = (TextView) itemview.findViewById(R.id.guestname);
            mContact = (TextView) itemview.findViewById(R.id.guestcontact);
            mFlat = (TextView) itemview.findViewById(R.id.guestflat);
            mVehicle = (TextView) itemview.findViewById(R.id.guestvehi);
        }

    }
}
