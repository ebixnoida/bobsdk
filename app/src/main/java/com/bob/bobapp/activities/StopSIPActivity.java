package com.bob.bobapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.SIPSWPSTPDueListAdapter;
import com.bob.bobapp.adapters.StopSIPListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestBodyModel;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestModel;
import com.bob.bobapp.api.response_object.OrderStatusResponse;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StopSIPActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, calender, buy, swp;
    private RecyclerView rv;
    private StopSIPListAdapter adapter;
    private ArrayList<SIPDueReportResponse> sipArrayList = new ArrayList<>();
    private ArrayList<SIPDueReportResponse> stpArrayList = new ArrayList<>();
    private APIInterface apiInterface;
    private Util util;
    private LinearLayout llBuy, llSWP, viewBuy, viewSWP;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_s_i_p);
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

        llBuy = findViewById(R.id.llBuy);
        llSWP = findViewById(R.id.llSWP);
        buy = findViewById(R.id.buy);
        swp = findViewById(R.id.swp);
        viewBuy = findViewById(R.id.viewBuy);
        viewSWP = findViewById(R.id.viewSWP);

    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);
        llBuy.setOnClickListener(this);
        llSWP.setOnClickListener(this);

    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Stop SIP");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(this);
        getApiCall();
    }

    @Override
    void setIcon(Util util) {

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
        FontManager.markAsIconContainer(calender, util.iconFont);


    }

    private void getApiCall() {

        util.showProgressDialog(this, true);

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
        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getSIPDueReportApiCall(model).enqueue(new Callback<ArrayList<SIPDueReportResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<SIPDueReportResponse>> call, Response<ArrayList<SIPDueReportResponse>> response) {

                util.showProgressDialog(StopSIPActivity.this, false);

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
                    Toast.makeText(StopSIPActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<SIPDueReportResponse>> call, Throwable t) {
                util.showProgressDialog(StopSIPActivity.this, false);
                Toast.makeText(StopSIPActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<SIPDueReportResponse> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {
            adapter = new StopSIPListAdapter(this, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.menu) {
            finish();
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
        }

    }
}

