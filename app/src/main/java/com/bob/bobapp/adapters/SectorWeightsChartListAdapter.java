package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;

public class SectorWeightsChartListAdapter extends RecyclerView.Adapter<SectorWeightsChartListAdapter.ViewHolder> {

    private Context context;
    private Display display;

    public SectorWeightsChartListAdapter(Context context, Display display) {
        this.context = context;
        this.display = display;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.sector_weight_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int ratio = 0;

        if (position == 0) {
            ratio = 75;
        } else if (position == 1) {
            holder.view.setBackgroundColor(context.getResources().getColor(R.color.color_purple));
            ratio = 65;
        } else if (position == 2) {
            ratio = 55;
        } else if (position == 3) {
            ratio = 45;
        } else if (position == 4) {
            ratio = 35;
        } else if (position == 5) {
            ratio = 25;
        } else if (position == 6) {
            ratio = 15;
        }

        int width = ((ratio) * (display.getWidth())) / 100;

        holder.view.getLayoutParams().width = (100 * width) / 100;
    }

    @Override
    public int getItemCount() {
        return 7;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView.findViewById(R.id.view);


        }

    }
}
