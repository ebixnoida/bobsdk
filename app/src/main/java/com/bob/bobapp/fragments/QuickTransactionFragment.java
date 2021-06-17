
package com.bob.bobapp.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.activities.BOBActivity;
import com.bob.bobapp.adapters.AssetAdapter;
import com.bob.bobapp.adapters.FundHouseAdapter;
import com.bob.bobapp.adapters.FundTypeAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.AssetTypesRequest;
import com.bob.bobapp.api.request_object.AssetTypesRequestBody;
import com.bob.bobapp.api.request_object.FundTypesRequest;
import com.bob.bobapp.api.request_object.FundTypesRequestBody;
import com.bob.bobapp.api.response_object.AssetTypesResponse;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.FundTypesResponse;
import com.bob.bobapp.api.response_object.IssuersResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  QuickTransactionFragment extends BaseFragment
{
    private RecyclerView recyclerAsset, recyclerFundType, recyclerFundHouse;
    private AssetAdapter assetAdapter;
    private FundTypeAdapter fundTypeAdapter;
    private FundHouseAdapter fundHouseAdapter;
    private APIInterface apiInterface;
    private Util util;
    private ArrayList<AssetTypesResponse>assetTypesResponseArrayList=new ArrayList<>();
    private ArrayList<FundTypesResponse>fundTypesResponseArrayList=new ArrayList<>();
    private ArrayList<IssuersResponse>fundHouseResponseArrayList=new ArrayList<>();

    public QuickTransactionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quick_transaction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void getIds(View view) {
        recyclerAsset = view.findViewById(R.id.recyclerAsset);
        recyclerFundType = view.findViewById(R.id.recyclerFundType);
        recyclerFundHouse = view.findViewById(R.id.recyclerFundHouse);
    }

    @Override
    protected void handleListener() {

        BOBActivity.imgBack.setOnClickListener(this);
    }

    @Override
    protected void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);

        BOBActivity.title.setText("Quick Transaction");
        apiInterface = BOBApp.getApi(getContext(), Constants.ASSEST_TYPE);
        util = new Util(getContext());
        AssetApiCall();
    }

    @Override
    protected void setIcon(Util util) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }


    //  adapter
    private void setAssetAdapter() {
        assetAdapter = new AssetAdapter(getContext(),assetTypesResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerAsset.setLayoutManager(linearLayoutManager);
        recyclerAsset.setAdapter(assetAdapter);
    }

    // fund type
    private void setFundTypeAdapter() {
        fundTypeAdapter = new FundTypeAdapter(getContext(),fundTypesResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerFundType.setLayoutManager(linearLayoutManager);
        recyclerFundType.setAdapter(fundTypeAdapter);
    }

    // fund house adapter
    private void setFundHouseAdapter() {
        fundHouseAdapter = new FundHouseAdapter(getContext(),fundHouseResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerFundHouse.setLayoutManager(linearLayoutManager);
        recyclerFundHouse.setAdapter(fundHouseAdapter);
    }


    // api calling
    private void AssetApiCall() {
        util.showProgressDialog(getContext(), true);
        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        AssetTypesRequestBody requestBody = new AssetTypesRequestBody();
        requestBody.setClientCode("32");
        requestBody.setUserId(authenticateResponse.getUserID());
        requestBody.setLastBusinessDate("2018-02-07T00:00:00");
        requestBody.setAllocationType("2");
        requestBody.setCurrencyCode("1.0");
        requestBody.setAccountLevel("0");


        AssetTypesRequest model = new   AssetTypesRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(getContext(), uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.AssetTypes(model).enqueue(new Callback<ArrayList<AssetTypesResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<AssetTypesResponse>> call, Response<ArrayList<AssetTypesResponse>> response) {
                 //   util.showProgressDialog(getContext(), false);
                if (response.isSuccessful()) {
                    assetTypesResponseArrayList=response.body();
                    setAssetAdapter();

                    FundTypeApiCall();

                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AssetTypesResponse>> call, Throwable t) {
                util.showProgressDialog(getContext(), false);
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // api calling
    private void FundTypeApiCall() {
        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        FundTypesRequestBody requestBody = new FundTypesRequestBody();
        requestBody.setClientCode("32");


        FundTypesRequest model = new   FundTypesRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(getContext(), uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.FundTypes(model).enqueue(new Callback<ArrayList<FundTypesResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<FundTypesResponse>> call, Response<ArrayList<FundTypesResponse>> response) {
             //   util.showProgressDialog(getContext(), false);
                if (response.isSuccessful()) {
                    fundTypesResponseArrayList=response.body();
                    setFundTypeAdapter();
                    FundHousesApiCall();
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FundTypesResponse>> call, Throwable t) {
                util.showProgressDialog(getContext(), false);
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // api calling
    private void FundHousesApiCall() {
        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        FundTypesRequestBody requestBody = new FundTypesRequestBody();
        requestBody.setClientCode("32");


        FundTypesRequest model = new   FundTypesRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(getContext(), uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.Issuers(model).enqueue(new Callback<ArrayList<IssuersResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<IssuersResponse>> call, Response<ArrayList<IssuersResponse>> response) {
                   util.showProgressDialog(getContext(), false);
                if (response.isSuccessful()) {
                    fundHouseResponseArrayList=response.body();
                    setFundHouseAdapter();
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<IssuersResponse>> call, Throwable t) {
                util.showProgressDialog(getContext(), false);
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
