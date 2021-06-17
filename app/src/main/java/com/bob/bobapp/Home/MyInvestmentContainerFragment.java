package com.bob.bobapp.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bob.bobapp.R;
import com.bob.bobapp.activities.PortfolioAnalytics;

public class MyInvestmentContainerFragment extends BaseContainerFragment {

    private boolean mIsViewInited;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.container_fragment, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        Log.e("test", "tab 1 container on activity created");

        if (!mIsViewInited) {

            mIsViewInited = true;

            initView();
        }
    }

    private void initView() {

        replaceFragment(new PortfolioAnalytics(), false);
    }
}