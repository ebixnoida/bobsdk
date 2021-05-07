package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.IssuersResponse;

import java.util.ArrayList;

public class FundHouseAdapter extends RecyclerView.Adapter<FundHouseAdapter.ViewHolder> {
    private Context context;
    private ArrayList<IssuersResponse> fundHouseResponseArrayList;

    public FundHouseAdapter(Context context,ArrayList<IssuersResponse> fundHouseResponseArrayList) {
        this.context = context;
        this.fundHouseResponseArrayList = fundHouseResponseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asset_item_adapter, parent, false);
        return new FundHouseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.radioName.setText(fundHouseResponseArrayList.get(position).getAMCName());
    }

    @Override
    public int getItemCount() {
        return fundHouseResponseArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RadioButton radioName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioName=itemView.findViewById(R.id.radioName);
        }
    }
}
