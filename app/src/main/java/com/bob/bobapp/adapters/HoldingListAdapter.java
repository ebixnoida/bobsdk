package com.bob.bobapp.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.HoldingDetailActivity;
import com.bob.bobapp.activities.InsuranceDetailActivity;
import com.bob.bobapp.api.bean.ClientHoldingObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HoldingListAdapter extends RecyclerView.Adapter<HoldingListAdapter.ViewHolder> {

    private Context context;
    private List<ClientHoldingObject> arrayList;

    public HoldingListAdapter(Context context, List<ClientHoldingObject> holdingArrayList) {
        this.context = context;
        this.arrayList = holdingArrayList;
    }

    public void updateList(List<ClientHoldingObject> list) {
        arrayList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.holdins_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ClientHoldingObject model = arrayList.get(position);

        holder.name.setText(model.getIssuer());
        holder.amount.setText(model.getValueOfCost());
        holder.gain.setText(model.getNetGain());

        if (model.getXirrAsset() != null) {
            holder.xirr.setText(model.getXirrAsset());
        } else {
            holder.xirr.setText("0.0");
        }
        holder.gainPercent.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getGainLossPercentage())) + "%");


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    TextView transact;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, amount, gain, gainPercent, xirr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            amount = itemView.findViewById(R.id.amount);
            gain = itemView.findViewById(R.id.gain);
            gainPercent = itemView.findViewById(R.id.gainPercent);
            xirr = itemView.findViewById(R.id.xirr);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, HoldingDetailActivity.class);
                    intent.putExtra("item", arrayList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });


        }

    }
}
