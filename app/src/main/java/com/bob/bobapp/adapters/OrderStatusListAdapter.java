package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.OrderStatusResponse;

import java.util.ArrayList;

public class OrderStatusListAdapter extends RecyclerView.Adapter<OrderStatusListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<OrderStatusResponse> arrayList;

    public OrderStatusListAdapter(Context context, ArrayList<OrderStatusResponse> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public void updateList(ArrayList<OrderStatusResponse> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.order_status_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        OrderStatusResponse model = arrayList.get(position);

        holder.fundName.setText(model.getFundName());
        holder.name.setText(model.getClientName());
        holder.date.setText(model.getOrderDate().substring(0, 10));
        holder.amount.setText(model.getOrderAmount() + "");
        holder.status.setText(model.getOrderStatus());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fundName, name, date, amount, status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fundName = itemView.findViewById(R.id.fundName);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.amount);
            status = itemView.findViewById(R.id.status);

        }

    }
}
