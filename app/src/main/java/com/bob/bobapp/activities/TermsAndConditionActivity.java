package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;

public class TermsAndConditionActivity extends BaseFragment {
    private TextView txtNext;
    private Util util;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_terms_and_condition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        findView(view);
    }

    @Override
    protected void getIds(View view) {

    }

    @Override
    protected void handleListener() {

        BOBActivity.imgBack.setOnClickListener(this);
    }

    @Override
    protected void initializations() {

        BOBActivity.llMenu.setVisibility(View.GONE);

        BOBActivity.title.setText("T & C");
    }

    @Override
    protected void setIcon(Util util) {

    }

    // initialize object here...
    private void findView(View view) {

      //  txtNext=findViewById(R.id.txtNext);
        util = new Util(context);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imgBack) {
            getActivity().onBackPressed();
        }
    }
}