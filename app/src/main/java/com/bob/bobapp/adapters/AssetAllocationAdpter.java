package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.AssetAllocationResponseObject;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AssetAllocationAdpter extends RecyclerView.Adapter<AssetAllocationAdpter.ViewHolder> {

    private Context context;

    private Util util;

    private ArrayList<AssetAllocationResponseObject> arrayList;

    public AssetAllocationAdpter(Context context, ArrayList<AssetAllocationResponseObject> holdingArrayList) {

        this.context = context;

        this.arrayList = holdingArrayList;

        util = new Util(context);
    }

    public void updateList(ArrayList<AssetAllocationResponseObject> list) {

        arrayList = list;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.asset_allocation_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        AssetAllocationResponseObject model = arrayList.get(position);

        holder.assetName.setText(model.getAssetClassName());

        holder.assetValue.setText(model.getValueAmount());

        double d = Double.parseDouble(model.getValuePercentage());

        d = util.truncateDecimal(d).doubleValue();

        holder.suggestedValue.setText(String.valueOf(d) + "%");

        int progress = (int) d;

        holder.progressBar.setProgress(progress);

        if(model.getAssetClassName().equalsIgnoreCase("Equity")){

            holder.progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_bar_equity));

            holder.suggestedValue.setTextColor(Color.parseColor("#F26522"));

        }else if(model.getAssetClassName().equalsIgnoreCase("Debt")){

            holder.progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_bar_debt));

            holder.suggestedValue.setTextColor(Color.parseColor("#152B75"));

        }else if(model.getAssetClassName().equalsIgnoreCase("Cash")){

            holder.progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_bar_cash));

            holder.suggestedValue.setTextColor(Color.parseColor("#ED1323"));

        }else{

            holder.progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_bar_background));

            holder.suggestedValue.setTextColor(Color.parseColor("#b71c1c"));
        }
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView assetName, assetValue, suggestedValue;

        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            assetName = itemView.findViewById(R.id.tv_asset_name);

            assetValue = itemView.findViewById(R.id.tv_asset_value);

            suggestedValue = itemView.findViewById(R.id.tv_suggested_value);

            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
}
