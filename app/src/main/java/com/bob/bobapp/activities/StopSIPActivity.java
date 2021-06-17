package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.SIPSWPSTPDueListAdapter;
import com.bob.bobapp.adapters.StopSIPListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestBodyModel;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestModel;
import com.bob.bobapp.api.response_object.OrderStatusResponse;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
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

public class StopSIPActivity extends BaseFragment {

    private TextView calender, buy, swp;
    private RecyclerView rv;
    private StopSIPListAdapter adapter;
    private ArrayList<SIPDueReportResponse> sipArrayList = new ArrayList<>();
    private ArrayList<SIPDueReportResponse> stpArrayList = new ArrayList<>();
    private APIInterface apiInterface;
    private Util util;
    private LinearLayout llBuy, llSWP, viewBuy, viewSWP;


    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_stop_s_i_p, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void getIds(View view) {

        calender = view.findViewById(R.id.calender);

        rv = view.findViewById(R.id.rv);

        llBuy = view.findViewById(R.id.llBuy);
        llSWP = view.findViewById(R.id.llSWP);
        buy = view.findViewById(R.id.buy);
        swp = view.findViewById(R.id.swp);
        viewBuy = view.findViewById(R.id.viewBuy);
        viewSWP = view.findViewById(R.id.viewSWP);

    }

    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);
        llBuy.setOnClickListener(this);
        llSWP.setOnClickListener(this);

    }

    @Override
    public void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("Stop SIP");
        apiInterface = BOBApp.getApi(context, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(context);
        getApiCall();
    }

    @Override
    public void setIcon(Util util) {

        FontManager.markAsIconContainer(calender, util.iconFont);


    }

    private void getApiCall() {

        util.showProgressDialog(context, true);

        SIPSWPSTPRequestBodyModel requestBodyModel = new SIPSWPSTPRequestBodyModel();

        requestBodyModel.setUserId("admin");
        requestBodyModel.setUcc("069409856");
        requestBodyModel.setClientCode(0);
        requestBodyModel.setClientType("H");
        requestBodyModel.setFamCode(0);
        requestBodyModel.setFromDate("2020/06/14");
        requestBodyModel.setHeadCode(32);
        requestBodyModel.setReportType("SUMMARY");
        requestBodyModel.setToDate("2020/06/21");

        SIPSWPSTPRequestModel model = new SIPSWPSTPRequestModel();
        model.setRequestBodyObject(requestBodyModel);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getSIPDueReportApiCall(model).enqueue(new Callback<ArrayList<SIPDueReportResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<SIPDueReportResponse>> call, Response<ArrayList<SIPDueReportResponse>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    for (SIPDueReportResponse item : response.body()) {

                        if (item.getType().equalsIgnoreCase("stp")) {
                            stpArrayList.add(item);
                        } else if (item.getType().equalsIgnoreCase("SIP")) {
                            sipArrayList.add(item);
                        }
                    }

                    setAdapter(sipArrayList);
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<SIPDueReportResponse>> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<SIPDueReportResponse> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {
            adapter = new StopSIPListAdapter(context, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.menu) {
            getActivity().onBackPressed();
        } else if (id == R.id.llBuy) {
            buy.setTextColor(getResources().getColor(R.color.black));
            swp.setTextColor(getResources().getColor(R.color.colorGray));
            viewBuy.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
            viewSWP.setBackgroundColor(getResources().getColor(R.color.colorGray));
            adapter.updateList(sipArrayList);
        } else if (id == R.id.llSWP) {
            buy.setTextColor(getResources().getColor(R.color.colorGray));
            swp.setTextColor(getResources().getColor(R.color.black));
            viewBuy.setBackgroundColor(getResources().getColor(R.color.colorGray));
            viewSWP.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
            adapter.updateList(stpArrayList);
        }else if (id == R.id.imgBack) {
            getActivity().onBackPressed();
        }

    }
}

