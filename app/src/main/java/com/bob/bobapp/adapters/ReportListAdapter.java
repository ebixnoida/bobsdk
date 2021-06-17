package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.BuySIPRedeemSwitchActivity;
import com.bob.bobapp.activities.HoldingsActivity;
import com.bob.bobapp.activities.InsuranceActivity;
import com.bob.bobapp.activities.InvestmentMaturityActivity;
import com.bob.bobapp.activities.RealizedGainLossActivity;
import com.bob.bobapp.activities.SIPSWPSTPDueActivity;
import com.bob.bobapp.activities.TransactionActivity;
import com.bob.bobapp.utility.IntentKey;

public abstract class ReportListAdapter extends RecyclerView.Adapter<ReportListAdapter.ViewHolder> {

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

            int id = view.getId();
            if (id == R.id.img || id == R.id.btn) {
                switch (getAdapterPosition()) {
                    case 0:
                        getDetail(new HoldingsActivity());
                        break;
                    case 1:
                        Bundle args = new Bundle();

                        args.putString("WhichActivity", "TransactionActivity");

                        Fragment fragment = new TransactionActivity();

                        fragment.setArguments(args);

                        getDetail(fragment);
                        break;
                    case 2:
                        getDetail(new SIPSWPSTPDueActivity());
                        break;
                    case 3:
                        getDetail(new InvestmentMaturityActivity());
                        break;
                    case 4:
                        getDetail(new RealizedGainLossActivity());
                        break;
                    case 5:

                        Bundle argsNew = new Bundle();

                        argsNew.putString("WhichActivity", "CorporateActionActivity");

                        Fragment fragmentNew = new TransactionActivity();

                        fragmentNew.setArguments(argsNew);

                        getDetail(fragmentNew);

                        break;
                    case 6:
                        getDetail(new InsuranceActivity());
                        break;

                }
            }
        }
    }

    public abstract void getDetail(Fragment fragment);
}
