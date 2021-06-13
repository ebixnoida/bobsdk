package com.bob.bobapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.FolioSpinnerAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.WebService;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.bean.SpinnerRowItem;
import com.bob.bobapp.api.request_object.AddInvCartRequest;
import com.bob.bobapp.api.request_object.AuthenticateRequest;
import com.bob.bobapp.api.request_object.FundDetailRequest;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.MFOrderValidationRequest;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.response_object.AddInvCartResponse;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.FundDetailResponse;
import com.bob.bobapp.api.response_object.MFOrderValidationResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.IntentKey;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;
import com.google.gson.Gson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import androidx.appcompat.widget.AppCompatSpinner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuySIPRedeemSwitchActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, tvFolioNumberHeader;
    private LinearLayout llSip, llBuy, llRedeem, llSwitch, layoutBuy, layoutSTP;

    private Context context;

    private Util util;

    private String transactionType = "";

    private ClientHoldingObject clientHoldingObject;

    private TextView btnAddToCart;

    private AppCompatSpinner spinnerFolio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_sip_redeem_switch);

        context = this;

        util = new Util(context);

        getExtraDataFromIntent();

        setData();

        getValidationResponse();
    }

    private void getExtraDataFromIntent() {

        if (getIntent().hasExtra(IntentKey.TRANSACTION_TYPE_KEY)) {

            transactionType = getIntent().getExtras().getString(IntentKey.TRANSACTION_TYPE_KEY);
        }

        if (getIntent().hasExtra(IntentKey.RESPONSE_KEY)) {

            String response = getIntent().getExtras().getString(IntentKey.RESPONSE_KEY);

            clientHoldingObject = new Gson().fromJson(response, ClientHoldingObject.class);
        }
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);

        llBuy = findViewById(R.id.llBuy);
        llSip = findViewById(R.id.llSIP);
        llRedeem = findViewById(R.id.llRedeem);
        llSwitch = findViewById(R.id.llSwitch);
        tvFolioNumberHeader = findViewById(R.id.tvFolioNumberHeader);
        layoutBuy = findViewById(R.id.layoutBuy);
        layoutSTP = findViewById(R.id.layoutSTP);

        btnAddToCart = findViewById(R.id.addToCart);

        spinnerFolio = findViewById(R.id.spnFolioNo);
    }

    private void setData(){

        List rowItems = new ArrayList<SpinnerRowItem>();

        SpinnerRowItem spinnerRowItem = new SpinnerRowItem(clientHoldingObject.getFolio());

        spinnerRowItem.setTitle(clientHoldingObject.getFolio());

        rowItems.add(spinnerRowItem);

        FolioSpinnerAdapter adapter = new FolioSpinnerAdapter(context, R.layout.spinner_row_item, rowItems);

        spinnerFolio.setAdapter(adapter);
    }

    @Override
    public void handleListener() {

        tvMenu.setOnClickListener(this);

        btnAddToCart.setOnClickListener(this);
    }

    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        String type = getIntent().getStringExtra(IntentKey.TRANSACTION_TYPE_KEY);
        if (type.equalsIgnoreCase("buy")) {
            layoutBuy.setVisibility(View.VISIBLE);
            layoutSTP.setVisibility(View.GONE);
            llBuy.setVisibility(View.VISIBLE);
            llSip.setVisibility(View.GONE);
            llRedeem.setVisibility(View.GONE);
            llSwitch.setVisibility(View.GONE);
            tvFolioNumberHeader.setVisibility(View.GONE);
            tvTitle.setText("BUY");
        } else if (type.equalsIgnoreCase("sip")) {
            layoutBuy.setVisibility(View.VISIBLE);
            layoutSTP.setVisibility(View.GONE);
            llBuy.setVisibility(View.VISIBLE);
            llSip.setVisibility(View.VISIBLE);
            llRedeem.setVisibility(View.GONE);
            llSwitch.setVisibility(View.GONE);
            tvFolioNumberHeader.setVisibility(View.GONE);
            tvTitle.setText("SIP");
        } else if (type.equalsIgnoreCase("redeem")) {
            layoutBuy.setVisibility(View.VISIBLE);
            layoutSTP.setVisibility(View.GONE);
            llBuy.setVisibility(View.GONE);
            llSip.setVisibility(View.GONE);
            llRedeem.setVisibility(View.VISIBLE);
            llSwitch.setVisibility(View.VISIBLE);
            tvFolioNumberHeader.setVisibility(View.VISIBLE);
            tvTitle.setText("Redeem");
        } else if (type.equalsIgnoreCase("switch")) {
            layoutBuy.setVisibility(View.VISIBLE);
            layoutSTP.setVisibility(View.GONE);
            llBuy.setVisibility(View.GONE);
            llSip.setVisibility(View.GONE);
            llRedeem.setVisibility(View.VISIBLE);
            llSwitch.setVisibility(View.VISIBLE);
            tvFolioNumberHeader.setVisibility(View.VISIBLE);
            tvTitle.setText("Switch");
        } else if (type.equalsIgnoreCase("swp")) {
            tvFolioNumberHeader.setVisibility(View.VISIBLE);
            tvTitle.setText("SWP");
            layoutBuy.setVisibility(View.GONE);
            layoutSTP.setVisibility(View.VISIBLE);
        } else if (type.equalsIgnoreCase("stp")) {
            tvFolioNumberHeader.setVisibility(View.VISIBLE);
            layoutBuy.setVisibility(View.GONE);
            layoutSTP.setVisibility(View.VISIBLE);
            tvTitle.setText("STP");
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

            case R.id.addToCart:
                addToCartResponse();
                break;
        }
    }

    private void getValidationResponse(){

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_VALIDATION);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        //requestBodyObject.setMWIClientCode(clientHoldingObject.getClientCode());

        //requestBodyObject.setSchemeCode(clientHoldingObject.getSchemeCode());

        requestBodyObject.setMWIClientCode("34");

        requestBodyObject.setSchemeCode("64");

        requestBodyObject.setTransactionType(transactionType);

        String tillDate = util.getCurrentDate(false);

        requestBodyObject.setTillDate(tillDate);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        MFOrderValidationRequest.createGlobalRequestObject(globalRequestObject);

        apiInterface.getOrderValidationData(MFOrderValidationRequest.getGlobalRequestObject()).enqueue(new Callback<MFOrderValidationResponse>() {

            @Override
            public void onResponse(Call<MFOrderValidationResponse> call, Response<MFOrderValidationResponse> response) {

                System.out.println("VALIDATION RESPONSE: "+ new Gson().toJson(response.body()));

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {


                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MFOrderValidationResponse> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addToCartResponse(){

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_ADD_TO_CART);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        //requestBodyObject.setMWIClientCode(clientHoldingObject.getClientCode());

        //requestBodyObject.setSchemeCode(clientHoldingObject.getSchemeCode());

        requestBodyObject.setMWIClientCode("34");

        requestBodyObject.setSchemeCode("64");

        requestBodyObject.setTransactionType(transactionType);

        String tillDate = util.getCurrentDate(false);

        requestBodyObject.setTillDate(tillDate);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        AddInvCartRequest.createGlobalRequestObject(globalRequestObject);

        apiInterface.addInvestmentCart(AddInvCartRequest.getGlobalRequestObject()).enqueue(new Callback<AddInvCartResponse>() {

            @Override
            public void onResponse(Call<AddInvCartResponse> call, Response<AddInvCartResponse> response) {

                System.out.println("RESPONSE: "+ new Gson().toJson(response.body()));

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {


                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AddInvCartResponse> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
