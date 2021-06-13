package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.FundTypesResponse;

import java.util.ArrayList;

public class FundTypeAdapter extends RecyclerView.Adapter<FundTypeAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<FundTypesResponse> fundTypesResponseArrayList;

    public FundTypeAdapter(Context context,ArrayList<FundTypesResponse> fundTypesResponseArrayList) {
        this.context = context;
        this.fundTypesResponseArrayList = fundTypesResponseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asset_item_adapter, parent, false);
        return new FundTypeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.radioName.setText(fundTypesResponseArrayList.get(position).getFundTypeName());
    }

    @Override
    public int getItemCount() {
        return fundTypesResponseArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RadioButton radioName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioName=itemView.findViewById(R.id.radioName);
        }
    }
}
