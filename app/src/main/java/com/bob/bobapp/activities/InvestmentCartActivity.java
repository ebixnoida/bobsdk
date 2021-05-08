package com.bob.bobapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.BankAccountAdapter;
import com.bob.bobapp.adapters.InvestmentAccountAdapter;
import com.bob.bobapp.adapters.InvestmentBuyAdapter;
import com.bob.bobapp.adapters.InvestmentRedeemAdapter;
import com.bob.bobapp.adapters.InvestmentSIPAdapter;
import com.bob.bobapp.adapters.InvestmentSTPAdapter;
import com.bob.bobapp.adapters.InvestmentSWPAdapter;
import com.bob.bobapp.adapters.InvestmentSwitchAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.AccountRequestBody;
import com.bob.bobapp.api.request_object.AccountsRequest;
import com.bob.bobapp.api.request_object.BankAccountBody;
import com.bob.bobapp.api.request_object.BankAccountRequest;
import com.bob.bobapp.api.request_object.InvestmentcartCountsRequest;
import com.bob.bobapp.api.request_object.InvestmentcartCountsRequestBody;
import com.bob.bobapp.api.response_object.AccountsResponse;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.BankAccountResponse;
import com.bob.bobapp.api.response_object.InvestmentCartCountResponse;
import com.bob.bobapp.api.request_object.InvestmentCartDetailsRequest;
import com.bob.bobapp.api.request_object.InvestmentCartDetailsRequestBody;
import com.bob.bobapp.api.response_object.InvestmentCartDetailsResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvestmentCartActivity extends BaseActivity {
    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, txtBuyImage;
    private AppCompatTextView txtInvestmentTab, txtTranCount, txtTotalAmount;
    private LinearLayoutCompat linearBankDetail, linearBuy, linearSIP, linearRedeem, linearSwitch, linearSWP,linearSTP;
    private RecyclerView recyclerBuy, recyclerSIP, recyclerRedeem, recyclerSwitch, recyclerSWP,recyclerSTP;
    private AppCompatSpinner spineerInvestmentAccount, spineerBankAccount;
    private InvestmentBuyAdapter investmentBuyAdapter;
    private InvestmentSIPAdapter investmentSIPAdapter;
    private InvestmentRedeemAdapter investmentRedeemAdapter;
    private InvestmentSwitchAdapter investmentSwitchAdapter;
    private InvestmentSWPAdapter investmentSWPAdapter;
    private InvestmentSTPAdapter investmentSTPAdapter;
    private InvestmentAccountAdapter investmentAccountAdapter;
    private BankAccountAdapter bankAccountAdapter;
    private View viewSip, viewBuy, viewRedeem, viewSwitch, viewSWP,viewSTP;
    private double totalAmt = 0;
    private Util util;
    private APIInterface apiInterface;
    private ArrayList<InvestmentCartCountResponse> investmentCartCountResponseArrayList = new ArrayList<>();
    private ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList = new ArrayList<>();
    private ArrayList<AccountsResponse> accountsResponseArrayList = new ArrayList<>();
    private ArrayList<BankAccountResponse> bankAccountResponseArrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_cart);

    }


    @Override
    public void getIds() {
        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        txtBuyImage = findViewById(R.id.txtBuyImage);

        linearBankDetail = findViewById(R.id.linearBankDetail);
        recyclerBuy = findViewById(R.id.recyclerBuy);
        recyclerSIP = findViewById(R.id.recyclerSIP);
        recyclerRedeem = findViewById(R.id.recyclerRedeem);
        recyclerSwitch = findViewById(R.id.recyclerSwitch);
        recyclerSWP = findViewById(R.id.recyclerSWP);
        recyclerSTP = findViewById(R.id.recyclerSTP);

        linearBuy = findViewById(R.id.linearBuy);
        linearSIP = findViewById(R.id.linearSIP);
        linearRedeem = findViewById(R.id.linearRedeem);
        linearSwitch = findViewById(R.id.linearSwitch);
        linearSWP = findViewById(R.id.linearSWP);
        linearSTP = findViewById(R.id.linearSTP);
        viewSip = findViewById(R.id.viewSip);
        viewBuy = findViewById(R.id.viewBuy);
        viewRedeem = findViewById(R.id.viewRedeem);
        viewSwitch = findViewById(R.id.viewSwitch);
        viewSWP = findViewById(R.id.viewSWP);
        viewSTP = findViewById(R.id.viewSTP);


        txtInvestmentTab = findViewById(R.id.txtInvestmentTab);
        txtTranCount = findViewById(R.id.txtTranCount);
        txtTotalAmount = findViewById(R.id.txtTotalAmount);

        spineerInvestmentAccount = findViewById(R.id.spineerInvestmentAccount);
        spineerBankAccount = findViewById(R.id.spineerBankAccount);
    }

    // investment account adapter
    private void setInvestmentAccountAdapter() {
        investmentAccountAdapter = new InvestmentAccountAdapter(getApplicationContext(), accountsResponseArrayList);
        spineerInvestmentAccount.setAdapter(investmentAccountAdapter);
    }

    // bank account adapter
    private void setBankAccountAdapter() {
        bankAccountAdapter = new BankAccountAdapter(getApplicationContext(), bankAccountResponseArrayList);
        spineerBankAccount.setAdapter(bankAccountAdapter);
    }


    @Override
    public void handleListener() {
        linearSIP.setOnClickListener(this);
        linearBuy.setOnClickListener(this);
        linearRedeem.setOnClickListener(this);
        linearSwitch.setOnClickListener(this);
        linearSWP.setOnClickListener(this);
        linearSTP.setOnClickListener(this);
        tvMenu.setOnClickListener(this);
    }


    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText(getString(R.string.investment_cart));
        apiInterface = BOBApp.getApi(this, Constants.ACTION_INVESTMENT_CART_COUNT);
        util = new Util(this);

        getInvestmentCartCountApiCall();

    }

    @Override
    void setIcon(Util util) {
        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
        FontManager.markAsIconContainer(txtBuyImage, util.iconFont);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.linearSIP) {
            txtTranCount.setText(investmentCartCountResponseArrayList.get(1).getTranCount() + " " + "Funds");

            txtInvestmentTab.setText(R.string.sip_);
            viewSip.setBackgroundColor(Color.parseColor("#f57222"));
            viewBuy.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewRedeem.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSWP.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSwitch.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSTP.setBackgroundColor(Color.parseColor("#D1D1D1"));

            recyclerBuy.setVisibility(View.GONE);
            recyclerRedeem.setVisibility(View.GONE);
            recyclerSwitch.setVisibility(View.GONE);
            recyclerSIP.setVisibility(View.VISIBLE);
            linearBankDetail.setVisibility(View.VISIBLE);
            recyclerSWP.setVisibility(View.GONE);
            recyclerSTP.setVisibility(View.GONE);
        } else if (id == R.id.linearBuy) {
            txtTranCount.setText(investmentCartCountResponseArrayList.get(0).getTranCount() + " " + "Funds");
            txtInvestmentTab.setText(R.string.buy_);
            viewBuy.setBackgroundColor(Color.parseColor("#f57222"));
            viewSip.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewRedeem.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSWP.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSwitch.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSTP.setBackgroundColor(Color.parseColor("#D1D1D1"));

            recyclerBuy.setVisibility(View.VISIBLE);
            recyclerSIP.setVisibility(View.GONE);
            recyclerRedeem.setVisibility(View.GONE);
            recyclerSwitch.setVisibility(View.GONE);
            linearBankDetail.setVisibility(View.VISIBLE);
            recyclerSWP.setVisibility(View.GONE);
            recyclerSTP.setVisibility(View.GONE);
        } else if (id == R.id.linearRedeem) {
            txtInvestmentTab.setText(R.string.redeem_);
            viewRedeem.setBackgroundColor(Color.parseColor("#f57222"));
            viewSip.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewBuy.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSWP.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSwitch.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSTP.setBackgroundColor(Color.parseColor("#D1D1D1"));
            linearBankDetail.setVisibility(View.GONE);
            recyclerRedeem.setVisibility(View.VISIBLE);
            recyclerBuy.setVisibility(View.GONE);
            recyclerSwitch.setVisibility(View.GONE);
            recyclerSIP.setVisibility(View.GONE);
            recyclerSWP.setVisibility(View.GONE);
            recyclerSTP.setVisibility(View.GONE);
        } else if (id == R.id.linearSwitch) {
            txtInvestmentTab.setText(R.string.switchs);
            viewSwitch.setBackgroundColor(Color.parseColor("#f57222"));
            viewSip.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewBuy.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewRedeem.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSWP.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSTP.setBackgroundColor(Color.parseColor("#D1D1D1"));
            linearBankDetail.setVisibility(View.GONE);
            recyclerRedeem.setVisibility(View.GONE);
            recyclerBuy.setVisibility(View.GONE);
            recyclerSIP.setVisibility(View.GONE);
            recyclerSwitch.setVisibility(View.VISIBLE);
            recyclerSWP.setVisibility(View.GONE);
            recyclerSTP.setVisibility(View.GONE);
        } else if (id == R.id.linearSWP) {
            txtInvestmentTab.setText(R.string.swp_);
            viewSWP.setBackgroundColor(Color.parseColor("#f57222"));
            viewSip.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewBuy.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewRedeem.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSwitch.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSTP.setBackgroundColor(Color.parseColor("#D1D1D1"));

            linearBankDetail.setVisibility(View.GONE);
            recyclerRedeem.setVisibility(View.GONE);
            recyclerBuy.setVisibility(View.GONE);
            recyclerSIP.setVisibility(View.GONE);
            recyclerSwitch.setVisibility(View.GONE);
            recyclerSWP.setVisibility(View.VISIBLE);
            recyclerSTP.setVisibility(View.GONE);
        } else if (id == R.id.linearSTP) {
            txtInvestmentTab.setText(R.string.stp_);
            viewSTP.setBackgroundColor(Color.parseColor("#f57222"));
            viewSip.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewBuy.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewRedeem.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSwitch.setBackgroundColor(Color.parseColor("#D1D1D1"));
            viewSWP.setBackgroundColor(Color.parseColor("#D1D1D1"));

            linearBankDetail.setVisibility(View.GONE);
            recyclerRedeem.setVisibility(View.GONE);
            recyclerBuy.setVisibility(View.GONE);
            recyclerSIP.setVisibility(View.GONE);
            recyclerSwitch.setVisibility(View.GONE);
            recyclerSWP.setVisibility(View.GONE);
            recyclerSTP.setVisibility(View.VISIBLE);
        } else if (id == R.id.menu) {
            finish();
        }
    }

    // buy adapter
    private void setInvestmentBuyAdapter(ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        investmentBuyAdapter = new InvestmentBuyAdapter(getApplicationContext(),investmentCartDetailsResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerBuy.setLayoutManager(linearLayoutManager);
        recyclerBuy.setAdapter(investmentBuyAdapter);

    }

    // sip adapter
    private void setInvestmentSIPAdapter(ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        investmentSIPAdapter = new InvestmentSIPAdapter(getApplicationContext(),investmentCartDetailsResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerSIP.setLayoutManager(linearLayoutManager);
        recyclerSIP.setAdapter(investmentSIPAdapter);
    }

    // redeem adapter
    private void setInvestmentRedeemAdapter(ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        investmentRedeemAdapter = new InvestmentRedeemAdapter(getApplicationContext(),investmentCartDetailsResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerRedeem.setLayoutManager(linearLayoutManager);
        recyclerRedeem.setAdapter(investmentRedeemAdapter);
    }

    // switch adapter
    private void setInvestmentSwitchAdapter(ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        investmentSwitchAdapter = new InvestmentSwitchAdapter(getApplicationContext(),investmentCartDetailsResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerSwitch.setLayoutManager(linearLayoutManager);
        recyclerSwitch.setAdapter(investmentSwitchAdapter);
    }

    // swp adapter
    private void setInvestmentSWPAdapter(ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        investmentSWPAdapter = new InvestmentSWPAdapter(getApplicationContext(),investmentCartDetailsResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerSWP.setLayoutManager(linearLayoutManager);
        recyclerSWP.setAdapter(investmentSWPAdapter);
    }

    // STP adapter
    private void setInvestmentSTPAdapter(ArrayList<InvestmentCartDetailsResponse> investmentCartDetailsResponseArrayList) {
        investmentSTPAdapter = new InvestmentSTPAdapter(getApplicationContext(),investmentCartDetailsResponseArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerSTP.setLayoutManager(linearLayoutManager);
        recyclerSTP.setAdapter(investmentSTPAdapter);
    }


    // api call
    private void getInvestmentCartCountApiCall() {
        util.showProgressDialog(this, true);

        InvestmentcartCountsRequestBody requestBody = new InvestmentcartCountsRequestBody();
        requestBody.setClientCode("32");
        requestBody.setParentChannelID("WMSPortal");

        InvestmentcartCountsRequest model = new InvestmentcartCountsRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getInvestmentCartCount(model).enqueue(new Callback<ArrayList<InvestmentCartCountResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<InvestmentCartCountResponse>> call, Response<ArrayList<InvestmentCartCountResponse>> response) {

                //    util.showProgressDialog(InvestmentCartActivity.this, false);

                if (response.isSuccessful()) {
                    investmentCartCountResponseArrayList = response.body();
                    txtTranCount.setText(investmentCartCountResponseArrayList.get(0).getTranCount() + " " + "Funds");
                    getInvestmentCartDetailsApiCall();

                } else {
                    Toast.makeText(InvestmentCartActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<InvestmentCartCountResponse>> call, Throwable t) {
                util.showProgressDialog(InvestmentCartActivity.this, false);
                Toast.makeText(InvestmentCartActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // api call
    private void getInvestmentCartDetailsApiCall() {

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        InvestmentCartDetailsRequestBody requestBody = new InvestmentCartDetailsRequestBody();
        requestBody.setClientCode("32");
        requestBody.setParentChannelID("WMSPortal");

        InvestmentCartDetailsRequest model = new InvestmentCartDetailsRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getInvestmentCartDetails(model).enqueue(new Callback<ArrayList<InvestmentCartDetailsResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<InvestmentCartDetailsResponse>> call, Response<ArrayList<InvestmentCartDetailsResponse>> response) {

                //    util.showProgressDialog(InvestmentCartActivity.this, false);
                if (response.isSuccessful()) {
                    investmentCartDetailsResponseArrayList = response.body();
                    for (int i = 0; i < investmentCartDetailsResponseArrayList.size(); i++) {
                        totalAmt = totalAmt + (Double.parseDouble(investmentCartDetailsResponseArrayList.get(i).getTxnAmountUnit()));
                    }
                    txtTotalAmount.setText("" + totalAmt);
                    setInvestmentBuyAdapter(investmentCartDetailsResponseArrayList);
                    setInvestmentSIPAdapter(investmentCartDetailsResponseArrayList);
                    setInvestmentRedeemAdapter(investmentCartDetailsResponseArrayList);
                    setInvestmentSwitchAdapter(investmentCartDetailsResponseArrayList);
                    setInvestmentSWPAdapter(investmentCartDetailsResponseArrayList);
                    setInvestmentSTPAdapter(investmentCartDetailsResponseArrayList);
                    getAccountsApiCall();

                } else {
                    Toast.makeText(InvestmentCartActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<InvestmentCartDetailsResponse>> call, Throwable t) {
                util.showProgressDialog(InvestmentCartActivity.this, false);
                Toast.makeText(InvestmentCartActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // api call
    private void getAccountsApiCall() {
        AccountRequestBody requestBody = new AccountRequestBody();
        requestBody.setClientCode("32");


        AccountsRequest model = new AccountsRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getAccounts(model).enqueue(new Callback<ArrayList<AccountsResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<AccountsResponse>> call, Response<ArrayList<AccountsResponse>> response) {

                //   util.showProgressDialog(InvestmentCartActivity.this, false);
                if (response.isSuccessful()) {
                    accountsResponseArrayList = response.body();
                    setInvestmentAccountAdapter();

                    getBankAccountsApiCall();
                } else {
                    Toast.makeText(InvestmentCartActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AccountsResponse>> call, Throwable t) {
                util.showProgressDialog(InvestmentCartActivity.this, false);
                Toast.makeText(InvestmentCartActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // api call
    private void getBankAccountsApiCall() {
        BankAccountBody requestBody = new BankAccountBody();
        requestBody.setClientCode("32");
        requestBody.setL4ClientCode("70");
        requestBody.setIsPortal("1");
        requestBody.setBankAccountTranNo("2");


        BankAccountRequest model = new BankAccountRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getBankAccount(model).enqueue(new Callback<ArrayList<BankAccountResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<BankAccountResponse>> call, Response<ArrayList<BankAccountResponse>> response) {

                util.showProgressDialog(InvestmentCartActivity.this, false);
                if (response.isSuccessful()) {
                    bankAccountResponseArrayList = response.body();
                    setBankAccountAdapter();
                } else {
                    Toast.makeText(InvestmentCartActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BankAccountResponse>> call, Throwable t) {
                util.showProgressDialog(InvestmentCartActivity.this, false);
                Toast.makeText(InvestmentCartActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
