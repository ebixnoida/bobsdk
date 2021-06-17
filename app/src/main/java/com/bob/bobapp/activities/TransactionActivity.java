package com.bob.bobapp.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.TransactionListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.TransactionRequestBodyModel;
import com.bob.bobapp.api.request_object.TransactionRequestModel;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.api.response_object.TransactionResponseModel;
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TransactionActivity extends BaseFragment {

    private ArrayList<TransactionResponseModel> arrayList;

    private TransactionListAdapter adapter;

    private TextView calender, tvSelectedDate, tvGo, tvClear;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;
    private TransactionResponseModel responseStr;
    private String whichActivity="";
    private LinearLayout layoutDate;
    private int mYear, mMonth, mDay;

    private String strDateForRequest = "";

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_transactions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {
        calender = view.findViewById(R.id.calender);

        rv = view.findViewById(R.id.rv);

        tvSelectedDate = view.findViewById(R.id.tv_selected_date);
        layoutDate = view.findViewById(R.id.layout_date);
        tvGo = view.findViewById(R.id.tv_go);
        tvClear = view.findViewById(R.id.tv_clear);

    }

    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);
        layoutDate.setOnClickListener(this);
        tvGo.setOnClickListener(this);
        tvClear.setOnClickListener(this);
    }

    @Override
    public void initializations() {
        BOBActivity.llMenu.setVisibility(View.GONE);

        if(getArguments() != null) {

            whichActivity = getArguments().getString("WhichActivity");
        }

        if (whichActivity.equalsIgnoreCase("TransactionActivity")) {
            BOBActivity.title.setText("Transactions");
        } else {
            BOBActivity.title.setText("Corporate Action");
        }
        apiInterface = BOBApp.getApi(context, Constants.ACTION_CLIENT_TRANSACTION);
        util = new Util(context);
        getTransactionApiCall();

    }

    private void getTransactionApiCall() {

        util.showProgressDialog(context, true);

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
        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);

        apiInterface.getTransactionApiCall(model).enqueue(new Callback<ArrayList<TransactionResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TransactionResponseModel>> call, Response<ArrayList<TransactionResponseModel>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    arrayList = response.body();

                    setAdapter(arrayList);

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<TransactionResponseModel>> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setAdapter(ArrayList<TransactionResponseModel> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {

            adapter = new TransactionListAdapter(context,arrayList,whichActivity);

            rv.setAdapter(adapter);

        } else {

            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setIcon(Util util) {

        FontManager.markAsIconContainer(calender, util.iconFont);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.menu) {
            getActivity().onBackPressed();
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
        }else if (id == R.id.imgBack) {
            getActivity().onBackPressed();
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

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
