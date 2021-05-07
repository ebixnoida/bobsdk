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
import com.bob.bobapp.api.response_object.RealizedGainLoss;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RealizaedGainLossListAdapter extends RecyclerView.Adapter<RealizaedGainLossListAdapter.ViewHolder> {

    private Context context;

    private ArrayList<RealizedGainLoss> arrayList;

    public RealizaedGainLossListAdapter(Context context, ArrayList<RealizedGainLoss> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void updateList(ArrayList<RealizedGainLoss> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.realized_gain_loss_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RealizedGainLoss model = arrayList.get(position);

        holder.name.setText(model.getShortName());
        holder.folioNo.setText(model.getAccountNumber());
        holder.dateOfPurchase.setText(model.getOpenDate().substring(0, 10));
        holder.dateOfSale.setText(model.getCloseDate().substring(0, 10));
        holder.quantity.setText(model.getQuantity() + "");
        holder.purchaseRate.setText(model.getAccountNumber());
        holder.saleRate.setText(model.getPurchasePrice());

        holder.acquisitionAmount.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getCostBasis())));
        holder.shortTerm.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getShortTerm())));
        holder.longTerm.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getLongTerm())));
        holder.liquidationAmount.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getProceeds())));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, folioNo, dateOfPurchase, dateOfSale, quantity, purchaseRate, saleRate, acquisitionAmount, shortTerm, longTerm, liquidationAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            folioNo = itemView.findViewById(R.id.folioNo);
            dateOfPurchase = itemView.findViewById(R.id.dateOfPurchase);
            dateOfSale = itemView.findViewById(R.id.dateOfSale);
            quantity = itemView.findViewById(R.id.quantity);
            purchaseRate = itemView.findViewById(R.id.purchaseRate);
            saleRate = itemView.findViewById(R.id.saleRate);
            acquisitionAmount = itemView.findViewById(R.id.acquisitionAmount);
            shortTerm = itemView.findViewById(R.id.shortTerm);
            longTerm = itemView.findViewById(R.id.longTerm);
            liquidationAmount = itemView.findViewById(R.id.liquidationAmount);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {


            }
        }

    }
}
