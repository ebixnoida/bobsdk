package com.bob.bobapp.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;

import com.bob.bobapp.adapters.CashAdapter;
import com.bob.bobapp.adapters.DiscoverFundListAdapter;

import com.bob.bobapp.adapters.EquityAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.DiscoverFundRequest;
import com.bob.bobapp.api.request_object.DiscoverFundRequestBody;

import com.bob.bobapp.api.response_object.DiscoverFundResponse;
import com.bob.bobapp.api.response_object.LstRecommandationDebt;
import com.bob.bobapp.api.response_object.lstRecommandationCash;
import com.bob.bobapp.api.response_object.lstRecommandationEquity;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverFundsActivity extends BaseActivity {
    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, txtDebt, txtEquity, txtCash;
    private View viewDebt, viewEquity, viewCash;
    private RecyclerView rv, recyclerEquity, recyclerCash;
    private EditText etSearch;
    private APIInterface apiInterface;
    private Util util;
    private ArrayList<LstRecommandationDebt> lstRecommandationDebtArrayList = new ArrayList<>();
    private ArrayList<lstRecommandationEquity> lstRecommandationEquityArrayList = new ArrayList<>();
    private ArrayList<lstRecommandationCash> lstRecommandationCashArrayList = new ArrayList<>();
    private String searchKey = "", status = "1";
    private DiscoverFundListAdapter discoverFundListAdapter;
    private EquityAdapter equityAdapter;
    private CashAdapter cashAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_funds);
    }

    @Override
    public void getIds() {
        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        etSearch = findViewById(R.id.etSearch);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        rv = findViewById(R.id.rv);
        recyclerEquity = findViewById(R.id.recyclerEquity);
        recyclerCash = findViewById(R.id.recyclerCash);

        txtDebt = findViewById(R.id.txtDebt);
        viewDebt = findViewById(R.id.viewDebt);

        txtEquity = findViewById(R.id.txtEquity);
        viewEquity = findViewById(R.id.viewEquity);

        txtCash = findViewById(R.id.txtCash);
        viewCash = findViewById(R.id.viewCash);
    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);
        txtEquity.setOnClickListener(this);
        txtDebt.setOnClickListener(this);
        txtCash.setOnClickListener(this);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                searchKey = etSearch.getText().toString();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (status.equalsIgnoreCase("1")) {
                    filter(s.toString());
                } else if (status.equalsIgnoreCase("2")) {
                    filterEquity(s.toString());
                } else {
                    filterCash(s.toString());
                }
            }
        });

    }


    @Override
    void initializations() {
        rv.setNestedScrollingEnabled(false);
        recyclerEquity.setNestedScrollingEnabled(false);
        recyclerCash.setNestedScrollingEnabled(false);
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Discover Funds");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(this);
        getApiCall();
    }

    // api calling
    private void getApiCall() {
        util.showProgressDialog(this, true);

        DiscoverFundRequestBody discoverFundRequestBody = new DiscoverFundRequestBody();
        discoverFundRequestBody.setClientcode(32);

        DiscoverFundRequest model = new DiscoverFundRequest();
        model.setRequestBodyObject(discoverFundRequestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getDiscoverFundApiCall(model).enqueue(new Callback<DiscoverFundResponse>() {
            @Override
            public void onResponse(Call<DiscoverFundResponse> call, Response<DiscoverFundResponse> response) {

                util.showProgressDialog(DiscoverFundsActivity.this, false);
                if (response.isSuccessful()) {
                    lstRecommandationDebtArrayList = response.body().getLstRecommandationDebt();
                    lstRecommandationEquityArrayList = response.body().getLstRecommandationEquity();
                    lstRecommandationCashArrayList = response.body().getLstRecommandationCash();
                    setAdapter();
                }

            }

            @Override
            public void onFailure(Call<DiscoverFundResponse> call, Throwable t) {
                util.showProgressDialog(DiscoverFundsActivity.this, false);
                Toast.makeText(DiscoverFundsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }


    // set debt adapter
    private void setAdapter() {
        discoverFundListAdapter = new DiscoverFundListAdapter(this, lstRecommandationDebtArrayList);
        rv.setAdapter(discoverFundListAdapter);
    }

    // set equity adapter
    private void setEquityAdapter() {
        equityAdapter = new EquityAdapter(this, lstRecommandationEquityArrayList);
        recyclerEquity.setAdapter(equityAdapter);
    }

    // set cash adapter
    private void setCashAdapter() {
        cashAdapter = new CashAdapter(this, lstRecommandationCashArrayList);
        recyclerCash.setAdapter(cashAdapter);
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
        } else if (id == R.id.txtDebt) {
            status = "1";
            viewDebt.setBackgroundColor(Color.parseColor("#f57222"));
            viewEquity.setBackgroundColor(Color.parseColor("#696969"));
            viewCash.setBackgroundColor(Color.parseColor("#696969"));

            txtDebt.setTextColor(Color.parseColor("#211E0E"));
            txtEquity.setTextColor(Color.parseColor("#696969"));
            txtCash.setTextColor(Color.parseColor("#696969"));

            recyclerEquity.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            recyclerCash.setVisibility(View.GONE);

            setAdapter();
        } else if (id == R.id.txtEquity) {
            status = "2";
            viewEquity.setBackgroundColor(Color.parseColor("#f57222"));
            viewDebt.setBackgroundColor(Color.parseColor("#696969"));
            viewCash.setBackgroundColor(Color.parseColor("#696969"));

            txtEquity.setTextColor(Color.parseColor("#211E0E"));
            txtDebt.setTextColor(Color.parseColor("#696969"));
            txtCash.setTextColor(Color.parseColor("#696969"));

            recyclerEquity.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
            recyclerCash.setVisibility(View.GONE);

            setEquityAdapter();

        } else if (id == R.id.txtCash) {
            status = "3";
            viewCash.setBackgroundColor(Color.parseColor("#f57222"));
            viewEquity.setBackgroundColor(Color.parseColor("#696969"));
            viewDebt.setBackgroundColor(Color.parseColor("#696969"));

            txtCash.setTextColor(Color.parseColor("#211E0E"));
            txtDebt.setTextColor(Color.parseColor("#696969"));
            txtEquity.setTextColor(Color.parseColor("#696969"));

            recyclerEquity.setVisibility(View.GONE);
            rv.setVisibility(View.GONE);
            recyclerCash.setVisibility(View.VISIBLE);

            setCashAdapter();
        }


    }


    // filter
    private void filter(String text) {

        ArrayList<LstRecommandationDebt> filteredList = new ArrayList<>();

        for (LstRecommandationDebt item : lstRecommandationDebtArrayList) {

            if (item.getFundName() != null) {

                if (item.getFundName().toLowerCase().startsWith(text.toLowerCase())) {

                    filteredList.add(item);
                }
            }
        }

        discoverFundListAdapter.updateList(filteredList);
    }

    // equity filter
    private void filterEquity(String text) {

        ArrayList<lstRecommandationEquity> filteredList = new ArrayList<>();

        for (lstRecommandationEquity item : lstRecommandationEquityArrayList) {

            if (item.getFundName() != null) {

                if (item.getFundName().toLowerCase().startsWith(text.toLowerCase())) {

                    filteredList.add(item);
                }
            }
        }

        equityAdapter.updateList(filteredList);
    }

    // cash filter
    private void filterCash(String text) {

        ArrayList<lstRecommandationCash> filteredList = new ArrayList<>();

        for (lstRecommandationCash item : lstRecommandationCashArrayList) {

            if (item.getFundName() != null) {

                if (item.getFundName().toLowerCase().startsWith(text.toLowerCase())) {

                    filteredList.add(item);
                }
            }
        }

        cashAdapter.updateList(filteredList);
    }
}
