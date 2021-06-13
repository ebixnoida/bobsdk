package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.response_object.AccountResponseObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.ViewHolder> {

    private boolean isSamePosion = false;

    private ArrayList<String> selectedDataList;

    private Context context;
    private List<AccountResponseObject> arrayList;

    public AccountListAdapter(Context context, List<AccountResponseObject> holdingArrayList) {
        this.context = context;
        this.arrayList = holdingArrayList;
        selectedDataList = new ArrayList<>();
    }

    public void updateList(List<AccountResponseObject> list) {
        arrayList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.account_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final AccountResponseObject model = arrayList.get(position);

        holder.name.setText(model.getClientName());

        holder.row.setTag(model);

        if (model.isSelected()) {

            holder.radioButton.setChecked(true);

        } else {

            holder.radioButton.setChecked(false);
        }

        holder.row.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                isSamePosion = false;

                if (selectedDataList != null && selectedDataList.size() > 0) {

                    for (int i = 0; i < selectedDataList.size(); i++) {

                        if (selectedDataList.get(i).equals(String.valueOf(holder.getAdapterPosition()))) {

                            isSamePosion = true;

                            selectedDataList.remove(String.valueOf(holder.getAdapterPosition()));

                            model.setSelected(false);

                            notifyItemChanged(holder.getAdapterPosition());
                        }
                    }
                }

                if (!isSamePosion) {

                    selectedDataList.add(String.valueOf(holder.getAdapterPosition()));

                    model.setSelected(true);

                    notifyItemChanged(holder.getAdapterPosition());

                    onAccountSelect(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    TextView transact;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        RadioButton radioButton;

        LinearLayout row;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_rv_item_name);
            radioButton = itemView.findViewById(R.id.tv_rv_item_radio_button);
            row = itemView.findViewById(R.id.row);
        }

    }

    protected abstract void onAccountSelect(int position);
}
