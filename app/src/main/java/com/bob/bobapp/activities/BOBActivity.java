package com.bob.bobapp.activities;

import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.AccountListAdapter;
import com.bob.bobapp.adapters.HomeTabAdapter;
import com.bob.bobapp.adapters.NotificationAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.WebService;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.bean.InvestmentCartCountObject;
import com.bob.bobapp.api.request_object.AccountRequestObject;
import com.bob.bobapp.api.request_object.AuthenticateRequest;
import com.bob.bobapp.api.request_object.ClientHoldingRequest;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.InvestmentCartCountRequest;
import com.bob.bobapp.api.request_object.MaturitiesReportModel;
import com.bob.bobapp.api.request_object.MaturityReportRequestModel;
import com.bob.bobapp.api.request_object.NotificationRequestObject;
import com.bob.bobapp.api.request_object.RMDetailRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.response_object.AccountResponseObject;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.api.response_object.NotificationObject;
import com.bob.bobapp.api.response_object.RMDetailResponseObject;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.UUID;

public class BOBActivity extends BaseActivity {

    private ArrayList<InvestmentMaturityModel> investmentMaturityModelArrayList;

    private ArrayList<NotificationObject> notificationObjectArrayList;

    private ArrayList<AccountResponseObject> accountResponseObjectArrayList;

    private ArrayList<RMDetailResponseObject> rmDetailResponseObjectArrayList;

    private AccountResponseObject accountResponseObject;

    private int selectedPosition;

    private AuthenticateResponse authenticateResponse;
    public static AuthenticateResponse authResponse;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView title, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, tvUsername, tvPopupAccount, tvPopupRMDetails, btnPopupSubmit;
    private RecyclerView accountDetailsRecyclerView, rvNotification;
    private DrawerLayout drawerLayout;
    private LinearLayout drawerMenuView, layoutAccountPopup, layoutRMDetailPopup, layoutHeaderPopup;
    private int screenWidth = 0, screenHeight = 0;
    int DRAWER_ITEMS_OPEN_TIME = 200;
    private TextView imgMenu;
    private LinearLayout llMenu;

    private TextView tvRMUsername, tvRMName, tvRMEmail, tvRMMobileNumber;

    private Util util;

    private Context context;
    private ArrayList<ClientHoldingObject> holdingArrayList;

    private View viewPopup;

