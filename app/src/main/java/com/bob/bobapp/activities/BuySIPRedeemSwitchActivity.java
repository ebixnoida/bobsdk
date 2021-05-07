package com.bob.bobapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;

import java.text.DecimalFormat;

public class BuySIPRedeemSwitchActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu;
    private LinearLayout llSip, llBuy, llRedeem, llSwitch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_sip_redeem_switch);
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);

        llBuy = findViewById(R.id.llBuy);
        llSip = findViewById(R.id.llSIP);
        llRedeem = findViewById(R.id.llRedeem);
        llSwitch = findViewById(R.id.llSwitch);


    }

    @Override
    public void handleListener() {

        tvMenu.setOnClickListener(this);

    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        String type = getIntent().getStringExtra("type");
        if (type.equalsIgnoreCase("buy")) {
            llBuy.setVisibility(View.VISIBLE);
            llSip.setVisibility(View.GONE);
            llRedeem.setVisibility(View.GONE);
            llSwitch.setVisibility(View.GONE);
            tvTitle.setText("BUY");
        } else if (type.equalsIgnoreCase("sip")) {
            llBuy.setVisibility(View.GONE);
            llSip.setVisibility(View.VISIBLE);
            llRedeem.setVisibility(View.GONE);
            llSwitch.setVisibility(View.GONE);
            tvTitle.setText("SIP");
        } else if (type.equalsIgnoreCase("redeem")) {
            llBuy.setVisibility(View.GONE);
            llSip.setVisibility(View.GONE);
            llRedeem.setVisibility(View.VISIBLE);
            llSwitch.setVisibility(View.GONE);
            tvTitle.setText("Redeem");
        } else if (type.equalsIgnoreCase("switch")) {
            llBuy.setVisibility(View.GONE);
            llSip.setVisibility(View.GONE);
            llRedeem.setVisibility(View.VISIBLE);
            llSwitch.setVisibility(View.VISIBLE);
            tvTitle.setText("Switch");
        } else if (type.equalsIgnoreCase("swp")) {
            tvTitle.setText("SWP");
        } else if (type.equalsIgnoreCase("stp")) {
            tvTitle.setText("STP");
        }


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
