package com.bob.bobapp.adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.response_object.TransactionResponseModel;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TransactionListAdapter extends RecyclerView.Adapter<TransactionListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TransactionResponseModel> arrayList;
    private String whichActivity;

    public TransactionListAdapter(Context context, ArrayList<TransactionResponseModel> arrayList, String whichActivity) {
        this.context = context;
        this.arrayList = arrayList;
        this.whichActivity = whichActivity;
    }

    public void updateList(ArrayList<TransactionResponseModel> arrayList) {

        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.transaction_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TransactionResponseModel model = arrayList.get(position);

        if (whichActivity.equalsIgnoreCase("TransactionActivity")) {
            holder.corporateAction.setVisibility(View.VISIBLE);
        } else {
            holder.corporateAction.setVisibility(View.GONE);
        }

        holder.name.setText(model.getSecurity());
        holder.folioNo.setText(model.getFolioNumber() + "");
        holder.unit.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getQuantity())));
        holder.nav.setText(String.valueOf(model.getTransactionRate()));
        holder.date.setText(model.getDate());
        holder.transactionType.setText(model.getTransactionType());
        holder.amount.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getAmount())));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, folioNo, unit, nav, date, transactionType, amount;
        LinearLayout corporateAction;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            folioNo = itemView.findViewById(R.id.folioNo);
            unit = itemView.findViewById(R.id.unit);
            nav = itemView.findViewById(R.id.nav);
            date = itemView.findViewById(R.id.date);
            transactionType = itemView.findViewById(R.id.transactionType);
            amount = itemView.findViewById(R.id.amount);
            corporateAction = itemView.findViewById(R.id.corporateAction);

        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

            }
        }

    }
}