    private FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);

        EventBus.getDefault().register(this);

        context = this;

        util = new Util(context);

        getId();

        initialization();

        handleListeners();

        setIcons(util);

        authenticateUser();
    }

    public void setIcons(Util util) {

        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
    }

    @Override
    public void setIcon(Util util) {


    }

    public void getId() {
        frameLayout = (FrameLayout) findViewById(R.id.frame_container);
        tabLayout = (TabLayout) frameLayout.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) frameLayout.findViewById(R.id.viewPager);

        title = (TextView) findViewById(R.id.title);
        tvUsername = (TextView) findViewById(R.id.txt_username);
        tvUserHeader = (TextView) findViewById(R.id.tvUserHeader);
        tvBellHeader = (TextView) findViewById(R.id.tvBellHeader);
        tvCartHeader = (TextView) findViewById(R.id.tvCartHeader);
        llMenu = (LinearLayout) findViewById(R.id.llMenu);
        tvMenu = (TextView) findViewById(R.id.menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerMenuView = (LinearLayout) findViewById(R.id.drawerMenuLLayout);
    }

    public void handleListeners() {
        llMenu.setOnClickListener(this);
        tvUsername.setOnClickListener(this);
        tvUserHeader.setOnClickListener(this);
        tvCartHeader.setOnClickListener(this);
        tvBellHeader.setOnClickListener(this);
    }

    @Override
    public void handleListener() {

    }

    public void initialization() {

        manageLeftSideDrawer();

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home).setText("Dashboard"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.report_unselected).setText("Report"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.add_unselected).setText("Transact"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.transaction_unselected).setText("Quick Transact"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.setting_unselected).setText("Setup"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    @Override
    public void initializations() {


    }

    @Override
    public void getIds() {


    }


    private void setAdapter() {

        HomeTabAdapter adapter = new HomeTabAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount(), holdingArrayList);

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tabSelected(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabUnselected(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tabSelected(tab);
            }
        });
    }


    private void tabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()) {
            case 0:
                title.setText("Dashboard");
                tab.setIcon(R.drawable.home);
                break;
            case 1:
                title.setText("Report");
                tab.setIcon(R.drawable.report);
                break;
            case 2:
                title.setText("Add Transact");
                tab.setIcon(R.drawable.add);
                break;
            case 3:
                title.setText("Quick Transact");
                tab.setIcon(R.drawable.transaction);
                break;
            case 4:
                title.setText("SetUp");
                tab.setIcon(R.drawable.setting);
                break;

        }
    }

    private void tabUnselected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                title.setText("Dashboard");
                tab.setIcon(R.drawable.homeunselectesgray);
                break;
            case 1:
                title.setText("Report");
                tab.setIcon(R.drawable.report_unselected);
                break;
            case 2:
                title.setText("Add Transact");
                tab.setIcon(R.drawable.add_unselected);
                break;
            case 3:
                title.setText("Quick Transact");
                tab.setIcon(R.drawable.transaction_unselected);
                break;
            case 4:
                title.setText("SetUp");
                tab.setIcon(R.drawable.setting_unselected);
                break;

        }
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.llMenu) {
            menuButton();
        } else if (id == R.id.txt_username || id == R.id.tvUserHeader) {
            viewPopup = view;

            callAccountDetailAPI();
        } else if (id == R.id.tvBellHeader) {
            viewPopup = view;

            callNotificationAPI();
        } else if (id == R.id.txt_popup_account) {
            tvPopupAccount.setTextColor(Color.parseColor(getString(R.color.color_rad)));

            tvPopupRMDetails.setTextColor(Color.parseColor(getString(R.color.black)));

            setPopupData(view);
        } else if (id == R.id.txt_popup_rm_details) {
            tvPopupAccount.setTextColor(Color.parseColor(getString(R.color.black)));

            tvPopupRMDetails.setTextColor(Color.parseColor(getString(R.color.color_light_orange)));

            setPopupData(view);
        } else if (id == R.id.btn_submit) {
        } else if (id == R.id.tvCartHeader) {
            Intent intent = new Intent(BOBActivity.this, InvestmentCartActivity.class);

            startActivity(intent);
        }
    }

    private void callNotificationAPI(){

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setUserType("1");

        requestBodyObject.setUserCode("32");

        requestBodyObject.setUserId("admin");

        requestBodyObject.setClientType("H");

        //requestBodyObject.setReminderPeriod("0");

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        globalRequestObject.setSource(Constants.SOURCE);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        NotificationRequestObject.createGlobalRequestObject(globalRequestObject);

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_NOTIFICATION);

        apiInterface.getNotificationResponse(NotificationRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<NotificationObject>>() {
            @Override
            public void onResponse(Call<ArrayList<NotificationObject>> call, Response<ArrayList<NotificationObject>> response) {

                if (response.isSuccessful()) {

                    notificationObjectArrayList = response.body();

                    getInvestmentMaturityApiCall();

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<NotificationObject>> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getInvestmentMaturityApiCall() {

        MaturitiesReportModel model = new MaturitiesReportModel();

        model.setFromDate("20200101");

        model.setHeadCode("32");

        model.setTillDate("20210301");

        MaturityReportRequestModel requestModel = new MaturityReportRequestModel();

        requestModel.setRequestBodyObject(model);

        requestModel.setSource(Constants.SOURCE);

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);

        requestModel.setUniqueIdentifier(uniqueIdentifier);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_INVESTMENT_MATURITY);

        apiInterface.getInvestmentMaturityReportApiCall(requestModel).enqueue(new Callback<ArrayList<InvestmentMaturityModel>>() {

            @Override
            public void onResponse(Call<ArrayList<InvestmentMaturityModel>> call, Response<ArrayList<InvestmentMaturityModel>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    investmentMaturityModelArrayList = response.body();

                    createNotificationPopup(viewPopup);

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<InvestmentMaturityModel>> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createNotificationPopup(View view){

        Balloon balloon = new Balloon.Builder(context)

                .setLayout(R.layout.notification_details)

                .setArrowSize(10)

                .setArrowOrientation(ArrowOrientation.TOP)

                .setArrowPosition(0.8f)

                .setWidthRatio(1.0f)

                .setMargin(10)

                .setCornerRadius(10f)

                .setPadding(10)

                .setBackgroundColor(ContextCompat.getColor(this, R.color.light_gray))

                .setBalloonAnimation(BalloonAnimation.CIRCULAR)

                .build();

        balloon.showAlignBottom(view);

        rvNotification = balloon.getContentView().findViewById(R.id.rvNotification);

        setNotificationDate();
    }

    private void setNotificationDate(){

        NotificationAdapter adapter = new NotificationAdapter(this, notificationObjectArrayList, investmentMaturityModelArrayList);

        rvNotification.setAdapter(adapter);
    }


    private void createShowAccountDetailPopup(View view){

        Balloon balloon = new Balloon.Builder(context)

                .setLayout(R.layout.layout_account_details)

                .setArrowSize(10)

                .setArrowOrientation(ArrowOrientation.TOP)

                .setArrowPosition(0.7f)

                .setWidthRatio(1.0f)

                .setMargin(10)

                .setCornerRadius(10f)

                .setPadding(10)

                .setBackgroundColor(ContextCompat.getColor(this, R.color.light_gray))

                .setBalloonAnimation(BalloonAnimation.CIRCULAR)

                .build();

        balloon.showAlignBottom(view);

        tvPopupAccount = balloon.getContentView().findViewById(R.id.txt_popup_account);

        tvPopupRMDetails = balloon.getContentView().findViewById(R.id.txt_popup_rm_details);

        btnPopupSubmit = balloon.getContentView().findViewById(R.id.btn_submit);

        accountDetailsRecyclerView = balloon.getContentView().findViewById(R.id.rvAccounts);

        layoutAccountPopup = balloon.getContentView().findViewById(R.id.account_layout);

        tvRMUsername = balloon.getContentView().findViewById(R.id.tv_rm_username_name);

        tvRMName = balloon.getContentView().findViewById(R.id.tv_rm_name);

        tvRMEmail = balloon.getContentView().findViewById(R.id.tv_rm_email);

        tvRMMobileNumber = balloon.getContentView().findViewById(R.id.tv_rm_mobile_number);

        layoutRMDetailPopup = balloon.getContentView().findViewById(R.id.layout_rm_details);

        layoutHeaderPopup = balloon.getContentView().findViewById(R.id.layout_header_popup);


        tvPopupAccount.setOnClickListener(this);

        tvPopupRMDetails.setOnClickListener(this);

        btnPopupSubmit.setOnClickListener(this);

        setPopupData(view);
    }

    private void setPopupData(View view){

        AccountListAdapter adapter = new AccountListAdapter(this, accountResponseObjectArrayList){

            @Override
            protected void onAccountSelect(int position) {

                accountResponseObject = accountResponseObjectArrayList.get(position);

                selectedPosition = position;
            }
        };

        accountDetailsRecyclerView.setAdapter(adapter);

        if(view.getId() == R.id.txt_popup_rm_details){

            RMDetailResponseObject rmDetailResponseObject = rmDetailResponseObjectArrayList.get(0);

            tvRMUsername.setText(rmDetailResponseObject.getClientName());

            tvRMName.setText(rmDetailResponseObject.getPrimaryRMName());

            tvRMEmail.setText(rmDetailResponseObject.getPrimaryRMEmail());

            tvRMMobileNumber.setText(rmDetailResponseObject.getPrimaryRMContactNo());

            layoutAccountPopup.setVisibility(View.GONE);

            layoutRMDetailPopup.setVisibility(View.VISIBLE);

        }else if(view.getId() == R.id.txt_popup_account){

            layoutAccountPopup.setVisibility(View.VISIBLE);

            layoutRMDetailPopup.setVisibility(View.GONE);
        }
    }


    public void manageLeftSideDrawer() {

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
        View leftSideDrawerView = LayoutInflater.from(this).inflate(R.layout.left_side_drawer_layout, null);
        leftSideDrawerView.setLayoutParams(new LinearLayout.LayoutParams((int) (screenWidth * 0.8f), LinearLayout.LayoutParams.MATCH_PARENT));
        ImageView close = (ImageView) leftSideDrawerView.findViewById(R.id.close);
        TextView dashboard = leftSideDrawerView.findViewById(R.id.dashboard);
        TextView portFolio = leftSideDrawerView.findViewById(R.id.portFolio);
        TextView report = leftSideDrawerView.findViewById(R.id.report);
        TextView transact = leftSideDrawerView.findViewById(R.id.transact);
        TextView orderStatus = leftSideDrawerView.findViewById(R.id.orderStatus);
        TextView dematHolding = leftSideDrawerView.findViewById(R.id.dematHolding);
        TextView stopSIP = leftSideDrawerView.findViewById(R.id.stopSIP);
        TextView setup = leftSideDrawerView.findViewById(R.id.setup);

        close.setVisibility(View.GONE);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(0);

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
                        viewPager.setCurrentItem(0);

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

                        Intent intent = new Intent(context, PortfolioAnalytics.class);

                        startActivity(intent);
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
                        viewPager.setCurrentItem(1);

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
                        viewPager.setCurrentItem(2);

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

                        Intent intent = new Intent(BOBActivity.this, OrderStatusActivity.class);
                        startActivity(intent);

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
                        Intent intent = new Intent(BOBActivity.this, DematHoldingActivity.class);
                        startActivity(intent);

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

                        Intent intent = new Intent(BOBActivity.this, StopSIPActivity.class);
                        startActivity(intent);

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
                        viewPager.setCurrentItem(4);

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

    public void setTransactTab() {
        viewPager.setCurrentItem(2);
    }

    private void callAccountDetailAPI() {

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setClientCode(authenticateResponse.getUserCode());

        requestBodyObject.setClientType("H"); //H for client

        requestBodyObject.setIsFundware("false");

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        AccountRequestObject.createAccountRequestObject(uniqueIdentifier, Constants.SOURCE, requestBodyObject);

        util.showProgressDialog(context, true);

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_ACCOUNT);

        apiInterface.getAccountResponse(AccountRequestObject.getAccountRequestObject()).enqueue(new Callback<ArrayList<AccountResponseObject>>() {
            @Override
            public void onResponse(Call<ArrayList<AccountResponseObject>> call, Response<ArrayList<AccountResponseObject>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    accountResponseObjectArrayList = response.body();

                    callRMDetailAPI();

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ArrayList<AccountResponseObject>> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callRMDetailAPI() {

        APIInterface apiInterface = BOBApp.getApi(this, Constants.ACTION_RM_DETAIL);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

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

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        RMDetailRequestObject.createGlobalRequestObject(globalRequestObject);

        apiInterface.getRMDetailResponse(RMDetailRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<RMDetailResponseObject>>() {
            @Override
            public void onResponse(Call<ArrayList<RMDetailResponseObject>> call, Response<ArrayList<RMDetailResponseObject>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    rmDetailResponseObjectArrayList = response.body();

                    createShowAccountDetailPopup(viewPopup);

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

    private void authenticateUser() {

        AuthenticateRequest.createAuthenticateRequestObject("false", "069409856", "true", "14", "0", "0");

        util.showProgressDialog(context, true);

        WebService.action(context, Constants.ACTION_AUTHENTICATE);
    }

    @Subscribe
    public void getAuthenticateResponse(AuthenticateResponse authenticateResponse) {

        if (authenticateResponse != null) {

            this.authenticateResponse = authenticateResponse;

            authResponse = authenticateResponse;

            tvUsername.setText(authenticateResponse.getUserName());

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

            WebService.action(context, Constants.ACTION_CLIENT_HOLDING);

        } else {

            util.showProgressDialog(context, false);
        }
    }

    @Subscribe
    public void getHoldingResponse(ArrayList<ClientHoldingObject> clientHoldingObjectArrayList) {

        holdingArrayList = clientHoldingObjectArrayList;

        if (clientHoldingObjectArrayList != null && !clientHoldingObjectArrayList.isEmpty()) {

            ClientHoldingObject clientHoldingObject = clientHoldingObjectArrayList.get(0);

            RequestBodyObject requestBodyObject = new RequestBodyObject();

            requestBodyObject.setClientCode(clientHoldingObject.getClientCode());

            requestBodyObject.setParentChannelID(authenticateResponse.getChannelID());

            UUID uuid = UUID.randomUUID();

            String uniqueIdentifier = String.valueOf(uuid);

            SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

            InvestmentCartCountRequest.createInvestmentCartCountRequestObject(uniqueIdentifier, Constants.SOURCE, requestBodyObject);

            //WebService.action(context, Constants.ACTION_CART_COUNT);

            setAdapter();

        } else {

            util.showProgressDialog(context, false);
        }
    }

    @Subscribe
    public void getInvestmentCartCountResponse(ArrayList<InvestmentCartCountObject> investmentCartCountObjectArrayList) {

        int cartCount = 0;

        if (investmentCartCountObjectArrayList != null && !investmentCartCountObjectArrayList.isEmpty()) {

            cartCount = investmentCartCountObjectArrayList.size();

        } else {

            util.showProgressDialog(context, false);
        }

        //setAdapter();
    }


    public ArrayList<ClientHoldingObject> getHoldingList() {

        if (holdingArrayList != null && holdingArrayList.size() > 0) {

            return holdingArrayList;
        }

        return null;
    }
}

