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

public class InvestmentRedeemAdapter extends RecyclerView.Adapter<InvestmentRedeemAdapter.ViewHolder>
{
    private Context context;
    ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList;

    public InvestmentRedeemAdapter(Context context, ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        this.context = context;
        this.investmentCartDetailsResponseArrayList = investmentCartDetailsResponseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.investment_redeem_adapter, parent, false);
        return new InvestmentRedeemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FontManager.markAsIconContainer( holder.txtDelete, Util.iconFont);

        holder.txtSchemeName.setText(investmentCartDetailsResponseArrayList.get(position).getFundName());
        holder.txtAmount.setText(investmentCartDetailsResponseArrayList.get(position).getTxnAmountUnit());
        holder.txtCurrentFundValue.setText(investmentCartDetailsResponseArrayList.get(position).getCurrentFundValue());
        holder.txtCurrentunits.setText(investmentCartDetailsResponseArrayList.get(position).getCurrentUnits());
        holder.txtOrderBasis.setText(investmentCartDetailsResponseArrayList.get(position).getAmountOrUnit());
        holder.txtSwitchAccount.setText(investmentCartDetailsResponseArrayList.get(position).getTargetFundCode());

    }

    @Override
    public int getItemCount() {
        return investmentCartDetailsResponseArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDelete;
        private AppCompatTextView txtSchemeName,txtAmount,txtCurrentFundValue,txtCurrentunits,txtOrderBasis,txtSwitchAccount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDelete=itemView.findViewById(R.id.txtDelete);
            txtSchemeName=itemView.findViewById(R.id.txtSchemeName);
            txtAmount=itemView.findViewById(R.id.txtAmount);
            txtCurrentFundValue=itemView.findViewById(R.id.txtCurrentFundValue);
            txtCurrentunits=itemView.findViewById(R.id.txtCurrentunits);
            txtOrderBasis=itemView.findViewById(R.id.txtOrderBasis);
            txtSwitchAccount=itemView.findViewById(R.id.txtSwitchAccount);
        }
    }
}
