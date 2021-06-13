package com.bob.bobapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.GeneralInsuranceListAdapter;
import com.bob.bobapp.adapters.HoldingListAdapter;
import com.bob.bobapp.adapters.InsuranceListAdapter;
import com.bob.bobapp.adapters.OrderStatusListAdapter;
import com.bob.bobapp.adapters.RealizaedGainLossListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.GeneralInsuranceRequest;
import com.bob.bobapp.api.request_object.GeneralInsuranceRequestBody;
import com.bob.bobapp.api.request_object.LifeInsuranceRequest;
import com.bob.bobapp.api.request_object.LifeInsuranceRequestBody;
import com.bob.bobapp.api.request_object.RealisedGainLossRequestModel;
import com.bob.bobapp.api.request_object.RealizedGainLossRequestBodyModel;
import com.bob.bobapp.api.response_object.GeneralInsuranceResponse;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.api.response_object.RealizedGainLoss;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsuranceActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, lifeInsurance, generalInsurance;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;
    private LinearLayout viewLifeInsurance, viewGeneralInsurance, llLifeInsurance, llGeneralInsurance;
    private ArrayList<GeneralInsuranceResponse> generalInsuranceArrayList;
    private ArrayList<LifeInsuranceResponse> lifeInsuranceArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        rv = findViewById(R.id.rv);

        llLifeInsurance = findViewById(R.id.llLifeInsurance);
        llGeneralInsurance = findViewById(R.id.llGeneralInsurance);
        lifeInsurance = findViewById(R.id.lifeInsurance);
        generalInsurance = findViewById(R.id.generalInsurance);
        viewLifeInsurance = findViewById(R.id.viewLifeInsurance);
        viewGeneralInsurance = findViewById(R.id.viewGeneralInsurance);

    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);
        llGeneralInsurance.setOnClickListener(this);
        llLifeInsurance.setOnClickListener(this);

    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Order Status");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_INSURANCE);
        util = new Util(this);
        getLifeInsuranceApiCall();
        getGeneralInsuranceApiCall();

    }

    private void getLifeInsuranceApiCall() {
        util.showProgressDialog(this, true);
        LifeInsuranceRequestBody requestBody = new LifeInsuranceRequestBody();
        requestBody.setClientcode(0);
        requestBody.setHeadclientCode("32");
        requestBody.setFamcode(0);
        requestBody.setClienttype("H");


        LifeInsuranceRequest model = new LifeInsuranceRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getLifeInsuranceApiCall(model).enqueue(new Callback<ArrayList<LifeInsuranceResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<LifeInsuranceResponse>> call, Response<ArrayList<LifeInsuranceResponse>> response) {

                util.showProgressDialog(InsuranceActivity.this, false);

                if (response.isSuccessful()) {

                    lifeInsuranceArrayList = response.body();

                    setAdapter(lifeInsuranceArrayList);
                } else {
                    Toast.makeText(InsuranceActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LifeInsuranceResponse>> call, Throwable t) {
                util.showProgressDialog(InsuranceActivity.this, false);
                Toast.makeText(InsuranceActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<LifeInsuranceResponse> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            InsuranceListAdapter adapter = new InsuranceListAdapter(this, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }


    }


    private void getGeneralInsuranceApiCall() {
        util.showProgressDialog(this, true);

        final GeneralInsuranceRequestBody requestBody = new GeneralInsuranceRequestBody();
        requestBody.setRmcode(0);
        requestBody.setClientCode(32);
        requestBody.setCategoryid(0);
        requestBody.setProduct(0);
        requestBody.setInsurancecompid(5);
        requestBody.setFromdate("2020-06-07T10:58:41.5659054+05:30");
        requestBody.setTodate("2021-03-15T10:58:41.5659054+05:30");
        requestBody.setStatus("1");
        requestBody.setType("A");
        requestBody.setMusrid("admin");
        requestBody.setClientType("H");

        GeneralInsuranceRequest model = new GeneralInsuranceRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getGeneralInsuranceApiCall(model).enqueue(new Callback<ArrayList<GeneralInsuranceResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<GeneralInsuranceResponse>> call, Response<ArrayList<GeneralInsuranceResponse>> response) {

                util.showProgressDialog(InsuranceActivity.this, false);

                if (response.isSuccessful()) {

                    generalInsuranceArrayList = response.body();

                    setAdapterGeneralInsurance(generalInsuranceArrayList);
                } else {
                    Toast.makeText(InsuranceActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GeneralInsuranceResponse>> call, Throwable t) {
                util.showProgressDialog(InsuranceActivity.this, false);
                Toast.makeText(InsuranceActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapterGeneralInsurance(ArrayList<GeneralInsuranceResponse> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {
            GeneralInsuranceListAdapter adapter = new GeneralInsuranceListAdapter(this, arrayList);
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

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.menu:
                finish();
                break;

            case R.id.llLifeInsurance:

                lifeInsurance.setTextColor(getResources().getColor(R.color.black));
                generalInsurance.setTextColor(getResources().getColor(R.color.colorGray));
                viewLifeInsurance.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
                viewGeneralInsurance.setBackgroundColor(getResources().getColor(R.color.colorGray));
                rv.setAdapter(null);
                setAdapter(lifeInsuranceArrayList);

                break;

            case R.id.llGeneralInsurance:

                lifeInsurance.setTextColor(getResources().getColor(R.color.colorGray));
                generalInsurance.setTextColor(getResources().getColor(R.color.black));
                viewLifeInsurance.setBackgroundColor(getResources().getColor(R.color.colorGray));
                viewGeneralInsurance.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
                rv.setAdapter(null);
                setAdapterGeneralInsurance(generalInsuranceArrayList);

                break;
        }

    }
}