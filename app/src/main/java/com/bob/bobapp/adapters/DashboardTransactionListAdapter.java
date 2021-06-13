package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.AccountResponseObject;
import com.bob.bobapp.api.response_object.TransactionResponseModel;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;

public class DashboardTransactionListAdapter extends RecyclerView.Adapter<DashboardTransactionListAdapter.ViewHolder> {

    private Context context;

    private Util util;

    private ArrayList<TransactionResponseModel> transactionResponseModelArrayList;

    public DashboardTransactionListAdapter(Context context, ArrayList<TransactionResponseModel> transactionResponseModelArrayList) {

        this.transactionResponseModelArrayList = transactionResponseModelArrayList;

        this.context = context;

        util = new Util(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.dashboard_transaction_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TransactionResponseModel model = transactionResponseModelArrayList.get(position);

        String date = util.formatDate(model.getDate());

        System.out.println("DATE: " + date);

        String dateArray[] = date.split(" ");

        holder.tvDate.setText(dateArray[0]);

        holder.tvMonth.setText(dateArray[1]);

        holder.tvTransactionName.setText(model.getSecurity());

        holder.tvTransactionType.setText(model.getTransactionType());

        holder.getTvTransactionAmount.setText("₹ " + model.getAmount());
    }

    @Override
    public int getItemCount() {

        return transactionResponseModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvMonth, tvTransactionName, tvTransactionType, getTvTransactionAmount;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_transaction_date);

            tvMonth = itemView.findViewById(R.id.tv_transaction_month);

            tvTransactionName = itemView.findViewById(R.id.tv_transaction_short_name);

            tvTransactionType = itemView.findViewById(R.id.tv_transaction_type);

            getTvTransactionAmount = itemView.findViewById(R.id.tv_transaction_amount);
        }
    }
}
