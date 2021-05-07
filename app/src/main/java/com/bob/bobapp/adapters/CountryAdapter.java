package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.Country;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter
{
    private Context context;

    public CountryAdapter(Context context, ArrayList<Country> countryArrayList) {
        this.context = context;
        this.countryArrayList = countryArrayList;
    }

    private ArrayList<Country>countryArrayList;

    @Override
    public int getCount() {
        return countryArrayList.size();
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
        txtName.setText(countryArrayList.get(position).getName());
        return convertView;
    }
}
