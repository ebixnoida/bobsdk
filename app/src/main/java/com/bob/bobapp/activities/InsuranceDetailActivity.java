package com.bob.bobapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;

public class InsuranceDetailActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, name, amount, insuranceCompany, policy, policyName, policyType, fundValue, sumAssured, policyStartDate, maturityDate, premiumAmount, frequency, annualPremium, nextDueDate;


    private LifeInsuranceResponse model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_detail);
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);


        name = findViewById(R.id.name);
        amount = findViewById(R.id.value);
        insuranceCompany = findViewById(R.id.insuranceCompany);
        policy = findViewById(R.id.policy);
        policyName = findViewById(R.id.policyName);
        policyType = findViewById(R.id.policyType);
        fundValue = findViewById(R.id.fundValue);
        sumAssured = findViewById(R.id.sumAssured);
        policyStartDate = findViewById(R.id.policyStartDate);
        maturityDate = findViewById(R.id.maturityDate);
        premiumAmount = findViewById(R.id.premiumAmount);
        frequency = findViewById(R.id.frequency);
        annualPremium = findViewById(R.id.annualPremium);
        nextDueDate = findViewById(R.id.nextDueDate);


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

        name.setText(model.getPolicyName()+"");
        amount.setText(model.getAmount() + "");
        insuranceCompany.setText(model.getInsuranceCompany()+"");
        policy.setText(model.getPolicyName()+"");
        policyName.setText(model.getPolicyno() + "");
        policyType.setText(model.getPolicyType()+"");
        fundValue.setText(model.getFundValue() + "");
        sumAssured.setText(model.getAmount() + "");
        policyStartDate.setText(model.getPolicymaturitydate()+"");
        maturityDate.setText(model.getPremiumstdate()+"");
        premiumAmount.setText(model.getPremiumamount() + "");
        frequency.setText(model.getFrequency()+"");
        annualPremium.setText(model.getAnnualPremium() + "");
        nextDueDate.setText(model.getDuedate()+"");

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
