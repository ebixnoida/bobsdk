package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.InsuranceDetailActivity;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;

import java.util.ArrayList;

public class InsuranceListAdapter extends RecyclerView.Adapter<InsuranceListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LifeInsuranceResponse> arrayList;

    public InsuranceListAdapter(Context context, ArrayList<LifeInsuranceResponse> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.insurance_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        LifeInsuranceResponse model = arrayList.get(position);
        holder.name.setText(model.getPolicyName());
        holder.amount.setText(model.getAmount() + "");
        holder.date.setText(model.getPremiumstdate().substring(0, 10));
        holder.premiumAmount.setText(model.getPremiumamount() + "");


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, amount, date, premiumAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
            date = itemView.findViewById(R.id.date);
            premiumAmount = itemView.findViewById(R.id.premiumAmount);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, InsuranceDetailActivity.class);
                    intent.putExtra("item", arrayList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });

        }

    }
}
