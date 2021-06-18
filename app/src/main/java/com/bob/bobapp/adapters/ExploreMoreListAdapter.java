package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.DiscoverFundsActivity;

import java.util.ArrayList;

public abstract class ExploreMoreListAdapter extends RecyclerView.Adapter<ExploreMoreListAdapter.ViewHolder> {

    private Context context;

    private ArrayList<String> exploreMoreArrayList;

    public ExploreMoreListAdapter(Context context, ArrayList<String> exploreMoreArrayList) {

        this.context = context;

        this.exploreMoreArrayList = exploreMoreArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.explore_more_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title = exploreMoreArrayList.get(position);

        holder.tvTitle.setText(title);

        if(title.equalsIgnoreCase("Equity Funds")){

            holder.icon.setBackgroundResource(R.drawable.equityfunds);
        }

        if(title.equalsIgnoreCase("Debt Funds")){

            holder.icon.setBackgroundResource(R.drawable.debtfund);
        }

        if(title.equalsIgnoreCase("Tax Saving")){

            holder.icon.setBackgroundResource(R.drawable.taxsaving);
        }
    }

    @Override
    public int getItemCount() {

        return exploreMoreArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout item;

        TextView tvTitle;

        ImageView icon;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            item = itemView.findViewById(R.id.item);

            tvTitle = itemView.findViewById(R.id.tv_title);

            icon = itemView.findViewById(R.id.img_explore_more_icon);

            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.item) {

                getDetail(new DiscoverFundsActivity());
            }
        }
    }

    public abstract void getDetail(Fragment fragment);
}
