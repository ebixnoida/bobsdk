package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.AccountResponseObject;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.api.response_object.NotificationObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context context;

    private ArrayList<NotificationObject> notificationObjectArrayList;

    private ArrayList<InvestmentMaturityModel> investmentMaturityModelArrayList;

    public NotificationAdapter(Context context, ArrayList<NotificationObject> notificationObjectArrayList, ArrayList<InvestmentMaturityModel> investmentMaturityModelArrayList) {

        this.context = context;

        this.notificationObjectArrayList = notificationObjectArrayList;

        this.investmentMaturityModelArrayList = investmentMaturityModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.notification_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        NotificationObject model = notificationObjectArrayList.get(position);

        holder.tvAlertDescription.setText(model.getAlertDescription() + ": ");

        holder.tvSchemeName.setText(model.getAlertDescription());

        if(model.getAccountNumber() != null) {

            holder.tvSchemeNumber.setText(model.getAccountNumber());

        }else{

            holder.tvSchemeNumber.setText("N/A");
        }

        holder.tvAmount.setText(model.getMaturityValue());

        holder.tvDate.setText(model.getDueDate() + " " + model.getAlertType());
    }

    @Override
    public int getItemCount() {
        return notificationObjectArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAlertDescription, tvSchemeName, tvSchemeNumber, tvAmount, tvDate;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tvAlertDescription = itemView.findViewById(R.id.tv_alert_description);

            tvSchemeName = itemView.findViewById(R.id.tv_scheme_name);

            tvSchemeNumber = itemView.findViewById(R.id.tv_scheme_number);

            tvAmount = itemView.findViewById(R.id.tv_amount);

            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
