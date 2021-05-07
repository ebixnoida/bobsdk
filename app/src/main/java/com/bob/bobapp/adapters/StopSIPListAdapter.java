package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.OrderStatusResponse;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;

import java.util.ArrayList;

public class StopSIPListAdapter extends RecyclerView.Adapter<StopSIPListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SIPDueReportResponse> arrayList;

    public StopSIPListAdapter(Context context, ArrayList<SIPDueReportResponse> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void updateList(ArrayList<SIPDueReportResponse> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.stop_sip_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SIPDueReportResponse model = arrayList.get(position);

        holder.name.setText(model.getFundName());
        holder.amount.setText(model.getAmount() + "");
        holder.folioNo.setText(model.getFolioNo());
        holder.frequency.setText(model.getFrequency());
        holder.endDate.setText(model.getEndDate().substring(0,10));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, amount, folioNo, frequency, endDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
            folioNo = itemView.findViewById(R.id.folioNo);
            frequency = itemView.findViewById(R.id.frequency);
            endDate = itemView.findViewById(R.id.endDate);

        }

    }
}
