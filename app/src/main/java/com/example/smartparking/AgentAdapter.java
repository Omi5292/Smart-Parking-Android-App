package com.example.smartparking;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AgentAdapter extends RecyclerView.Adapter<AgentAdapter.Recyclervh> {
    List<AgentModel> magentlist;
    AgentModel agentModel;
    private Context mContext;

    public AgentAdapter(Context c, List<AgentModel> agentModels) {
        this.mContext = c;
        this.magentlist = agentModels;
    }

    public Recyclervh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.agentrecycler_item, parent, false);
        return new Recyclervh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclervh holder, int position) {
        agentModel = magentlist.get(position);
        holder.mName.setText("Name : "+ agentModel.getName());
        holder.mContact.setText("Contact : "+ agentModel.getContact());
        holder.mMail.setText("Mail : "+ agentModel.getMail());
    }

    @Override
    public int getItemCount() {
        return magentlist.size();
    }

    public class Recyclervh extends RecyclerView.ViewHolder {
        TextView mid, mName, mMail, mContact;
        public Recyclervh(View itemview) {
            super(itemview);
            //  mid=(TextView)itemview.findViewById(R.id.recycler_voter_id) ;
            mName = (TextView) itemview.findViewById(R.id.agentname);
            mContact = (TextView) itemview.findViewById(R.id.agentcontact);
            mMail = (TextView) itemview.findViewById(R.id.agentmail);
        }

    }
}
