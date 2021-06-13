package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.BankAccountResponse;

import java.util.ArrayList;

public class BankAccountAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<BankAccountResponse>bankAccountResponseArrayList;

    public BankAccountAdapter(Context context, ArrayList<BankAccountResponse> bankAccountResponseArrayList) {
        this.context = context;
        this.bankAccountResponseArrayList = bankAccountResponseArrayList;
    }

    @Override
    public int getCount() {
        return bankAccountResponseArrayList.size();
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
        txtInvestmentAccount.setText(bankAccountResponseArrayList.get(position).getBankName());
        return convertView;
    }
}
