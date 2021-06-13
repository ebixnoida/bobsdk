package com.bob.bobapp.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.InvestmentMaturityListAdapter;
import com.bob.bobapp.adapters.RealizaedGainLossListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.MaturitiesReportModel;
import com.bob.bobapp.api.request_object.MaturityReportRequestModel;
import com.bob.bobapp.api.request_object.RealisedGainLossRequestModel;
import com.bob.bobapp.api.request_object.RealizedGainLossRequestBodyModel;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.api.response_object.RealizedGainLoss;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RealizedGainLossActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, calender,tvSelectedDate, tvGo, tvClear;;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;
    private LinearLayout layoutDate;
    private int mYear, mMonth, mDay;
    private String strDateForRequest = "";
    private ArrayList<RealizedGainLoss> arrayList;
    private RealizaedGainLossListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realized_gain_loss);
    }

    @Override
    public void getIds() {
        calender = findViewById(R.id.calender);
        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        rv = findViewById(R.id.rv);

        tvSelectedDate = findViewById(R.id.tv_selected_date);
        layoutDate = findViewById(R.id.layout_date);
        tvGo = findViewById(R.id.tv_go);
        tvClear = findViewById(R.id.tv_clear);

    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);
        layoutDate.setOnClickListener(this);
        tvGo.setOnClickListener(this);
        tvClear.setOnClickListener(this);

    }


    @Override
    void initializations() {
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Realized Gain/Loss");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_REALISED_GAIN_LOSS);
        util = new Util(this);
        getApiCall();

    }

    @Override
    void setIcon(Util util) {

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
        FontManager.markAsIconContainer(calender, util.iconFont);

    }


    private void getApiCall() {

        util.showProgressDialog(this, true);

        RealizedGainLossRequestBodyModel model = new RealizedGainLossRequestBodyModel();
        model.setFamClient("H");
        model.setBOCode("32");
        model.setScripCode("0");
        model.setFromDate("2016/01/01");
        model.setToDate("2020/06/14");
        model.setUserId("admin");
        model.setSchemeCode(0);
        model.setFamCode(0);
        model.setInvestType("A");
        model.setCurrencyCode(1);
        model.setAmountIn(0);
        model.setIsFundware(false);

        RealisedGainLossRequestModel requestModel = new RealisedGainLossRequestModel();
        requestModel.setRequestBodyObject(model);
        requestModel.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        requestModel.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getRealisedGainLossReportApiCall(requestModel).enqueue(new Callback<ArrayList<RealizedGainLoss>>() {
            @Override
            public void onResponse(Call<ArrayList<RealizedGainLoss>> call, Response<ArrayList<RealizedGainLoss>> response) {
                util.showProgressDialog(RealizedGainLossActivity.this, false);

                if (response.isSuccessful()) {
                    arrayList=response.body();
                    setAdapter(arrayList);
                } else {
                    Toast.makeText(RealizedGainLossActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RealizedGainLoss>> call, Throwable t) {
                util.showProgressDialog(RealizedGainLossActivity.this, false);
                Toast.makeText(RealizedGainLossActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<RealizedGainLoss> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
             adapter = new RealizaedGainLossListAdapter(this, arrayList);
            rv.setAdapter(adapter);
        } else {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.menu) {
            finish();
        } else if (id == R.id.layout_date) {
            openCalender(tvSelectedDate);
        } else if (id == R.id.tv_go) {
            String selectedDate = strDateForRequest;
            if (!selectedDate.equals("")) {
                filter(selectedDate);
            }
        } else if (id == R.id.tv_clear) {
            strDateForRequest = "";
            tvSelectedDate.setText("Select Date");
            adapter.updateList(arrayList);
        }
    }

    private void filter(String text) {

        ArrayList<RealizedGainLoss> filteredList = new ArrayList<>();
        for (RealizedGainLoss item : arrayList) {
            if (item.getOpenDate() != null) {
                if (item.getOpenDate().contains(text)) {
                    filteredList.add(item);
                }
            }
        }

        adapter.updateList(filteredList);
    }

    private void openCalender(final TextView textView){

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                try {
                    String dateStr = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = format.parse(dateStr);
                    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                    String strDate = dateFormat.format(date);
                    DateFormat dateFormatForRequest = new SimpleDateFormat("yyyy-MM-dd");
                    strDateForRequest = dateFormatForRequest.format(date);
                    textView.setText(strDate);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}

