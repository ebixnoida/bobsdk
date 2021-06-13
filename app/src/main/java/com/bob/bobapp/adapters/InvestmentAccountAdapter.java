package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.AccountsResponse;

import java.util.ArrayList;

public class InvestmentAccountAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AccountsResponse> accountsResponseArrayList;

    public InvestmentAccountAdapter(Context context,ArrayList<AccountsResponse> accountsResponseArrayList) {
        this.context = context;
        this.accountsResponseArrayList = accountsResponseArrayList;
    }

    @Override
    public int getCount() {
        return accountsResponseArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=mInflater.inflate(R.layout.investment_account_item, parent, false);
        AppCompatTextView txtInvestmentAccount=convertView.findViewById(R.id.txtInvestmentAccount);
        txtInvestmentAccount.setText(accountsResponseArrayList.get(position).getClientName());
        return convertView;
    }
}
