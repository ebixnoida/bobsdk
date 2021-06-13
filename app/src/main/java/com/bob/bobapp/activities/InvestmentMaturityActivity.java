package com.bob.bobapp.activities;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.InvestmentMaturityListAdapter;
import com.bob.bobapp.adapters.SIPSWPSTPDueListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.MaturitiesReportModel;
import com.bob.bobapp.api.request_object.MaturityReportRequestModel;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvestmentMaturityActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, calender;
    private RecyclerView rv;
    private Util util;
    private APIInterface apiInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_maturity);
    }

    @Override
    public void getIds() {
        calender = findViewById(R.id.calender);
        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        rv = findViewById(R.id.rv);

    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);

    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Maturities");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_INVESTMENT_MATURITY);
        util = new Util(this);
        getApiCall();
    }

    private void getApiCall() {

        util.showProgressDialog(this, true);

        MaturitiesReportModel model = new MaturitiesReportModel();
        model.setFromDate("20160101");
        model.setHeadCode("32");
        model.setTillDate("20200614");

        MaturityReportRequestModel requestModel = new MaturityReportRequestModel();
        requestModel.setRequestBodyObject(model);
        requestModel.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        requestModel.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getInvestmentMaturityReportApiCall(requestModel).enqueue(new Callback<ArrayList<InvestmentMaturityModel>>() {
            @Override
            public void onResponse(Call<ArrayList<InvestmentMaturityModel>> call, Response<ArrayList<InvestmentMaturityModel>> response) {
                util.showProgressDialog(InvestmentMaturityActivity.this, false);

                if (response.isSuccessful()) {
                    setAdapter(response.body());
                } else {
                    Toast.makeText(InvestmentMaturityActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<InvestmentMaturityModel>> call, Throwable t) {
                util.showProgressDialog(InvestmentMaturityActivity.this, false);
                Toast.makeText(InvestmentMaturityActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<InvestmentMaturityModel> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            InvestmentMaturityListAdapter adapter = new InvestmentMaturityListAdapter(this, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    void setIcon(Util util) {

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
        FontManager.markAsIconContainer(calender, util.iconFont);

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

