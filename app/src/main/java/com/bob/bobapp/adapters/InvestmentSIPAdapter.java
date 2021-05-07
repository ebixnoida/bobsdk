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

public class InvestmentSIPAdapter extends RecyclerView.Adapter<InvestmentSIPAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList;

    public InvestmentSIPAdapter(Context context,ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        this.context = context;
        this.investmentCartDetailsResponseArrayList = investmentCartDetailsResponseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.investment_sip_adapter, parent, false);
        return new InvestmentSIPAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       FontManager.markAsIconContainer( holder.txtDelete, Util.iconFont);

        holder.txtSchemeName.setText(investmentCartDetailsResponseArrayList.get(position).getFundName());
        holder.txtAmount.setText(investmentCartDetailsResponseArrayList.get(position).getTxnAmountUnit());
        holder.txtInstallment.setText(investmentCartDetailsResponseArrayList.get(position).getPeriod());
        holder.txtFrequency.setText(investmentCartDetailsResponseArrayList.get(position).getFrequency());
        holder.txtDay.setText(investmentCartDetailsResponseArrayList.get(position).getSIPStartDate());
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDelete;
        private AppCompatTextView txtSchemeName,txtAmount,txtInstallment,txtFrequency,txtDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDelete=itemView.findViewById(R.id.txtDelete);
            txtSchemeName=itemView.findViewById(R.id.txtSchemeName);
            txtAmount=itemView.findViewById(R.id.txtAmount);
            txtInstallment=itemView.findViewById(R.id.txtInstallment);
            txtFrequency=itemView.findViewById(R.id.txtFrequency);
            txtDay=itemView.findViewById(R.id.txtDay);
        }

    }
}
