package com.bob.bobapp.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
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

public class DiscoverFundsActivity extends BaseFragment {
    private TextView txtDebt, txtEquity, txtCash;
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

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_discover_funds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {

        etSearch = view.findViewById(R.id.etSearch);

        rv = view.findViewById(R.id.rv);
        recyclerEquity = view.findViewById(R.id.recyclerEquity);
        recyclerCash = view.findViewById(R.id.recyclerCash);

        txtDebt = view.findViewById(R.id.txtDebt);
        viewDebt = view.findViewById(R.id.viewDebt);

        txtEquity = view.findViewById(R.id.txtEquity);
        viewEquity = view.findViewById(R.id.viewEquity);

        txtCash = view.findViewById(R.id.txtCash);
        viewCash = view.findViewById(R.id.viewCash);
    }

    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);
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
    public void initializations() {
        rv.setNestedScrollingEnabled(false);
        recyclerEquity.setNestedScrollingEnabled(false);
        recyclerCash.setNestedScrollingEnabled(false);
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("Discover Funds");
        apiInterface = BOBApp.getApi(context, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(context);
        getApiCall();
    }

    // api calling
    private void getApiCall() {
        util.showProgressDialog(context, true);

        DiscoverFundRequestBody discoverFundRequestBody = new DiscoverFundRequestBody();
        discoverFundRequestBody.setClientcode(32);

        DiscoverFundRequest model = new DiscoverFundRequest();
        model.setRequestBodyObject(discoverFundRequestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getDiscoverFundApiCall(model).enqueue(new Callback<DiscoverFundResponse>() {
            @Override
            public void onResponse(Call<DiscoverFundResponse> call, Response<DiscoverFundResponse> response) {

                util.showProgressDialog(context, false);
                if (response.isSuccessful()) {
                    lstRecommandationDebtArrayList = response.body().getLstRecommandationDebt();
                    lstRecommandationEquityArrayList = response.body().getLstRecommandationEquity();
                    lstRecommandationCashArrayList = response.body().getLstRecommandationCash();
                    setAdapter();
                }

            }

            @Override
            public void onFailure(Call<DiscoverFundResponse> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }


    // set debt adapter
    private void setAdapter() {
        discoverFundListAdapter = new DiscoverFundListAdapter(context, lstRecommandationDebtArrayList);
        rv.setAdapter(discoverFundListAdapter);
    }

    // set equity adapter
    private void setEquityAdapter() {
        equityAdapter = new EquityAdapter(context, lstRecommandationEquityArrayList);
        recyclerEquity.setAdapter(equityAdapter);
    }

    // set cash adapter
    private void setCashAdapter() {
        cashAdapter = new CashAdapter(context, lstRecommandationCashArrayList);
        recyclerCash.setAdapter(cashAdapter);
    }

    @Override
    public void setIcon(Util util) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.menu) {
            getActivity().onBackPressed();
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
        }else if (id == R.id.imgBack) {
            getActivity().onBackPressed();
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
