package com.bob.bobapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.DiscoverFundsActivity;

import java.util.ArrayList;

public class ExploreMoreListAdapter extends RecyclerView.Adapter<ExploreMoreListAdapter.ViewHolder> {

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
    }

    @Override
    public int getItemCount() {

        return exploreMoreArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout item;

        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            item = itemView.findViewById(R.id.item);

            tvTitle = itemView.findViewById(R.id.tv_title);

            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.item:

                    Intent intent= new Intent(context, DiscoverFundsActivity.class);

                    context.startActivity(intent);

                    break;
            }
        }
    }
}
