package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
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
import com.bob.bobapp.adapters.OrderStatusListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.OrderStatusRequest;
import com.bob.bobapp.api.request_object.OrderStatusRequestBody;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.OrderStatusResponse;
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

public class OrderStatusActivity extends BaseFragment {

    private TextView buyText, sipText, switchText, txtInvestmentCart;
    private RecyclerView rv;
    private LinearLayout llBuy, llSip, llSwitch, buyView, sipView, switchView;
    private APIInterface apiInterface;
    private Util util;
    private ArrayList<OrderStatusResponse> buyArrayList = new ArrayList<>();
    private ArrayList<OrderStatusResponse> sipArrayList = new ArrayList<>();
    private ArrayList<OrderStatusResponse> switchArrayList = new ArrayList<>();
    private OrderStatusListAdapter adapter;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_order_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        rv = view.findViewById(R.id.rv);

        llBuy = view.findViewById(R.id.llBuy);
        llSip = view.findViewById(R.id.llSip);
        llSwitch = view.findViewById(R.id.llSwitch);

        buyText = view.findViewById(R.id.buyText);
        sipText = view.findViewById(R.id.sipText);
        switchText = view.findViewById(R.id.switchText);

        buyView = view.findViewById(R.id.buyView);
        sipView = view.findViewById(R.id.sipView);
        switchView = view.findViewById(R.id.switchView);
        txtInvestmentCart = view.findViewById(R.id.txtInvestmentCart);

    }

    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);
        llBuy.setOnClickListener(this);
        llSip.setOnClickListener(this);
        llSwitch.setOnClickListener(this);
        txtInvestmentCart.setOnClickListener(this);

    }

    @Override
    public void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("My Orders");
        apiInterface = BOBApp.getApi(context, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(context);
        getApiCall();
    }

    private void getApiCall() {

        util.showProgressDialog(context, true);
        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        OrderStatusRequestBody requestBodyModel = new OrderStatusRequestBody();

        requestBodyModel.setFamCode(0);
        requestBodyModel.setHeadCode(32);
        requestBodyModel.setClientCode(0);
        requestBodyModel.setFromDate("2020-01-07T00:00:00");
        requestBodyModel.setToDate("2021-02-04T00:00:00");
        requestBodyModel.setClientType("H");

        OrderStatusRequest model = new OrderStatusRequest();
        model.setRequestBodyObject(requestBodyModel);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getOrderStatusApiCall(model).enqueue(new Callback<ArrayList<OrderStatusResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderStatusResponse>> call, Response<ArrayList<OrderStatusResponse>> response) {
                util.showProgressDialog(context, true);

                if (response.isSuccessful()) {

                    for (OrderStatusResponse item : response.body()) {

                        if (item.getOrderType().equalsIgnoreCase("Purchase")) {
                            buyArrayList.add(item);
                        } else if (item.getOrderType().equalsIgnoreCase("SIP")) {
                            sipArrayList.add(item);
                        } else if (item.getOrderType().equalsIgnoreCase("Switch")) {
                            switchArrayList.add(item);
                        }
                    }

                    setAdapter(buyArrayList);
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<OrderStatusResponse>> call, Throwable t) {
                util.showProgressDialog(context, true);
                Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAdapter(ArrayList<OrderStatusResponse> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            adapter = new OrderStatusListAdapter(context, arrayList);
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
        } else if (id == R.id.llBuy) {
            buyText.setTextColor(getResources().getColor(R.color.black));
            sipText.setTextColor(getResources().getColor(R.color.colorGray));
            switchText.setTextColor(getResources().getColor(R.color.colorGray));

            buyView.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
            sipView.setBackgroundColor(getResources().getColor(R.color.colorGray));
            switchView.setBackgroundColor(getResources().getColor(R.color.colorGray));

            adapter.updateList(buyArrayList);
        } else if (id == R.id.llSip) {
            buyText.setTextColor(getResources().getColor(R.color.colorGray));
            sipText.setTextColor(getResources().getColor(R.color.black));
            switchText.setTextColor(getResources().getColor(R.color.colorGray));

            buyView.setBackgroundColor(getResources().getColor(R.color.colorGray));
            sipView.setBackgroundColor(getResources().getColor(R.color.color_light_orange));
            switchView.setBackgroundColor(getResources().getColor(R.color.colorGray));

            adapter.updateList(sipArrayList);
        } else if (id == R.id.llSwitch) {
            buyText.setTextColor(getResources().getColor(R.color.colorGray));
            sipText.setTextColor(getResources().getColor(R.color.colorGray));
            switchText.setTextColor(getResources().getColor(R.color.black));

            buyView.setBackgroundColor(getResources().getColor(R.color.colorGray));
            sipView.setBackgroundColor(getResources().getColor(R.color.colorGray));
            switchView.setBackgroundColor(getResources().getColor(R.color.color_light_orange));

            adapter.updateList(switchArrayList);

        } else if (id == R.id.txtInvestmentCart) {

            replaceFragment(new InvestmentCartActivity());

        }else if (id == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }

    public void replaceFragment(Fragment fragment) {

        ((BaseContainerFragment)getParentFragment()).replaceFragment(fragment, false);
    }
}