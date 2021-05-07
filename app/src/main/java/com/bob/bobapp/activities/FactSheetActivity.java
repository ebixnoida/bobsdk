package com.bob.bobapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.FactsheetAdapter;
import com.bob.bobapp.adapters.SectorWeightsChartListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.bean.FactsheetSchemePerformanceData;
import com.bob.bobapp.api.bean.SectorAllocationObject;
import com.bob.bobapp.api.bean.StockAllocationObject;
import com.bob.bobapp.api.request_object.FundDetailRequest;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.FundDetailResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.UUID;

public class FactSheetActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu;

    private TextView tvSchemeName, tvSchemeCategory, tvNAV, btnSIP, btnBuy, tvLaunchDate, tvSchemeType, tvInvestmentStrategyObjective, tvFundManagerName;

    private RecyclerView rvSchemePerformance,rvStockAllocation;

    private Util util;

    private Context context;

    private BarChart barChartYearOnYearPerformance;

    private HorizontalBarChart horizontalBarChartSectorAllocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fact_sheet);

        context = this;

        util = new Util(context);

        callFactsheetAPI();
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);

        tvBellHeader = findViewById(R.id.tvBellHeader);

        tvCartHeader = findViewById(R.id.tvCartHeader);

        tvMenu = findViewById(R.id.menu);

        tvTitle = findViewById(R.id.title);

        tvSchemeName = findViewById(R.id.tv_scheme_name);

        tvSchemeCategory = findViewById(R.id.tv_category);

        tvNAV = findViewById(R.id.tv_nav);

        btnSIP = findViewById(R.id.btn_sip);

        btnBuy = findViewById(R.id.btn_buy);

        tvLaunchDate = findViewById(R.id.tv_launch_date);

        tvSchemeType = findViewById(R.id.tv_scheme_type);

        tvInvestmentStrategyObjective = findViewById(R.id.tv_investment_strategy_objective);

        tvFundManagerName = findViewById(R.id.tv_fund_manager_name);

        barChartYearOnYearPerformance = findViewById(R.id.bar_chart_year_on_year_performance);

        rvSchemePerformance = findViewById(R.id.rv_scheme_performance);

        horizontalBarChartSectorAllocation = findViewById(R.id.bar_chart_sector_allocation);

        rvStockAllocation = findViewById(R.id.rv_stock_allocation);
    }

    @Override
    public void handleListener() {

        tvMenu.setOnClickListener(this);

        btnSIP.setOnClickListener(this);

        btnBuy.setOnClickListener(this);
    }

    @Override
    void initializations() {

        tvBellHeader.setVisibility(View.GONE);

        tvUserHeader.setVisibility(View.GONE);

        tvMenu.setText(getResources().getString(R.string.fa_icon_back));

        tvTitle.setText("FactSheet");

        setSectorWeightAdapter();
    }

    private void setSectorWeightAdapter() {

        Display display = getWindowManager().getDefaultDisplay();

        SectorWeightsChartListAdapter adpter=new SectorWeightsChartListAdapter(this,display);
    }

    @Override
    void setIcon(Util util) {

        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);

        FontManager.markAsIconContainer(tvMenu, util.iconFont);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.menu:

                finish();

                break;

            case R.id.btn_sip:

                finish();

                break;

            case R.id.btn_buy:

                finish();

                break;
        }
    }

    private void callFactsheetAPI() {

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_FACTSHEET);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setMWIClientCode(authenticateResponse.getUserCode());

        requestBodyObject.setSchemeCode("2113");

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        FundDetailRequest.createGlobalRequestObject(globalRequestObject);

        apiInterface.getFundDetailsResponse(FundDetailRequest.getGlobalRequestObject()).enqueue(new Callback<FundDetailResponse>() {
            @Override
            public void onResponse(Call<FundDetailResponse> call, Response<FundDetailResponse> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    FundDetailResponse fundDetailResponse = response.body();

                    setData(fundDetailResponse);

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FundDetailResponse> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setData(FundDetailResponse fundDetailResponse){

        tvSchemeName.setText(fundDetailResponse.getSchemeName());

        tvSchemeCategory.setText(fundDetailResponse.getCategory());

        String asOnDate = util.formatDateForFactsheet(fundDetailResponse.getNAVDate());

        double d = Double.parseDouble(String.valueOf(fundDetailResponse.getNAV()));

        d = util.truncateDecimal(d).doubleValue();

        tvNAV.setText(String.valueOf("₹ " + d) + " (as on " + asOnDate + ")");

        String launchDate = util.formatDateForFactsheet(fundDetailResponse.getLaunchDate());

        tvLaunchDate.setText(launchDate);

        tvSchemeType.setText(fundDetailResponse.getSchemeType());

        tvInvestmentStrategyObjective.setText(fundDetailResponse.getFundObjectives());

        tvFundManagerName.setText(fundDetailResponse.getFundManager());

        createYearOnYearPerformanceBarChart(fundDetailResponse);
    }

    private void createYearOnYearPerformanceBarChart(FundDetailResponse fundDetailResponse){

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        ArrayList<Integer> colors = new ArrayList<Integer>();

        entries.add(new BarEntry(fundDetailResponse.getReturns1Year(), 0));
        entries.add(new BarEntry(fundDetailResponse.getReturns3Year(), 1));
        entries.add(new BarEntry(fundDetailResponse.getReturns5Year(), 2));
        entries.add(new BarEntry(fundDetailResponse.getBenchmark1Year(), 3));
        entries.add(new BarEntry(fundDetailResponse.getBenchmark3Year(), 4));
        entries.add(new BarEntry(fundDetailResponse.getBenchmark5Year(), 5));

        labels.add("");
        labels.add("");
        labels.add("");
        labels.add("");
        labels.add("");
        labels.add("");

        colors.add(context.getResources().getColor(R.color.progressTintEquity));
        colors.add(context.getResources().getColor(R.color.progressTintEquity));
        colors.add(context.getResources().getColor(R.color.progressTintEquity));
        colors.add(context.getResources().getColor(R.color.progressTintEquity));
        colors.add(context.getResources().getColor(R.color.progressTintEquity));
        colors.add(context.getResources().getColor(R.color.progressTintEquity));


        BarDataSet dataset = new BarDataSet(entries, "");
        dataset.setColors(colors);

        BarData data = new BarData(labels, dataset);

        barChartYearOnYearPerformance.setData(data);

        barChartYearOnYearPerformance.setDescription("");

        barChartYearOnYearPerformance.animateY(5000);

        barChartYearOnYearPerformance.getAxisRight().setDrawGridLines(false);

        barChartYearOnYearPerformance.getAxisLeft().setDrawGridLines(false);

        barChartYearOnYearPerformance.getXAxis().setDrawGridLines(false);

        barChartYearOnYearPerformance.getLegend().setEnabled(false);

        XAxis xAxis = barChartYearOnYearPerformance.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis rightYAxis = barChartYearOnYearPerformance.getAxisRight();
        rightYAxis.setEnabled(false);

        createAndSetSchemePerformanceData(fundDetailResponse);
    }

    private void createAndSetSchemePerformanceData(FundDetailResponse fundDetailResponse){

        ArrayList<FactsheetSchemePerformanceData> arrayList = new ArrayList<FactsheetSchemePerformanceData>();

        FactsheetSchemePerformanceData factsheetSchemePerformanceData = new FactsheetSchemePerformanceData();

        factsheetSchemePerformanceData.setColumnOne("1 Month %");
        factsheetSchemePerformanceData.setColumnTwo(String.valueOf(fundDetailResponse.getReturns1Month()));
        factsheetSchemePerformanceData.setColumnThree(String.valueOf(fundDetailResponse.getBenchmark1Month()));
        arrayList.add(factsheetSchemePerformanceData);

        factsheetSchemePerformanceData = new FactsheetSchemePerformanceData();
        factsheetSchemePerformanceData.setColumnOne("3 Month %");
        factsheetSchemePerformanceData.setColumnTwo(String.valueOf(fundDetailResponse.getReturns3Month()));
        factsheetSchemePerformanceData.setColumnThree(String.valueOf(fundDetailResponse.getBenchmark3Month()));
        arrayList.add(factsheetSchemePerformanceData);

        factsheetSchemePerformanceData = new FactsheetSchemePerformanceData();
        factsheetSchemePerformanceData.setColumnOne("6 Month %");
        factsheetSchemePerformanceData.setColumnTwo(String.valueOf(fundDetailResponse.getReturns6Month()));
        factsheetSchemePerformanceData.setColumnThree(String.valueOf(fundDetailResponse.getBenchmark6Month()));
        arrayList.add(factsheetSchemePerformanceData);

        factsheetSchemePerformanceData = new FactsheetSchemePerformanceData();
        factsheetSchemePerformanceData.setColumnOne("12 Month %");
        factsheetSchemePerformanceData.setColumnTwo(String.valueOf(fundDetailResponse.getReturns1Year()));
        factsheetSchemePerformanceData.setColumnThree(String.valueOf(fundDetailResponse.getBenchmark1Year()));
        arrayList.add(factsheetSchemePerformanceData);

        setAdapter(arrayList, fundDetailResponse);
    }

    private void setAdapter(ArrayList<FactsheetSchemePerformanceData> arrayList, FundDetailResponse fundDetailResponse){

        FactsheetAdapter adapter = new FactsheetAdapter(context, arrayList);

        rvSchemePerformance.setAdapter(adapter);

        createSectorAllocationBarChart(fundDetailResponse);
    }

    private void createSectorAllocationBarChart(FundDetailResponse fundDetailResponse) {

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();

        if (fundDetailResponse.getSectorAllocationResponseCollection().size() > 0) {

            for (int i = 0; i < fundDetailResponse.getSectorAllocationResponseCollection().size(); i++) {

                SectorAllocationObject sectorAllocationObject = fundDetailResponse.getSectorAllocationResponseCollection().get(i);

                entries.add(new BarEntry(Float.parseFloat(sectorAllocationObject.getIndPercAllocation()), i));

                labels.add(sectorAllocationObject.getIndustry());
            }


            /*entries.add(new BarEntry(Float.parseFloat("78"), 0));
            entries.add(new BarEntry(Float.parseFloat("60"), 1));
            entries.add(new BarEntry(Float.parseFloat("50"), 2));
            entries.add(new BarEntry(Float.parseFloat("43"), 3));
            entries.add(new BarEntry(Float.parseFloat("30"), 4));
            entries.add(new BarEntry(Float.parseFloat("20"), 5));
            entries.add(new BarEntry(Float.parseFloat("12"), 6));

            labels.add("Financials");
            labels.add("Health Care");
            labels.add("Commodities");
            labels.add("Energy");
            labels.add("Transportation");
            labels.add("Pharmaceuticals");
            labels.add("Construction");*/


            BarDataSet dataset = new BarDataSet(entries, "");

            dataset.setColors(ColorTemplate.VORDIPLOM_COLORS);

            BarData data = new BarData(labels, dataset);

            horizontalBarChartSectorAllocation.setData(data);

            horizontalBarChartSectorAllocation.setDescription("");

            horizontalBarChartSectorAllocation.animateY(5000);

            horizontalBarChartSectorAllocation.getAxisLeft().setEnabled(false);
            horizontalBarChartSectorAllocation.getAxisRight().setEnabled(false);

            horizontalBarChartSectorAllocation.getAxisRight().setDrawGridLines(false);
            horizontalBarChartSectorAllocation.getAxisLeft().setDrawGridLines(false);

            horizontalBarChartSectorAllocation.getXAxis().setDrawGridLines(false);

            horizontalBarChartSectorAllocation.getLegend().setEnabled(false);

            XAxis xAxis = horizontalBarChartSectorAllocation.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);

            YAxis rightYAxis = horizontalBarChartSectorAllocation.getAxisRight();
            rightYAxis.setEnabled(false);

            horizontalBarChartSectorAllocation.getLayoutParams().height = entries.size() * 100;
        }

        createAndSetStockAllocationData(fundDetailResponse);
    }

    private void createAndSetStockAllocationData(FundDetailResponse fundDetailResponse){

        ArrayList<FactsheetSchemePerformanceData> arrayList = new ArrayList<FactsheetSchemePerformanceData>();

        for(int i = 0; i < fundDetailResponse.getStockAllocationResponseCollection().size(); i++){

            StockAllocationObject stockAllocationObject = fundDetailResponse.getStockAllocationResponseCollection().get(i);

            FactsheetSchemePerformanceData factsheetSchemePerformanceData = new FactsheetSchemePerformanceData();

            factsheetSchemePerformanceData.setColumnOne(stockAllocationObject.getCompany());
            factsheetSchemePerformanceData.setColumnTwo(stockAllocationObject.getType());
            factsheetSchemePerformanceData.setColumnThree(stockAllocationObject.getCompPercAllocation());
            arrayList.add(factsheetSchemePerformanceData);
        }

        setAdapterStockAllocation(arrayList, fundDetailResponse);
    }

    private void setAdapterStockAllocation(ArrayList<FactsheetSchemePerformanceData> arrayList, FundDetailResponse fundDetailResponse){

        FactsheetAdapter adapter = new FactsheetAdapter(context, arrayList);

        rvStockAllocation.setAdapter(adapter);
    }
}