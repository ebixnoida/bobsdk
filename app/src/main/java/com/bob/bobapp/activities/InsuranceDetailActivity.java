package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.Util;
import com.google.gson.Gson;

public class InsuranceDetailActivity extends BaseFragment {

    private TextView name, amount, insuranceCompany, policy, policyName, policyType, fundValue, sumAssured, policyStartDate, maturityDate, premiumAmount, frequency, annualPremium, nextDueDate;

    private LifeInsuranceResponse model;

    private Context context;

    private Util util;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_insurance_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        name = view.findViewById(R.id.name);
        amount = view.findViewById(R.id.value);
        insuranceCompany = view.findViewById(R.id.insuranceCompany);
        policy = view.findViewById(R.id.policy);
        policyName = view.findViewById(R.id.policyName);
        policyType = view.findViewById(R.id.policyType);
        fundValue = view.findViewById(R.id.fundValue);
        sumAssured = view.findViewById(R.id.sumAssured);
        policyStartDate = view.findViewById(R.id.policyStartDate);
        maturityDate = view.findViewById(R.id.maturityDate);
        premiumAmount = view.findViewById(R.id.premiumAmount);
        frequency = view.findViewById(R.id.frequency);
        annualPremium = view.findViewById(R.id.annualPremium);
        nextDueDate = view.findViewById(R.id.nextDueDate);


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

            model = new Gson().fromJson(response, LifeInsuranceResponse.class);
        }

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
