package com.bob.bobapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.AssetAllocationAdpter;
import com.bob.bobapp.adapters.ProductNameAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.bean.PortfolioPerformanceDetailCollection;
import com.bob.bobapp.api.bean.ProductValueBean;
import com.bob.bobapp.api.request_object.AssetAllocationPerformanceRequestObject;
import com.bob.bobapp.api.request_object.AssetAllocationRequestObject;
import com.bob.bobapp.api.request_object.ClientHoldingRequest;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.PortfolioPerformanceRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.response_object.AssetAllocationPerformanceResponseObject;
import com.bob.bobapp.api.response_object.AssetAllocationResponseObject;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.PortfolioPerformanceResponseObject;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PortfolioAnalytics extends BaseActivity {

    private ArrayList<ClientHoldingObject> clientHoldingObjectArrayList;

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu;

    private Util util;

    private Context context;

    private RecyclerView rvAssetAllocation, rvProductName, rvMutulFundSchemeCategory;

    private PieChart pieChartProductAllocation, pieChartMutualFundSchemeCategory;

    private BarChart barChart, portfolioBarChart;

    private HorizontalBarChart barChartMutualFundAMCExposure;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_portfolio_analytics);

        context = this;

        callAssetAllocationAPI();
    }

    @Override
    void setIcon(Util util) {

        this.util = util;

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);

        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);

        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);

        FontManager.markAsIconContainer(tvMenu, util.iconFont);
    }

    @Override
    public void getIds() {

        tvUserHeader = findViewById(R.id.tvUserHeader);

        tvBellHeader = findViewById(R.id.tvBellHeader);

        tvCartHeader = findViewById(R.id.tvCartHeader);

        tvMenu = findViewById(R.id.menu);

        tvTitle = findViewById(R.id.title);

        rvAssetAllocation = findViewById(R.id.rv_asset_allocation);

        rvProductName = findViewById(R.id.rv_product_allocation);

        rvMutulFundSchemeCategory = findViewById(R.id.rv_mutual_fund_scheme_category);

        pieChartProductAllocation = findViewById(R.id.pie_chart_product_allocation);

        pieChartMutualFundSchemeCategory = findViewById(R.id.pie_chart_mutual_fund_scheme_category);

        barChart = findViewById(R.id.bar_chart);

        portfolioBarChart = findViewById(R.id.bar_chart_portfolio_performance);

        barChartMutualFundAMCExposure = findViewById(R.id.bar_chart_mutual_fund_amc_exposure);
    }

    @Override
    public void handleListener() {

        tvUserHeader.setOnClickListener(this);

        tvMenu.setOnClickListener(this);
    }

    @Override
    void initializations() {

        tvMenu.setText(getResources().getString(R.string.fa_icon_back));

        tvTitle.setText("Portfolio Analytics");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.menu:

                finish();

                break;
        }
    }

    private void callAssetAllocationAPI() {

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_ASSET_ALLOCATION);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setUserId(authenticateResponse.getUserID());

        requestBodyObject.setLastBusinessDate(authenticateResponse.getBusinessDate());

        requestBodyObject.setClientCode(authenticateResponse.getUserCode());

        requestBodyObject.setAllocationType("2");

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAccountLevel("0"); //For client

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        AssetAllocationRequestObject.createGlobalRequestObject(globalRequestObject);

        apiInterface.getAssetAllocationAPIResponse(AssetAllocationRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<AssetAllocationResponseObject>>() {
            @Override
            public void onResponse(Call<ArrayList<AssetAllocationResponseObject>> call, Response<ArrayList<AssetAllocationResponseObject>> response) {

                if (response.isSuccessful()) {

                    setAssetAllocationAdapter(response.body());

                    getProductAllocationAPIResponse();

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<AssetAllocationResponseObject>> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAssetAllocationAdapter(ArrayList<AssetAllocationResponseObject> assetAllocationResponseObjectArrayList) {

        AssetAllocationAdpter assetAllocationAdpter = new AssetAllocationAdpter(context, assetAllocationResponseObjectArrayList);

        rvAssetAllocation.setAdapter(assetAllocationAdpter);
    }

    private void getProductAllocationAPIResponse(){

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_CLIENT_HOLDING);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setUserId(authenticateResponse.getUserID());

        requestBodyObject.setUserType(authenticateResponse.getUserType());

        requestBodyObject.setUserCode(authenticateResponse.getUserCode());

        requestBodyObject.setLastBusinessDate(authenticateResponse.getBusinessDate());

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAmountDenomination("0"); //For base

        requestBodyObject.setAccountLevel("0"); //For client

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        ClientHoldingRequest.createClientHoldingRequestObject(uniqueIdentifier, Constants.SOURCE, requestBodyObject);

        apiInterface.getHoldingResponse(ClientHoldingRequest.getClientHoldingRequestObject()).enqueue(new Callback<ArrayList<ClientHoldingObject>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<ClientHoldingObject>> call, @NonNull Response<ArrayList<ClientHoldingObject>> response) {

                if (response.isSuccessful()) {

                    clientHoldingObjectArrayList = response.body();

                    LinkedHashMap<String, String> productAllocationMap = new LinkedHashMap<String, String>();

                    String finalKey = "";

                    double marketValue = 0;

                    double valueOfCost = 0;

                    for(int i = 0; i < clientHoldingObjectArrayList.size(); i++){

                        ClientHoldingObject clientHoldingObject = clientHoldingObjectArrayList.get(i);

                        if(finalKey.equals(clientHoldingObject.getSource())){

                            marketValue = marketValue + Double.parseDouble(clientHoldingObject.getMarketValue());

                            valueOfCost = valueOfCost + Double.parseDouble(clientHoldingObject.getValueOfCost());

                        }else{

                            if(!finalKey.equals("")) {

                                double percentage = (marketValue/valueOfCost) * 100;

                                productAllocationMap.put(finalKey, String.valueOf(percentage));
                            }

                            finalKey = clientHoldingObject.getSource();

                            marketValue = Double.parseDouble(clientHoldingObject.getMarketValue());

                            valueOfCost = Double.parseDouble(clientHoldingObject.getValueOfCost());
                        }
                    }

                    System.out.println("PRODUCT ALLOCATION MAP: " + productAllocationMap);

                    setProductAllocationGraph(productAllocationMap);

                    getAssetAllocationPerformanceAPIResponse();

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ClientHoldingObject>> call, @NonNull Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProductAllocationGraph(LinkedHashMap<String, String> productAllocationMap) {

        ArrayList<Entry> entries = new ArrayList<>();

        ArrayList<String> labels = new ArrayList<String>();

        ArrayList<Integer> colors = new ArrayList<Integer>();

        ArrayList<ProductValueBean> productValueBeanArrayList = new ArrayList<ProductValueBean>();

        int index = 0;

        for (Map.Entry<String, String> entry : productAllocationMap.entrySet()) {

            entries.add(new Entry(Float.parseFloat(entry.getValue()), index));

            labels.add(entry.getKey());

            ProductValueBean productValueBean = new ProductValueBean();

            productValueBean.setLabel(entry.getKey());

            productValueBean.setPercentage(entry.getValue());

            productValueBeanArrayList.add(productValueBean);

            if(entry.getKey().contains("Cash")) {

                colors.add(context.getResources().getColor(R.color.progressTintCash));

            }else if(entry.getKey().contains("Debt")) {

                colors.add(context.getResources().getColor(R.color.progressTintDebt));

            }else if(entry.getKey().contains("Equity")) {

                colors.add(context.getResources().getColor(R.color.progressTintEquity));

            }else{

                colors.add(context.getResources().getColor(R.color.progressTint));
            }

            index = index + 1;
        }


        PieDataSet dataset = new PieDataSet(entries, "");

        PieData data = new PieData(labels, dataset);

        dataset.setColors(colors);

        dataset.setSliceSpace(5);

        dataset.setDrawValues(false);


        pieChartProductAllocation.setDrawHoleEnabled(true);

        pieChartProductAllocation.setHoleRadius(70);

        pieChartProductAllocation.setData(data);

        pieChartProductAllocation.setDescription("");

        pieChartProductAllocation.setDrawSliceText(false);

        pieChartProductAllocation.getLegend().setEnabled(false);

        pieChartProductAllocation.animateY(5000);

        setProductAdapter(productValueBeanArrayList);
    }

    private void setProductAdapter(ArrayList<ProductValueBean> productValueBeanArrayList) {

        ProductNameAdapter productNameAdapter = new ProductNameAdapter(context, productValueBeanArrayList);

        rvProductName.setAdapter(productNameAdapter);
    }

    private void getAssetAllocationPerformanceAPIResponse(){

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_ASSET_PERFORMANCE);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setUserId(authenticateResponse.getUserID());

        requestBodyObject.setUserType(authenticateResponse.getUserType());

        requestBodyObject.setUserCode(authenticateResponse.getUserCode());

        requestBodyObject.setLastBusinessDate(authenticateResponse.getBusinessDate());

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAmountDenomination("0"); //For base

        requestBodyObject.setIndexType("/0/,/999/,/1015/,/1016/,/1090/,/1091/");

        requestBodyObject.setAccountLevel("0"); //For client

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        AssetAllocationPerformanceRequestObject.createGlobalRequestObject(globalRequestObject);

        apiInterface.getAssetAllocationPerformanceAPIResponse(AssetAllocationPerformanceRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<AssetAllocationPerformanceResponseObject>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<AssetAllocationPerformanceResponseObject>> call, @NonNull Response<ArrayList<AssetAllocationPerformanceResponseObject>> response) {

                if (response.isSuccessful()) {

                    createAssetAllocationBarChart(response.body());

                    getPortfolioPerformanceAPIResponse();

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<AssetAllocationPerformanceResponseObject>> call, @NonNull Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createAssetAllocationBarChart(ArrayList<AssetAllocationPerformanceResponseObject> assetArrayList){

        ArrayList<BarEntry> entries = new ArrayList<>();

        ArrayList<String> labels = new ArrayList<String>();

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int i = 0; i < assetArrayList.size(); i++){

            AssetAllocationPerformanceResponseObject model = assetArrayList.get(i);

            entries.add(new BarEntry(Float.parseFloat(model.getXIRRPercentage()), i));

            labels.add(model.getAssetClass());

            if(model.getAssetClass().contains("Cash")) {

                colors.add(context.getResources().getColor(R.color.progressTintCash));

            }else if(model.getAssetClass().contains("Debt")) {

                colors.add(context.getResources().getColor(R.color.progressTintDebt));

            }else if(model.getAssetClass().contains("Equity")) {

                colors.add(context.getResources().getColor(R.color.progressTintEquity));

            }else{

                colors.add(context.getResources().getColor(R.color.progressTint));
            }
        }

        BarDataSet dataset = new BarDataSet(entries, "");

        //dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        dataset.setColors(colors);

        BarData data = new BarData(labels, dataset);

        barChart.setData(data);

        barChart.setDescription("");

        barChart.animateY(5000);

        barChart.getAxisRight().setDrawGridLines(false);

        barChart.getAxisLeft().setDrawGridLines(false);

        barChart.getXAxis().setDrawGridLines(false);

        barChart.getLegend().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis rightYAxis = barChart.getAxisRight();
        rightYAxis.setEnabled(false);
    }

    private void getPortfolioPerformanceAPIResponse(){

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_PORTFOLIO_PERFORMANCE);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        /*requestBodyObject.setUserId(authenticateResponse.getUserID());

        requestBodyObject.setUserId("admin");

        requestBodyObject.setClientCode("1");

        requestBodyObject.setIndexType("/0/,/1015/,/1016/,/1059/,/4/");

        requestBodyObject.setLastBusinessDate(authenticateResponse.getBusinessDate());

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAmountDenomination("0"); //For base

        requestBodyObject.setAccountLevel("0"); //For client

        requestBodyObject.setIsFundware("false");*/

        requestBodyObject.setUserId("admin");

        requestBodyObject.setClientCode("447");

        requestBodyObject.setIndexType("0");

        requestBodyObject.setLastBusinessDate("2021-03-15T11:32:20.0921684+05:30");

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAmountDenomination("0"); //For base

        requestBodyObject.setAccountLevel("0"); //For client

        requestBodyObject.setIsFundware("false");


        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        PortfolioPerformanceRequestObject.createGlobalRequestObject(globalRequestObject);

        apiInterface.getPortfolioPerformanceAPIResponse(PortfolioPerformanceRequestObject.getGlobalRequestObject()).enqueue(new Callback<PortfolioPerformanceResponseObject>() {

            @Override
            public void onResponse(@NonNull Call<PortfolioPerformanceResponseObject> call, @NonNull Response<PortfolioPerformanceResponseObject> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    ArrayList<PortfolioPerformanceDetailCollection> assetArrayList = response.body().getPortfolioPerformanceDetailCollection();

                    PortfolioPerformanceDetailCollection portfolioPerformanceDetailCollection = new PortfolioPerformanceDetailCollection();

                    portfolioPerformanceDetailCollection.setReturnSinceInception("2.1");

                    portfolioPerformanceDetailCollection.setYTDReturn("4.1");

                    portfolioPerformanceDetailCollection.setQTDReturn("6.1");

                    assetArrayList.add(portfolioPerformanceDetailCollection);

                    createPortfolioPerformanceBarChart(assetArrayList);

                    getMutualFundSchemeCategoryData();

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PortfolioPerformanceResponseObject> call, @NonNull Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createPortfolioPerformanceBarChart(ArrayList<PortfolioPerformanceDetailCollection> assetArrayList){

        ArrayList<BarEntry> entries = new ArrayList<>();

        ArrayList<String> labels = new ArrayList<String>();

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int i = 0; i < assetArrayList.size(); i++){

            PortfolioPerformanceDetailCollection model = assetArrayList.get(i);


            entries.add(new BarEntry(Float.parseFloat(model.getReturnSinceInception()), 0));

            entries.add(new BarEntry(Float.parseFloat(model.getYTDReturn()), 1));

            entries.add(new BarEntry(Float.parseFloat(model.getQTDReturn()), 2));


            labels.add("Inception");

            labels.add("Year to Date");

            labels.add("Last Qtr");


            colors.add(context.getResources().getColor(R.color.progressTintEquity));

            colors.add(context.getResources().getColor(R.color.progressTintEquity));

            colors.add(context.getResources().getColor(R.color.progressTintEquity));
        }

        BarDataSet dataset = new BarDataSet(entries, "");

        dataset.setColors(colors);

        BarData data = new BarData(labels, dataset);

        portfolioBarChart.setData(data);

        portfolioBarChart.setDescription("");

        portfolioBarChart.animateY(5000);

        portfolioBarChart.getAxisRight().setDrawGridLines(false);

        portfolioBarChart.getAxisLeft().setDrawGridLines(false);

        portfolioBarChart.getXAxis().setDrawGridLines(false);

        portfolioBarChart.getLegend().setEnabled(false);

        XAxis xAxis = portfolioBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis rightYAxis = portfolioBarChart.getAxisRight();
        rightYAxis.setEnabled(false);
    }

    private void getMutualFundSchemeCategoryData(){

        LinkedHashMap<String, String> mutualFundSchemeCategoryMap = new LinkedHashMap<String, String>();

        String finalKey = "";

        double marketValue = 0;

        double valueOfCost = 0;

        for(int i = 0; i < clientHoldingObjectArrayList.size(); i++){

            ClientHoldingObject clientHoldingObject = clientHoldingObjectArrayList.get(i);

            if(clientHoldingObject.getClassification() != null) {

                if (finalKey.equals(clientHoldingObject.getClassification())) {

                    marketValue = marketValue + Double.parseDouble(clientHoldingObject.getMarketValue());

                    valueOfCost = valueOfCost + Double.parseDouble(clientHoldingObject.getValueOfCost());

                } else {

                    if (!finalKey.equals("")) {

                        double percentage = (marketValue / valueOfCost) * 100;

                        if(String.valueOf(percentage).equalsIgnoreCase("NAN")){

                            percentage = 0;
                        }

                        mutualFundSchemeCategoryMap.put(finalKey, String.valueOf(percentage));
                    }

                    finalKey = clientHoldingObject.getClassification();

                    marketValue = Double.parseDouble(clientHoldingObject.getMarketValue());

                    valueOfCost = Double.parseDouble(clientHoldingObject.getValueOfCost());
                }
            }

            if(mutualFundSchemeCategoryMap.size() == 4){

                break;
            }
        }

        System.out.println("MUTUAL FUND SCHEME CATEGORY ALLOCATION MAP: " + mutualFundSchemeCategoryMap);

        setMutulFundSchemeCategoryGraph(mutualFundSchemeCategoryMap);
    }

    private void setMutulFundSchemeCategoryGraph(LinkedHashMap<String, String> productAllocationMap) {

        ArrayList<Entry> entries = new ArrayList<>();

        ArrayList<String> labels = new ArrayList<String>();

        ArrayList<Integer> colors = new ArrayList<Integer>();

        ArrayList<ProductValueBean> productValueBeanArrayList = new ArrayList<ProductValueBean>();

        int index = 0;

        for (Map.Entry<String, String> entry : productAllocationMap.entrySet()) {

            entries.add(new Entry(Float.parseFloat(entry.getValue()), index));

            labels.add(entry.getKey());

            if(entry.getKey().contains("Large")) {

                colors.add(context.getResources().getColor(R.color.progressTintCash));

            }else if(entry.getKey().contains("Value")) {

                colors.add(context.getResources().getColor(R.color.progressTintDebt));

            }else if(entry.getKey().contains("Multi")) {

                colors.add(context.getResources().getColor(R.color.progressTintEquity));

            }else{

                colors.add(context.getResources().getColor(R.color.progressTint));
            }


            ProductValueBean productValueBean = new ProductValueBean();

            productValueBean.setLabel(entry.getKey());

            productValueBean.setPercentage(entry.getValue());

            productValueBeanArrayList.add(productValueBean);


            index = index + 1;
        }


        PieDataSet dataset = new PieDataSet(entries, "");

        PieData data = new PieData(labels, dataset);

        dataset.setColors(colors);

        dataset.setSliceSpace(5);

        dataset.setDrawValues(false);


        pieChartMutualFundSchemeCategory.setDrawHoleEnabled(true);

        pieChartMutualFundSchemeCategory.setHoleRadius(70);

        pieChartMutualFundSchemeCategory.setData(data);

        pieChartMutualFundSchemeCategory.setDescription("");

        pieChartMutualFundSchemeCategory.setDrawSliceText(false);

        pieChartMutualFundSchemeCategory.getLegend().setEnabled(false);

        pieChartMutualFundSchemeCategory.animateY(5000);

        setMutualFundSchemeCategoryAdapter(productValueBeanArrayList);
    }

    private void setMutualFundSchemeCategoryAdapter(ArrayList<ProductValueBean> productValueBeanArrayList) {

        ProductNameAdapter productNameAdapter = new ProductNameAdapter(context, productValueBeanArrayList);

        rvMutulFundSchemeCategory.setAdapter(productNameAdapter);

        getMutualFundAMCExposureData();
    }

    private void getMutualFundAMCExposureData(){

        LinkedHashMap<String, String> mutualFundMap = new LinkedHashMap<String, String>();

        String finalKey = "";

        double marketValue = 0;

        double valueOfCost = 0;

        for(int i = 0; i < clientHoldingObjectArrayList.size(); i++){

            ClientHoldingObject clientHoldingObject = clientHoldingObjectArrayList.get(i);

            if(clientHoldingObject.getIssuer() != null) {

                if (finalKey.equals(clientHoldingObject.getIssuer())) {

                    marketValue = marketValue + Double.parseDouble(clientHoldingObject.getMarketValue());

                    valueOfCost = valueOfCost + Double.parseDouble(clientHoldingObject.getValueOfCost());

                } else {

                    if (!finalKey.equals("")) {

                        double percentage = (marketValue / valueOfCost) * 100;

                        if(String.valueOf(percentage).equalsIgnoreCase("NAN")){

                            percentage = 0;
                        }

                        mutualFundMap.put(finalKey, String.valueOf(percentage));
                    }

                    finalKey = clientHoldingObject.getIssuer();

                    marketValue = Double.parseDouble(clientHoldingObject.getMarketValue());

                    valueOfCost = Double.parseDouble(clientHoldingObject.getValueOfCost());
                }
            }
        }

        System.out.println("MUTUAL FUND SCHEME CATEGORY ALLOCATION MAP: " + mutualFundMap);

        createBarChartMutualFundExposure(mutualFundMap);
    }

    private void createBarChartMutualFundExposure(LinkedHashMap<String, String> mutualFundMap){

        ArrayList<BarEntry> entries = new ArrayList<>();

        ArrayList<String> labels = new ArrayList<String>();

        ArrayList<Integer> colors = new ArrayList<Integer>();

        ArrayList<ProductValueBean> productValueBeanArrayList = new ArrayList<ProductValueBean>();

        int index = 0;

        for (Map.Entry<String, String> entry : mutualFundMap.entrySet()) {

            entries.add(new BarEntry(Float.parseFloat(entry.getValue()), index));

            labels.add(entry.getKey());

            if(entry.getKey().contains("Large")) {

                colors.add(context.getResources().getColor(R.color.progressTintCash));

            }else if(entry.getKey().contains("Value")) {

                colors.add(context.getResources().getColor(R.color.progressTintDebt));

            }else if(entry.getKey().contains("Multi")) {

                colors.add(context.getResources().getColor(R.color.progressTintEquity));

            }else{

                colors.add(context.getResources().getColor(R.color.progressTint));
            }


            ProductValueBean productValueBean = new ProductValueBean();

            productValueBean.setLabel(entry.getKey());

            productValueBean.setPercentage(entry.getValue());

            productValueBeanArrayList.add(productValueBean);


            index = index + 1;
        }

        BarDataSet dataset = new BarDataSet(entries, "");

        //dataset.setColors(colors);
        dataset.setColors(ColorTemplate.VORDIPLOM_COLORS);

        BarData data = new BarData(labels, dataset);

        barChartMutualFundAMCExposure.setData(data);

        barChartMutualFundAMCExposure.setDescription("");

        barChartMutualFundAMCExposure.animateY(5000);

        barChartMutualFundAMCExposure.getAxisLeft().setEnabled(false);
        barChartMutualFundAMCExposure.getAxisRight().setEnabled(false);

        barChartMutualFundAMCExposure.getAxisRight().setDrawGridLines(false);
        barChartMutualFundAMCExposure.getAxisLeft().setDrawGridLines(false);

        barChartMutualFundAMCExposure.getXAxis().setDrawGridLines(false);


        barChartMutualFundAMCExposure.getLegend().setEnabled(false);

        XAxis xAxis = barChartMutualFundAMCExposure.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);

        YAxis rightYAxis = barChartMutualFundAMCExposure.getAxisRight();
        rightYAxis.setEnabled(false);

        barChartMutualFundAMCExposure.getLayoutParams().height = mutualFundMap.size() * 100;
    }
}
