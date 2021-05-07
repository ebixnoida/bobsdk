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
import com.bob.bobapp.adapters.TransactionListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.TransactionRequestBodyModel;
import com.bob.bobapp.api.request_object.TransactionRequestModel;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.TransactionResponseModel;
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


public class TransactionActivity extends BaseActivity {

    private ArrayList<TransactionResponseModel> arrayList;

    private TransactionListAdapter adapter;

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, calender, tvSelectedDate, tvGo, tvClear;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;
    private TransactionResponseModel responseStr;
    private String whichActivity="";
    private LinearLayout layoutDate;
    private int mYear, mMonth, mDay;

    private String strDateForRequest = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
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

         whichActivity = getIntent().getStringExtra("WhichActivity");

        if (whichActivity.equalsIgnoreCase("TransactionActivity")) {
            tvTitle.setText("Transactions");
        } else {
            tvTitle.setText("Corporate Action");
        }
        apiInterface = BOBApp.getApi(this, Constants.ACTION_CLIENT_TRANSACTION);
        util = new Util(this);
        getTransactionApiCall();

    }

    private void getTransactionApiCall() {

        util.showProgressDialog(this, true);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        TransactionRequestBodyModel requestBodyModel = new TransactionRequestBodyModel();
        requestBodyModel.setUserId(authenticateResponse.getUserID());
        requestBodyModel.setOnlineAccountCode(authenticateResponse.getUserCode());
        requestBodyModel.setSchemeCode("0");
        requestBodyModel.setDateFrom("2020-01-07T00:00:00");
        requestBodyModel.setDateTo("2021-02-04T00:00:00");
        requestBodyModel.setOrderType("1");
        requestBodyModel.setPageIndex("0");
        requestBodyModel.setPageSize("0");
        requestBodyModel.setCurrencyCode("1");
        requestBodyModel.setAmountDenomination("0");
        requestBodyModel.setAccountLevel("0");
        requestBodyModel.setIsFundware("false");
        requestBodyModel.setClientType("H");

        TransactionRequestModel model = new TransactionRequestModel();
        model.setRequestBodyObject(requestBodyModel);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getTransactionApiCall(model).enqueue(new Callback<ArrayList<TransactionResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TransactionResponseModel>> call, Response<ArrayList<TransactionResponseModel>> response) {

                util.showProgressDialog(TransactionActivity.this, false);

                if (response.isSuccessful()) {

                    arrayList = response.body();

                    setAdapter(arrayList);

                } else {
                    Toast.makeText(TransactionActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<TransactionResponseModel>> call, Throwable t) {
                util.showProgressDialog(TransactionActivity.this, false);
                Toast.makeText(TransactionActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAdapter(ArrayList<TransactionResponseModel> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {

            adapter = new TransactionListAdapter(this,arrayList,whichActivity);

            rv.setAdapter(adapter);

        } else {

            Toast.makeText(TransactionActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    void setIcon(Util util) {

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
        FontManager.markAsIconContainer(calender, util.iconFont);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.menu:
                finish();
                break;

            case R.id.layout_date:
                openCalender(tvSelectedDate);
                break;

            case R.id.tv_go:

                String selectedDate = strDateForRequest;

                if(!selectedDate.equals("")) {

                    filter(selectedDate);
                }

                break;

            case R.id.tv_clear:

                strDateForRequest = "";

                tvSelectedDate.setText("Select Date");

                adapter.updateList(arrayList);

                break;
        }
    }

    private void filter(String text) {

        ArrayList<TransactionResponseModel> filteredList = new ArrayList<>();

        for (TransactionResponseModel item : arrayList) {

            if (item.getDate() != null) {

                if (item.getDate().contains(text)) {

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
