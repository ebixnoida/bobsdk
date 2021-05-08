package com.bob.bobapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.DiscoverFundListAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.DiscoverFundRequest;
import com.bob.bobapp.api.request_object.DiscoverFundRequestBody;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestBodyModel;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestModel;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverFundsActivity extends BaseActivity {

    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu;
    private RecyclerView rv;
    private APIInterface apiInterface;
    private Util util;

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
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        rv = findViewById(R.id.rv);

    }

    @Override
    public void handleListener() {
        tvMenu.setOnClickListener(this);

    }

    @Override
    void initializations() {
        rv.setNestedScrollingEnabled(false);
        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText("Discover Funds");
        apiInterface = BOBApp.getApi(this, Constants.ACTION_SIP_SWP_STP_DUE);
        util = new Util(this);
        getApiCall();
    }

    private void getApiCall() {


        util.showProgressDialog(this, true);

        DiscoverFundRequestBody discoverFundRequestBody = new DiscoverFundRequestBody();
        discoverFundRequestBody.setClientcode(0);

        DiscoverFundRequest model = new DiscoverFundRequest();
        model.setRequestBodyObject(discoverFundRequestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);
        SettingPreferences.setRequestUniqueIdentifier(this, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getDiscoverFundApiCall(model).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                util.showProgressDialog(DiscoverFundsActivity.this, false);
                if (response.isSuccessful()) {

                    try {
                        Toast.makeText(DiscoverFundsActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                util.showProgressDialog(DiscoverFundsActivity.this, false);
                Toast.makeText(DiscoverFundsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setAdapter() {
        DiscoverFundListAdapter adapter = new DiscoverFundListAdapter(this);
        rv.setAdapter(adapter);

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

        if (view.getId() == R.id.menu) {
            finish();
        }

    }
}
