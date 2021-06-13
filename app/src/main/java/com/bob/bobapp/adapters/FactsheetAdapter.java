package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.FactsheetSchemePerformanceData;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FactsheetAdapter extends RecyclerView.Adapter<FactsheetAdapter.ViewHolder> {

    private ArrayList<FactsheetSchemePerformanceData> arrayList;

    private Context context;

    private Util util;

    public FactsheetAdapter(Context context, ArrayList<FactsheetSchemePerformanceData> arrayList) {

        this.context = context;

        this.arrayList = arrayList;

        util = new Util(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.factsheet_adapter_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FactsheetSchemePerformanceData factsheetSchemePerformanceData = arrayList.get(position);

        holder.tvColumnOne.setText(factsheetSchemePerformanceData.getColumnOne());

        holder.tvColumnTwo.setText(factsheetSchemePerformanceData.getColumnTwo() + "%");

        holder.tvColumnThree.setText(factsheetSchemePerformanceData.getColumnThree() + "%");
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvColumnOne, tvColumnTwo, tvColumnThree;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tvColumnOne = itemView.findViewById(R.id.tv_column_one);

            tvColumnTwo = itemView.findViewById(R.id.tv_column_two);

            tvColumnThree = itemView.findViewById(R.id.tv_column_three);
        }
    }
}
