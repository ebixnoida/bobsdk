package com.bob.bobapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.ProductValueBean;
import com.bob.bobapp.api.response_object.AssetAllocationResponseObject;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductNameAdapter extends RecyclerView.Adapter<ProductNameAdapter.ViewHolder> {

    private Context context;

    private Util util;

    private ArrayList<ProductValueBean> arrayList;

    public ProductNameAdapter(Context context, ArrayList<ProductValueBean> holdingArrayList) {

        this.context = context;

        this.arrayList = holdingArrayList;

        util = new Util(context);
    }

    public void updateList(ArrayList<ProductValueBean> list) {

        arrayList = list;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.product_item_name, parent, false);

        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        ProductValueBean model = arrayList.get(position);

        holder.productName.setText(model.getLabel());

        double d = Double.parseDouble(model.getPercentage());

        d = util.truncateDecimal(d).doubleValue();

        /*double d;

        if(!model.getPercentage().equals("NaN")){

            d = Double.parseDouble(model.getPercentage());

            d = util.truncateDecimal(d).doubleValue();

        }else{

            d = 0;
        }*/

        holder.productPercentage.setText(d + "%");

        if(model.getLabel().contains("Cash")) {

            holder.productPercentage.setTextColor(context.getResources().getColor(R.color.progressTintCash));

        }else if(model.getLabel().contains("Debt")) {

            holder.productPercentage.setTextColor(context.getResources().getColor(R.color.progressTintDebt));

        }else if(model.getLabel().contains("Equity")) {

            holder.productPercentage.setTextColor(context.getResources().getColor(R.color.progressTintEquity));

        }else{

            holder.productPercentage.setTextColor(context.getResources().getColor(R.color.progressTint));
        }
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView productName, productPercentage;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            productName = itemView.findViewById(R.id.tv_product_name);

            productPercentage = itemView.findViewById(R.id.tv_product_percentage);
        }
    }
}
