package com.bob.bobapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.activities.BOBActivity;
import com.bob.bobapp.adapters.AccountListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.AccountRequestObject;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.RMDetailRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.response_object.AccountResponseObject;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.RMDetailResponseObject;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends BaseFragment {

    private TextView tv_rm_username_name, tv_rm_name, tv_rm_email, tv_rm_mobile_number;

    private RecyclerView accountDetailsRecyclerView;

    private APIInterface apiInterface;

    private Util util;

    private ArrayList<RMDetailResponseObject> rmDetailResponseObjectArrayList = new ArrayList<>();

    private ArrayList<AccountResponseObject> accountResponseObjectArrayList = new ArrayList<>();

    private AccountResponseObject accountResponseObject;

    private int selectedPosition;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        apiInterface = BOBApp.getApi(getContext(), Constants.ACTION_RM_DETAIL);

        context = getActivity();

        util = new Util(context);

        callRMDetailAPI();
    }

    @Override
    protected void getIds(View view) {

        tv_rm_username_name = view.findViewById(R.id.tv_rm_username_name);

        tv_rm_name = view.findViewById(R.id.tv_rm_name);

        tv_rm_email = view.findViewById(R.id.tv_rm_email);

        tv_rm_mobile_number = view.findViewById(R.id.tv_rm_mobile_number);

        tv_rm_username_name = view.findViewById(R.id.tv_rm_username_name);

        accountDetailsRecyclerView = view.findViewById(R.id.rvAccounts);
    }

    @Override
    protected void handleListener() {

        BOBActivity.imgBack.setOnClickListener(this);
    }

    @Override
    protected void initializations() {

        BOBActivity.llMenu.setVisibility(View.GONE);

        BOBActivity.title.setText("Profile");
    }

    @Override
    protected void setIcon(Util util) {

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }

    private void callRMDetailAPI() {

        util.showProgressDialog(getContext(), true);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;


        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setUserId(authenticateResponse.getUserID());

        requestBodyObject.setUserType(authenticateResponse.getUserType());

        requestBodyObject.setUserCode(authenticateResponse.getUserCode());

        requestBodyObject.setLastBusinessDate(authenticateResponse.getBusinessDate());

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAmountDenomination("0"); //For base

        requestBodyObject.setAccountLevel("0"); //For client

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(getContext(), uniqueIdentifier);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        RMDetailRequestObject.createGlobalRequestObject(globalRequestObject);

        apiInterface.getRMDetailResponse(RMDetailRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<RMDetailResponseObject>>() {

            @Override
            public void onResponse(Call<ArrayList<RMDetailResponseObject>> call, Response<ArrayList<RMDetailResponseObject>> response) {


                if (response.isSuccessful()) {

                    rmDetailResponseObjectArrayList = response.body();

                    tv_rm_username_name.setText(rmDetailResponseObjectArrayList.get(0).getClientName());

                    tv_rm_name.setText(rmDetailResponseObjectArrayList.get(0).getPrimaryRMName());

                    tv_rm_email.setText(rmDetailResponseObjectArrayList.get(0).getPrimaryRMEmail());

                    tv_rm_mobile_number.setText(rmDetailResponseObjectArrayList.get(0).getPrimaryRMContactNo());

                    callAccountDetailAPI();

                } else {

                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RMDetailResponseObject>> call, Throwable t) {

                util.showProgressDialog(getContext(), false);

                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callAccountDetailAPI() {

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setClientCode(authenticateResponse.getUserCode());

        requestBodyObject.setClientType("H"); //H for client

        requestBodyObject.setIsFundware("false");

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(getContext(), uniqueIdentifier);

        AccountRequestObject.createAccountRequestObject(uniqueIdentifier, Constants.SOURCE, requestBodyObject);


        APIInterface apiInterface = BOBApp.getApi(getContext(), Constants.ACTION_ACCOUNT);

        apiInterface.getAccountResponse(AccountRequestObject.getAccountRequestObject()).enqueue(new Callback<ArrayList<AccountResponseObject>>() {
            @Override
            public void onResponse(Call<ArrayList<AccountResponseObject>> call, Response<ArrayList<AccountResponseObject>> response) {

                util.showProgressDialog(getContext(), false);

                if (response.isSuccessful()) {

                    accountResponseObjectArrayList = response.body();

                    setPopupData(accountResponseObjectArrayList);

                } else {

                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<AccountResponseObject>> call, Throwable t) {

                util.showProgressDialog(getContext(), false);

                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setPopupData(ArrayList<AccountResponseObject> accountResponseObjectArrayList) {

        AccountListAdapter adapter = new AccountListAdapter(getContext(), accountResponseObjectArrayList) {

            @Override
            protected void onAccountSelect(int position) {

                accountResponseObject = accountResponseObjectArrayList.get(position);

                selectedPosition = position;
            }
        };

        accountDetailsRecyclerView.setAdapter(adapter);

    }

}