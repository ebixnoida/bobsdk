package com.bob.bobapp.fragments;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.activities.DematHoldingActivity;
import com.bob.bobapp.activities.DiscoverFundsActivity;
import com.bob.bobapp.activities.HoldingsActivity;
import com.bob.bobapp.activities.BOBActivity;
import com.bob.bobapp.activities.OrderStatusActivity;
import com.bob.bobapp.activities.RiskProfileActivity;
import com.bob.bobapp.activities.StopSIPActivity;
import com.bob.bobapp.adapters.DashboardTransactionListAdapter;
import com.bob.bobapp.adapters.ExploreMoreListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.RMDetailRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.request_object.TransactionRequestBodyModel;
import com.bob.bobapp.api.request_object.TransactionRequestModel;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.RMDetailResponseObject;
import com.bob.bobapp.api.response_object.TransactionResponseModel;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static android.content.Context.WINDOW_SERVICE;

public class DashboardFragment extends BaseFragment {

    private LinearLayout llMenu;

    private RecyclerView rvTransaction, rvExploreMore;

    private LinearLayout existingPortfolio, llAmount;

    private TextView startNow, tvCurrentValue, tvInvestedAmount, tvGainLoss, tvDevidendInterest, tvNetGain, tvIRR,
            tvNetGainPercent, tvRiskProfileValue, btnReAccessRiskProfile,btn_Details;

    private CardView cvNewFund;

    private ImageView imageViewRightArrow;

    private Context context;

    private Util util;

    private ArrayList<TransactionResponseModel> transactionResponseModelArrayList;

    private ArrayList<ClientHoldingObject> clientHoldingObjectArrayList;

    private int currentIndex = 0;

    private PieChart riskProfilePieChart;

    private ImageView imgDashbaord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        String response = SettingPreferences.getHoldingResponse(getActivity());

        Type listType = new TypeToken<List<ClientHoldingObject>>(){}.getType();

