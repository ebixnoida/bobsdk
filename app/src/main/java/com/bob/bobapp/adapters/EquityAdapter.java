package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.lstRecommandationEquity;


import java.util.ArrayList;

public class EquityAdapter extends RecyclerView.Adapter<EquityAdapter.ViewHolder> {
    private Context context;
    private ArrayList<lstRecommandationEquity> lstRecommandationEquityArrayList;

    public EquityAdapter(Context context, ArrayList<lstRecommandationEquity> lstRecommandationEquityArrayList) {
        this.context = context;
        this.lstRecommandationEquityArrayList = lstRecommandationEquityArrayList;
    }

    public void updateList(ArrayList<lstRecommandationEquity> list) {
        lstRecommandationEquityArrayList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.discover_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtFundName.setText(lstRecommandationEquityArrayList.get(position).getFundName());
        holder.txtThreeMonth.setText(lstRecommandationEquityArrayList.get(position).getReturnIn3Month());
        holder.txtOneYear.setText(lstRecommandationEquityArrayList.get(position).getReturnIn1Year());
        holder.txtSixMonth.setText(lstRecommandationEquityArrayList.get(position).getReturnIn6Month());
    }

    @Override
    public int getItemCount() {
        return lstRecommandationEquityArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtFundName, txtSixMonth, txtThreeMonth, txtOneYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFundName = itemView.findViewById(R.id.txtFundName);
            txtSixMonth = itemView.findViewById(R.id.txtSixMonth);
            txtThreeMonth = itemView.findViewById(R.id.txtThreeMonth);
            txtOneYear = itemView.findViewById(R.id.txtOneYear);
        }
    }
}
