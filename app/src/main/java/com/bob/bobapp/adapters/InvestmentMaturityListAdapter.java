package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class InvestmentMaturityListAdapter extends RecyclerView.Adapter<InvestmentMaturityListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<InvestmentMaturityModel> arrayList;

    public InvestmentMaturityListAdapter(Context context, ArrayList<InvestmentMaturityModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.investment_maturity_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        InvestmentMaturityModel model = arrayList.get(position);

        holder.name.setText(model.getSchName());
        holder.folioNo.setText("---");
        holder.maturityDate.setText(model.getDate());
        holder.currentValue.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getCostOnInvestment())));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, folioNo, currentValue, maturityDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            folioNo = itemView.findViewById(R.id.folioNo);
            currentValue = itemView.findViewById(R.id.currentValue);
            maturityDate = itemView.findViewById(R.id.maturityDate);


        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

            }
        }

    }
}
