package com.bob.bobapp.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.LstRecommandationDebt;

import java.util.ArrayList;

public class DiscoverFundListAdapter extends RecyclerView.Adapter<DiscoverFundListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LstRecommandationDebt> lstRecommandationDebtArrayList;

    public DiscoverFundListAdapter(Context context, ArrayList<LstRecommandationDebt> lstRecommandationDebtArrayList) {
        this.context = context;
        this.lstRecommandationDebtArrayList = lstRecommandationDebtArrayList;
    }

    public void updateList(ArrayList<LstRecommandationDebt> list) {
        lstRecommandationDebtArrayList = list;
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
        holder.txtFundName.setText(lstRecommandationDebtArrayList.get(position).getFundName());
        holder.txtThreeMonth.setText(lstRecommandationDebtArrayList.get(position).getReturnIn3Month());
        holder.txtOneYear.setText(lstRecommandationDebtArrayList.get(position).getReturnIn1Year());
        holder.txtSixMonth.setText(lstRecommandationDebtArrayList.get(position).getReturnIn6Month());
    }

    @Override
    public int getItemCount() {
        return lstRecommandationDebtArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
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
