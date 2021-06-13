package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
import com.bob.bobapp.api.response_object.TransactionResponseModel;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SIPSWPSTPDueListAdapter extends RecyclerView.Adapter<SIPSWPSTPDueListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SIPDueReportResponse> arrayList;

    public SIPSWPSTPDueListAdapter(Context context, ArrayList<SIPDueReportResponse> arrayList) {
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
        View listItem = layoutInflater.inflate(R.layout.sip_swp_stp_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        SIPDueReportResponse model = arrayList.get(position);

        holder.name.setText(model.getFundName());
        holder.folioNo.setText(model.getFolioNo());
        holder.date.setText(model.getNextInstallmentDate());
        holder.type.setText(model.getType());
        holder.amount.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getAmount())));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, folioNo, date, type, amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            folioNo = itemView.findViewById(R.id.folioNo);
            date = itemView.findViewById(R.id.date);
            type = itemView.findViewById(R.id.type);
            amount = itemView.findViewById(R.id.amount);

        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {


            }
        }

    }
}
