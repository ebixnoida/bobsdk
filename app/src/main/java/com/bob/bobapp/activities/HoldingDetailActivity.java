package com.bob.bobapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;

import java.text.DecimalFormat;

public class HoldingDetailActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, name, amount, gain, gainPercent, xirr, cost, marketValue, folioNo, unit;


    private ClientHoldingObject model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.holding_detail);
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);

        name = findViewById(R.id.name);
        amount = findViewById(R.id.amount);
        gain = findViewById(R.id.gain);
        gainPercent = findViewById(R.id.gainPercent);
        xirr = findViewById(R.id.xirr);
        cost = findViewById(R.id.cost);
        marketValue = findViewById(R.id.marketValue);
        folioNo = findViewById(R.id.folioNo);
        unit = findViewById(R.id.unit);


    }

    @Override
    public void handleListener() {

        tvMenu.setOnClickListener(this);

    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Detail");

        model = getIntent().getParcelableExtra("item");


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
    void setIcon(Util util) {

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.menu:
                finish();
                break;

        }

    }
}
