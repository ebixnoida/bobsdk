package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.InvestmentMaturityListAdapter;
import com.bob.bobapp.adapters.SIPSWPSTPDueListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.MaturitiesReportModel;
import com.bob.bobapp.api.request_object.MaturityReportRequestModel;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvestmentMaturityActivity extends BaseFragment {

    private TextView calender;
    private RecyclerView rv;
    private Util util;
    private APIInterface apiInterface;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_investment_maturity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {
        calender = view.findViewById(R.id.calender);

        rv = view.findViewById(R.id.rv);

    }

    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);

    }

    @Override
    public void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("Maturities");
        apiInterface = BOBApp.getApi(context, Constants.ACTION_INVESTMENT_MATURITY);
        util = new Util(context);
        getApiCall();
    }

    private void getApiCall() {

        util.showProgressDialog(context, true);

        MaturitiesReportModel model = new MaturitiesReportModel();
        model.setFromDate("20160101");
        model.setHeadCode("32");
        model.setTillDate("20200614");

        MaturityReportRequestModel requestModel = new MaturityReportRequestModel();
        requestModel.setRequestBodyObject(model);
        requestModel.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        requestModel.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getInvestmentMaturityReportApiCall(requestModel).enqueue(new Callback<ArrayList<InvestmentMaturityModel>>() {
            @Override
            public void onResponse(Call<ArrayList<InvestmentMaturityModel>> call, Response<ArrayList<InvestmentMaturityModel>> response) {
                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {
                    setAdapter(response.body());
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<InvestmentMaturityModel>> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<InvestmentMaturityModel> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            InvestmentMaturityListAdapter adapter = new InvestmentMaturityListAdapter(context, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void setIcon(Util util) {

        FontManager.markAsIconContainer(calender, util.iconFont);

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

