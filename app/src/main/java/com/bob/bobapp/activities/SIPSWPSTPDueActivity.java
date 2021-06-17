package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

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

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.SIPSWPSTPDueListAdapter;
import com.bob.bobapp.adapters.TransactionListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestBodyModel;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestModel;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
import com.bob.bobapp.api.response_object.TransactionResponseModel;
import com.bob.bobapp.fragments.BaseFragment;
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

public class SIPSWPSTPDueActivity extends BaseFragment {

    private TextView calender,tvSelectedDate, tvGo, tvClear;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;

    private LinearLayout layoutDate;
    private int mYear, mMonth, mDay;
    private String strDateForRequest = "";
    private SIPSWPSTPDueListAdapter adapter;
    private ArrayList<SIPDueReportResponse> arrayList;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_s_i_p_s_w_p_s_t_p_due, container, false);
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
        BOBActivity.title.setText("SIP SWP STP Due");
        BOBActivity.llMenu.setVisibility(View.GONE);
        apiInterface = BOBApp.getApi(context, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(context);
        getSIPSWRSTPApiCall();
    }

    private void getSIPSWRSTPApiCall() {

        util.showProgressDialog(context, true);

        SIPSWPSTPRequestBodyModel requestBodyModel = new SIPSWPSTPRequestBodyModel();

        requestBodyModel.setUserId("admin");
        requestBodyModel.setUcc("069409856");
        requestBodyModel.setClientCode(0);
        requestBodyModel.setClientType("H");
        requestBodyModel.setFamCode(0);
        requestBodyModel.setFromDate("2020/06/14");
        requestBodyModel.setHeadCode(32);
        requestBodyModel.setReportType("SUMMARY");
        requestBodyModel.setToDate("2020/06/21");

        SIPSWPSTPRequestModel model = new SIPSWPSTPRequestModel();
        model.setRequestBodyObject(requestBodyModel);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getSIPDueReportApiCall(model).enqueue(new Callback<ArrayList<SIPDueReportResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<SIPDueReportResponse>> call, Response<ArrayList<SIPDueReportResponse>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {
                    arrayList = response.body();
                    setAdapter(arrayList);
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<SIPDueReportResponse>> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter(ArrayList<SIPDueReportResponse> arrayList) {

        if (arrayList != null && arrayList.size() > 0) {
            adapter = new SIPSWPSTPDueListAdapter(context, arrayList);
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

        ArrayList<SIPDueReportResponse> filteredList = new ArrayList<>();
        for (SIPDueReportResponse item : arrayList) {
            if (item.getNextInstallmentDate() != null) {
                if (item.getNextInstallmentDate().contains(text)) {
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

                    strDateForRequest = strDate;
                    textView.setText(strDate);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
