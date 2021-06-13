package com.bob.bobapp.activities;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.OrderStatusListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.OrderStatusRequest;
import com.bob.bobapp.api.request_object.OrderStatusRequestBody;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.OrderStatusResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderStatusActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, buyText, sipText, switchText, txtInvestmentCart;
    private RecyclerView rv;
    private LinearLayout llBuy, llSip, llSwitch, buyView, sipView, switchView;
    private APIInterface apiInterface;
    private Util util;
    private ArrayList<OrderStatusResponse> buyArrayList = new ArrayList<>();
    private ArrayList<OrderStatusResponse> sipArrayList = new ArrayList<>();
    private ArrayList<OrderStatusResponse> switchArrayList = new ArrayList<>();
    private OrderStatusListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        rv = findViewById(R.id.rv);

        llBuy = findViewById(R.id.llBuy);
        llSip = findViewById(R.id.llSip);
        llSwitch = findViewById(R.id.llSwitch);

        buyText = findViewById(R.id.buyText);
        sipText = findViewById(R.id.sipText);
        switchText = findViewById(R.id.switchText);

        buyView = findViewById(R.id.buyView);
        sipView = findViewById(R.id.sipView);
        switchView = findViewById(R.id.switchView);
        txtInvestmentCart = findViewById(R.id.txtInvestmentCart);

    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);
        llBuy.setOnClickListener(this);
        llSip.setOnClickListener(this);
        llSwitch.setOnClickListener(this);
        txtInvestmentCart.setOnClickListener(this);

    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Order Status");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(this);
        getApiCall();
    }

    private void getApiCall() {

        util.showProgressDialog(this, true);
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
        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getOrderStatusApiCall(model).enqueue(new Callback<ArrayList<OrderStatusResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderStatusResponse>> call, Response<ArrayList<OrderStatusResponse>> response) {
                util.showProgressDialog(OrderStatusActivity.this, true);

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
                    Toast.makeText(OrderStatusActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<OrderStatusResponse>> call, Throwable t) {
                util.showProgressDialog(OrderStatusActivity.this, true);
                Toast.makeText(OrderStatusActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAdapter(ArrayList<OrderStatusResponse> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            adapter = new OrderStatusListAdapter(this, arrayList);
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

        int id = view.getId();
        if (id == R.id.menu) {
            finish();
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
            Intent intent = new Intent(getApplicationContext(), InvestmentCartActivity.class);
            startActivity(intent);
        }


    }
}