        clientHoldingObjectArrayList = new Gson().fromJson(response, listType);
    }

    @Override
    protected void setIcon(Util util) {

    }

    @Override
    protected void getIds(View view) {

        rvTransaction = view.findViewById(R.id.rvTransaction);

        rvExploreMore = view.findViewById(R.id.rvExploreMore);

        existingPortfolio = view.findViewById(R.id.existingPortfolio);

        llAmount = view.findViewById(R.id.llAmount);

        startNow = view.findViewById(R.id.startNow);

        cvNewFund = view.findViewById(R.id.cvNewFund);

        tvCurrentValue = view.findViewById(R.id.tv_current_value);

        tvInvestedAmount = view.findViewById(R.id.tv_invested_amount_value);

        tvGainLoss = view.findViewById(R.id.tv_utilized_gain_or_loss_value);

        tvDevidendInterest = view.findViewById(R.id.tv_utilized_devidend_or_interest_value);

        tvNetGain = view.findViewById(R.id.tv_utilized_net_gain_value);

        tvIRR = view.findViewById(R.id.tv_irr_value);

        tvNetGainPercent = view.findViewById(R.id.tv_utilized_net_gain_percent_value);

        tvRiskProfileValue = view.findViewById(R.id.tv_risk_profile_value);

        imageViewRightArrow = view.findViewById(R.id.img_right_arrow);

        btnReAccessRiskProfile = view.findViewById(R.id.btn_re_access_risk_profile);

        riskProfilePieChart = view.findViewById(R.id.risk_profile_view);

        btn_Details = view.findViewById(R.id.btn_Details);

        imgDashbaord = view.findViewById(R.id.imgDashbaord);

        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);

        drawerMenuView = (LinearLayout) view.findViewById(R.id.drawerMenuLLayout);

        callRMDetailAPI();

        setRiskProfile();
    }

    private void setRiskProfile() {

        float low = Float.parseFloat("1.0");

        float medium = Float.parseFloat("1.0");

        float high = Float.parseFloat("1.0");

        float conservative = Float.parseFloat("1.0");

        float aggressive = Float.parseFloat("1.0");

        riskProfilePieChart.setDrawHoleEnabled(true);

        riskProfilePieChart.setHoleRadius(70);


        ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(low, 0));

        entries.add(new Entry(medium, 1));

        entries.add(new Entry(high, 2));

        entries.add(new Entry(conservative, 3));

        entries.add(new Entry(aggressive, 4));

        PieDataSet dataset = new PieDataSet(entries, "");

        ArrayList<String> labels = new ArrayList<String>();

        labels.add("Low");

        labels.add("Medium");

        labels.add("High");

        labels.add("Conservative");

        labels.add("Aggressive");

        final int[] MY_COLORS = {Color.rgb(0, 145, 0), Color.rgb(134, 183, 0), Color.rgb(255, 224, 0), Color.rgb(255, 143, 0), Color.rgb(254, 1, 0)};

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : MY_COLORS) colors.add(c);

        PieData data = new PieData(labels, dataset);

        dataset.setColors(colors);

        dataset.setSliceSpace(1);

        dataset.setDrawValues(false);

        riskProfilePieChart.setData(data);

        riskProfilePieChart.setDescription("");

        riskProfilePieChart.setDrawSliceText(false);

        riskProfilePieChart.getLegend().setEnabled(false);

        riskProfilePieChart.animateY(5000);

        riskProfilePieChart.setMaxAngle(180);

        riskProfilePieChart.setRotationAngle(-180);

        riskProfilePieChart.setTouchEnabled(false);

        String riskValue = SettingPreferences.getRiskProfile(context);

        int index = labels.indexOf(riskValue);

        Highlight highlight = new Highlight(index, 0, 0);

        riskProfilePieChart.highlightValue(highlight); //call onValueSelected()
    }

    private void setData(int currentIndex)
    {

        ClientHoldingObject clientHoldingObject = clientHoldingObjectArrayList.get(currentIndex);

        tvCurrentValue.setText(clientHoldingObject.getMarketValue());

        tvInvestedAmount.setText(clientHoldingObject.getValueOfCost());

        double gainLossValue = Double.parseDouble(clientHoldingObject.getMarketValue()) - Double.parseDouble(clientHoldingObject.getValueOfCost());

        gainLossValue = util.truncateDecimal(gainLossValue).doubleValue();

        tvGainLoss.setText(String.valueOf(gainLossValue));

        tvDevidendInterest.setText(clientHoldingObject.getDividend());

        tvNetGain.setText(clientHoldingObject.getNetGain());

        double irrValue = util.truncateDecimal(Double.parseDouble(clientHoldingObject.getGainLossPercentage())).doubleValue();

        tvIRR.setText(String.valueOf(irrValue) + "%");

        double percentValue = util.truncateDecimal(Double.parseDouble(clientHoldingObject.getGainLossPercentage())).doubleValue();

        tvNetGainPercent.setText(String.valueOf(percentValue) + "%");

        String riskValue = SettingPreferences.getRiskProfile(context);

        tvRiskProfileValue.setText(riskValue);
    }

    @Override
    protected void handleListener() {

        existingPortfolio.setOnClickListener(this);

        llAmount.setOnClickListener(this);

        startNow.setOnClickListener(this);

        cvNewFund.setOnClickListener(this);

        imageViewRightArrow.setOnClickListener(this);

        btnReAccessRiskProfile.setOnClickListener(this);

        btn_Details.setOnClickListener(this);

        BOBActivity.imgBack.setOnClickListener(this);

        BOBActivity.llMenu.setVisibility(View.VISIBLE);

        BOBActivity.llMenu.setOnClickListener(this);

        //imgDashbaord.setOnClickListener(this);
    }

    @Override
    protected void initializations() {

        BOBActivity.title.setText("Dashboard");

        manageLeftSideDrawer();

        rvTransaction.setNestedScrollingEnabled(false);

        getTransactionApiCall();

        setExploreMoreAdapter();
    }

    private void setExploreMoreAdapter() {

        ArrayList<String> exploreMoreArrayList = new ArrayList<String>();

        exploreMoreArrayList.add("Equity Funds");

        exploreMoreArrayList.add("Debt Funds");

        exploreMoreArrayList.add("Tax Saving");

        ExploreMoreListAdapter adapter = new ExploreMoreListAdapter(getActivity(), exploreMoreArrayList) {

            @Override
            public void getDetail(Fragment fragment) {

                replaceFragment(fragment);
            }
        };

        rvExploreMore.setAdapter(adapter);
    }

    private void setDashboardTransactionListAdapter(ArrayList<TransactionResponseModel> transactionResponseModelArrayList) {

        DashboardTransactionListAdapter adapter = new DashboardTransactionListAdapter(getActivity(), transactionResponseModelArrayList);

        rvTransaction.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.llMenu) {

            menuButton();

        }else if (id == R.id.existingPortfolio) {

            ((BOBActivity) getActivity()).setTransactTab();

        } else if (id == R.id.llAmount) {

            replaceFragment(new HoldingsActivity());

        } else if (id == R.id.startNow || id == R.id.cvNewFund) {

            replaceFragment(new DiscoverFundsActivity());

        } else if (id == R.id.btn_Details) {

            replaceFragment(new HoldingsActivity());

        } else if (id == R.id.img_right_arrow) {

            replaceFragment(new HoldingsActivity());

        } else if (id == R.id.btn_re_access_risk_profile) {

            callRMDetailAPI();

            replaceFragment(new RiskProfileActivity());

        }else if (id == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }

    private void getTransactionApiCall() {

        APIInterface apiInterface = BOBApp.getApi(context, Constants.ACTION_CLIENT_TRANSACTION);

        util.showProgressDialog(context, true);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;

        TransactionRequestBodyModel requestBodyModel = new TransactionRequestBodyModel();

        requestBodyModel.setUserId(authenticateResponse.getUserID());

        requestBodyModel.setOnlineAccountCode(authenticateResponse.getUserCode());

        requestBodyModel.setSchemeCode("0");

        requestBodyModel.setDateFrom(util.getCurrentDate(true));

        requestBodyModel.setDateTo(util.getCurrentDate(false));

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

                    transactionResponseModelArrayList = response.body();

                    setDashboardTransactionListAdapter(transactionResponseModelArrayList);

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

    private void callRMDetailAPI() {

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(context, Constants.ACTION_RM_DETAIL);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setUserId(BOBActivity.authResponse.getUserID());

        requestBodyObject.setUserType(BOBActivity.authResponse.getUserType());

        requestBodyObject.setUserCode(BOBActivity.authResponse.getUserCode());

        requestBodyObject.setLastBusinessDate(BOBActivity.authResponse.getBusinessDate());

        requestBodyObject.setCurrencyCode("1"); //For INR

        requestBodyObject.setAmountDenomination("0"); //For base

        requestBodyObject.setAccountLevel("0"); //For client

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        RMDetailRequestObject.createGlobalRequestObject(globalRequestObject);

        apiInterface.getRMDetailResponse(RMDetailRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<RMDetailResponseObject>>() {
            @Override
            public void onResponse(Call<ArrayList<RMDetailResponseObject>> call, Response<ArrayList<RMDetailResponseObject>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    ArrayList<RMDetailResponseObject> rmDetailResponseObjectArrayList = response.body();

                    RMDetailResponseObject rmDetailResponseObject = rmDetailResponseObjectArrayList.get(0);

                    SettingPreferences.setRiskProfile(context, rmDetailResponseObject.getRiskProfile());

                    setData(currentIndex);


                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<RMDetailResponseObject>> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private DrawerLayout drawerLayout;

    private LinearLayout drawerMenuView;

    private int screenWidth = 0, screenHeight = 0;

    int DRAWER_ITEMS_OPEN_TIME = 200;

    public void manageLeftSideDrawer() {

        WindowManager manager = (WindowManager) context.getSystemService(WINDOW_SERVICE);

        DisplayMetrics metrics = new DisplayMetrics();

        manager.getDefaultDisplay().getMetrics(metrics);

        screenWidth = metrics.widthPixels;

        screenHeight = metrics.heightPixels;

        View leftSideDrawerView = LayoutInflater.from(context).inflate(R.layout.left_side_drawer_layout, null);

        leftSideDrawerView.setLayoutParams(new LinearLayout.LayoutParams((int) (screenWidth * 0.8f), LinearLayout.LayoutParams.MATCH_PARENT));

        ImageView close = (ImageView) leftSideDrawerView.findViewById(R.id.close);

        ImageView imgIcon = (ImageView) leftSideDrawerView.findViewById(R.id.imgIcon);

        TextView dashboard = leftSideDrawerView.findViewById(R.id.dashboard);

        TextView portFolio = leftSideDrawerView.findViewById(R.id.portFolio);

        TextView report = leftSideDrawerView.findViewById(R.id.report);

        TextView transact = leftSideDrawerView.findViewById(R.id.transact);

        TextView orderStatus = leftSideDrawerView.findViewById(R.id.orderStatus);

        TextView dematHolding = leftSideDrawerView.findViewById(R.id.dematHolding);

        TextView stopSIP = leftSideDrawerView.findViewById(R.id.stopSIP);

        TextView setup = leftSideDrawerView.findViewById(R.id.setup);

        imgIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        BOBActivity.mTabHost.setCurrentTab(0);
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        BOBActivity.mTabHost.setCurrentTab(0);
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        BOBActivity.mTabHost.setCurrentTab(0);
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        portFolio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        BOBActivity.mTabHost.setCurrentTab(1);
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        replaceFragment(new ReportFragment());
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        transact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        BOBActivity.mTabHost.setCurrentTab(2);
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        orderStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        replaceFragment(new OrderStatusActivity());
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        dematHolding.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        replaceFragment(new DematHoldingActivity());
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        stopSIP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        replaceFragment(new StopSIPActivity());
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        setup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawer(Gravity.LEFT);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        replaceFragment(new SetUpFragment());
                    }

                }, DRAWER_ITEMS_OPEN_TIME);
            }
        });

        drawerMenuView.addView(leftSideDrawerView);
    }

    public void menuButton() {

        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {

            drawerLayout.closeDrawer(Gravity.LEFT);

        } else {

            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }

    public void replaceFragment(Fragment fragment) {

        ((BaseContainerFragment)getParentFragment()).replaceFragment(fragment, true);
    }
}
