package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.HoldingsActivity;
import com.bob.bobapp.activities.InsuranceActivity;
import com.bob.bobapp.activities.InvestmentMaturityActivity;
import com.bob.bobapp.activities.RealizedGainLossActivity;
import com.bob.bobapp.activities.SIPSWPSTPDueActivity;
import com.bob.bobapp.activities.TransactionActivity;

public class ReportListAdapter extends RecyclerView.Adapter<ReportListAdapter.ViewHolder> {

    private Context context;
    private String[] arrayTitle;
    private int[] arrayImage;

    public ReportListAdapter(Context context, String[] arrayTitle, int[] arrayImage) {
        this.context = context;
        this.arrayTitle = arrayTitle;
        this.arrayImage = arrayImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.report_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.img.setBackgroundDrawable(context.getResources().getDrawable(arrayImage[position]));
        holder.btn.setText(arrayTitle[position]);

    }

    @Override
    public int getItemCount() {
        return arrayImage.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            btn = itemView.findViewById(R.id.btn);

            img.setOnClickListener(this);
            btn.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.img:
                case R.id.btn:

                    switch (getAdapterPosition()) {
                        case 0:
                            Intent intentHolding = new Intent(context, HoldingsActivity.class);
                            context.startActivity(intentHolding);
                            break;
                        case 1:
                            Intent intentTransaction = new Intent(context, TransactionActivity.class);
                            intentTransaction.putExtra("WhichActivity","TransactionActivity");
                            context.startActivity(intentTransaction);
                            break;
                        case 2:
                            Intent intentDue = new Intent(context, SIPSWPSTPDueActivity.class);
                            context.startActivity(intentDue);
                            break;
                        case 3:
                            Intent intentMaturity = new Intent(context, InvestmentMaturityActivity.class);
                            context.startActivity(intentMaturity);
                            break;
                        case 4:
                            Intent intentGainLoss = new Intent(context, RealizedGainLossActivity.class);
                            context.startActivity(intentGainLoss);
                            break;
                        case 5:
                            Intent intentCorporateAction = new Intent(context, TransactionActivity.class);
                            intentCorporateAction.putExtra("WhichActivity","CorporateActionActivity");
                            context.startActivity(intentCorporateAction);

                            break;
                        case 6:
                            Intent intentInsurance = new Intent(context, InsuranceActivity.class);
                            context.startActivity(intentInsurance);
                            break;

                    }
                    break;
            }
        }
    }
}
