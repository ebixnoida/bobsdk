package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.SourceOFWealth;

import java.util.ArrayList;

public class WealthSourceAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SourceOFWealth>sourceOFWealthArrayList;

    public WealthSourceAdapter(Context context, ArrayList<SourceOFWealth> sourceOFWealthArrayList) {
        this.context = context;
        this.sourceOFWealthArrayList = sourceOFWealthArrayList;
    }

    @Override
    public int getCount() {
        return sourceOFWealthArrayList.size();
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
        convertView=mInflater.inflate(R.layout.dropdown_item, parent, false);
        AppCompatTextView txtName=convertView.findViewById(R.id.txtName);
        txtName.setText(sourceOFWealthArrayList.get(position).getName());
        return convertView;
    }
}
