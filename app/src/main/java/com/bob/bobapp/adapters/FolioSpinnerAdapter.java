package com.bob.bobapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.SpinnerRowItem;

import java.util.List;

public class FolioSpinnerAdapter extends ArrayAdapter<SpinnerRowItem> {

    List<SpinnerRowItem> list;

    public FolioSpinnerAdapter(Context context, int resouceId, List<SpinnerRowItem> list){

        super(context,resouceId, list);

        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowview = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_row_item, parent, false);

        SpinnerRowItem rowItem = list.get(position);

        TextView txtTitle = (TextView) rowview.findViewById(R.id.title);

        txtTitle.setText(rowItem.getTitle());

        return rowview;
    }
}