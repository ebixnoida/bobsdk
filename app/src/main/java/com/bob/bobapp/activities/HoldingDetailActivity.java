package com.bob.bobapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;
import com.google.gson.Gson;

import java.text.DecimalFormat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HoldingDetailActivity extends BaseFragment {

    private TextView name, amount, gain, gainPercent, xirr, cost, marketValue, folioNo, unit;

    private ClientHoldingObject model;

    private Context context;

    private Util util;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.holding_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        name = view.findViewById(R.id.name);
        amount = view.findViewById(R.id.amount);
        gain = view.findViewById(R.id.gain);
        gainPercent = view.findViewById(R.id.gainPercent);
        xirr = view.findViewById(R.id.xirr);
        cost = view.findViewById(R.id.cost);
        marketValue = view.findViewById(R.id.marketValue);
        folioNo = view.findViewById(R.id.folioNo);
        unit = view.findViewById(R.id.unit);


    }

    @Override
    public void handleListener() {

        BOBActivity.imgBack.setOnClickListener(this);

    }

    @Override
    public void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("Detail");

        if(getArguments() != null) {

            String response = getArguments().getString("item");

            model = new Gson().fromJson(response, ClientHoldingObject.class);
        }

        name.setText(model.getIssuer());
        amount.setText(model.getValueOfCost());
        gain.setText(model.getNetGain());

        if (model.getXirrAsset() != null) {
            xirr.setText(model.getXirrAsset());
        } else {
            xirr.setText("0.0");
        }
        gainPercent.setText(new DecimalFormat("##.##").format(Double.valueOf(model.getGainLossPercentage())) + "%");

        cost.setText(model.getCostofInvestment() + "");
        marketValue.setText(model.getMarketValue() + "");
        folioNo.setText(model.getFolioNumber() + "");
        unit.setText(model.getCurrentUnits() + "");


    }

    @Override
    public void setIcon(Util util) {

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.menu) {
            getActivity().onBackPressed();
        }else if (view.getId() == R.id.imgBack) {
            getActivity().onBackPressed();
        }

    }
}
