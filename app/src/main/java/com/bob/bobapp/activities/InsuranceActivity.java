package com.bob.bobapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
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

public class InsuranceActivity extends BaseFragment {

    private TextView lifeInsurance, generalInsurance;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;
    private LinearLayout viewLifeInsurance, viewGeneralInsurance, llLifeInsurance, llGeneralInsurance;
    private ArrayList<GeneralInsuranceResponse> generalInsuranceArrayList;
    private ArrayList<LifeInsuranceResponse> lifeInsuranceArrayList;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_insurance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        rv = view.findViewById(R.id.rv);

        llLifeInsurance = view.findViewById(R.id.llLifeInsurance);
        llGeneralInsurance = view.findViewById(R.id.llGeneralInsurance);
        lifeInsurance = view.findViewById(R.id.lifeInsurance);
        generalInsurance = view.findViewById(R.id.generalInsurance);
        viewLifeInsurance = view.findViewById(R.id.viewLifeInsurance);
        viewGeneralInsurance = view.findViewById(R.id.viewGeneralInsurance);

    }

    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);
        llGeneralInsurance.setOnClickListener(this);
        llLifeInsurance.setOnClickListener(this);

    }

    @Override
    public void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("Order Status");
        apiInterface = BOBApp.getApi(context, Constants.ACTION_INSURANCE);
        util = new Util(context);
        getLifeInsuranceApiCall();
        getGeneralInsuranceApiCall();

    }

    private void getLifeInsuranceApiCall() {
        util.showProgressDialog(context, true);
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

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getLifeInsuranceApiCall(model).enqueue(new Callback<ArrayList<LifeInsuranceResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<LifeInsuranceResponse>> call, Response<ArrayList<LifeInsuranceResponse>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    lifeInsuranceArrayList = response.body();

                    setAdapter(lifeInsuranceArrayList);
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<LifeInsuranceResponse>> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<LifeInsuranceResponse> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            InsuranceListAdapter adapter = new InsuranceListAdapter(context, arrayList) {
                @Override
                public void getDetail(Fragment fragment) {

                    replaceFragment(fragment);
                }
            };
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }


    }

    public void replaceFragment(Fragment fragment) {

        ((BaseContainerFragment)getParentFragment()).replaceFragment(fragment, true);
    }


    private void getGeneralInsuranceApiCall() {
        util.showProgressDialog(context, true);

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

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getGeneralInsuranceApiCall(model).enqueue(new Callback<ArrayList<GeneralInsuranceResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<GeneralInsuranceResponse>> call, Response<ArrayList<GeneralInsuranceResponse>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    generalInsuranceArrayList = response.body();

                    setAdapterGeneralInsurance(generalInsuranceArrayList);
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GeneralInsuranceResponse>> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapterGeneralInsurance(ArrayList<GeneralInsuranceResponse> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {
            GeneralInsuranceListAdapter adapter = new GeneralInsuranceListAdapter(context, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void setIcon(Util util) {

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.menu) {
            getActivity().onBackPressed();
        } else if (id == R.id.llLifeInsurance) {
            lifeInsurance.setTextColor(getResources().getColor(R.color.black));
            generalInsurance.setTextColor(getResources().getColor(R.color.colorGray));
            viewLifeInsurance.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
            viewGeneralInsurance.setBackgroundColor(getResources().getColor(R.color.colorGray));
            rv.setAdapter(null);
            setAdapter(lifeInsuranceArrayList);
        } else if (id == R.id.llGeneralInsurance) {
            lifeInsurance.setTextColor(getResources().getColor(R.color.colorGray));
            generalInsurance.setTextColor(getResources().getColor(R.color.black));
            viewLifeInsurance.setBackgroundColor(getResources().getColor(R.color.colorGray));
            viewGeneralInsurance.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
            rv.setAdapter(null);
            setAdapterGeneralInsurance(generalInsuranceArrayList);
        }else if (id == R.id.imgBack) {
            getActivity().onBackPressed();
        }

    }
}