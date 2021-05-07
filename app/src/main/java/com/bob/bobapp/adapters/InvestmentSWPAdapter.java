package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.InvestmentCartDetailsResponse;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;

public class InvestmentSWPAdapter extends RecyclerView.Adapter<InvestmentSWPAdapter.ViewHolder> {
    private Context context;
    private ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList;

    public InvestmentSWPAdapter(Context context, ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        this.context = context;
        this.investmentCartDetailsResponseArrayList = investmentCartDetailsResponseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.investment_swp_adapter, parent, false);
        return new InvestmentSWPAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FontManager.markAsIconContainer(holder.txtDelete, Util.iconFont);
        holder.txtSchemeName.setText(investmentCartDetailsResponseArrayList.get(position).getFundName());
        holder.txtAmount.setText(investmentCartDetailsResponseArrayList.get(position).getTxnAmountUnit());
        holder.txtFrequency.setText(investmentCartDetailsResponseArrayList.get(position).getFrequency());
        holder.txtDay.setText(investmentCartDetailsResponseArrayList.get(position).getSIPStartDate());
        holder.txtCurrentFundValue.setText(investmentCartDetailsResponseArrayList.get(position).getCurrentFundValue());
        holder.txtCurrentunits.setText(investmentCartDetailsResponseArrayList.get(position).getCurrentUnits());
        holder.txtInstallment.setText(investmentCartDetailsResponseArrayList.get(position).getPeriod());
    }

    @Override
    public int getItemCount() {
        return investmentCartDetailsResponseArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDelete;
        private AppCompatTextView txtSchemeName, txtAmount, txtFrequency, txtDay, txtCurrentFundValue,
                txtCurrentunits, txtWithdrawalType, txtWithdrawAmount, txtInstallment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDelete = itemView.findViewById(R.id.txtDelete);
            txtSchemeName = itemView.findViewById(R.id.txtSchemeName);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtFrequency = itemView.findViewById(R.id.txtFrequency);
            txtCurrentFundValue = itemView.findViewById(R.id.txtCurrentFundValue);
            txtDay = itemView.findViewById(R.id.txtDay);
            txtCurrentunits = itemView.findViewById(R.id.txtCurrentunits);
            txtWithdrawalType = itemView.findViewById(R.id.txtWithdrawalType);
            txtWithdrawAmount = itemView.findViewById(R.id.txtWithdrawAmount);
            txtInstallment = itemView.findViewById(R.id.txtInstallment);
        }
    }
}
