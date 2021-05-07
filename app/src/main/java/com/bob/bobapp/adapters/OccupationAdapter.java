package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.Occupation;

import java.util.ArrayList;

public class OccupationAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Occupation>occupationArrayList;

    public OccupationAdapter(Context context, ArrayList<Occupation> occupationArrayList) {
        this.context = context;
        this.occupationArrayList = occupationArrayList;
    }

    @Override
    public int getCount() {
        return occupationArrayList.size();
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
        txtName.setText(occupationArrayList.get(position).getName());
        return convertView;
    }
}
