package com.bob.bobapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.QuestionAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.bean.RiskProfileQuestionnaireBean;
import com.bob.bobapp.api.request_object.FundTypesRequest;
import com.bob.bobapp.api.request_object.FundTypesRequestBody;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.request_object.RiskProfileRequestObject;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.RiskProfileQuestionCollection;
import com.bob.bobapp.api.response_object.RiskProfileResponse;
import com.bob.bobapp.api.response_object.RiskProfileSubmitResponse;
import com.bob.bobapp.listener.onAnswerItemListener;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiskProfileActivity extends AppCompatActivity implements View.OnClickListener, onAnswerItemListener {
    private TextView tvTitle, tvUserHeader, tvBellHeader, tvCartHeader, tvMenu, txtAboutUs;
    private Util util;
    private AppCompatButton btnNext;
    private int count = 0;
    private RecyclerView recyclerQuestion;
    private QuestionAdapter questionAdapter;
    private APIInterface apiInterface;
    private ArrayList<RiskProfileQuestionCollection> riskProfileQuestionCollectionArrayList = new ArrayList<>();
    private ArrayList<RiskProfileQuestionCollection> tempArrayList = new ArrayList<>();
    private RiskProfileResponse riskProfileResponse;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_profile);
        context = this;
        findView();
        setIcon(util);
        RiskProfileQuestionnaireAPiCall();
    }

    // initialize object here..
    private void findView() {
        apiInterface = BOBApp.getApi(getApplicationContext(), Constants.ACTION_RiskProfileQuestionnaire);
        util = new Util(this);
        tvUserHeader = findViewById(R.id.tvUserHeader);
        tvBellHeader = findViewById(R.id.tvBellHeader);
        tvCartHeader = findViewById(R.id.tvCartHeader);
        tvMenu = findViewById(R.id.menu);
        tvTitle = findViewById(R.id.title);
        txtAboutUs = findViewById(R.id.txtAboutUs);
        recyclerQuestion = findViewById(R.id.recyclerQuestion);
        btnNext = findViewById(R.id.btnNext);

        tvMenu.setText(getResources().getString(R.string.fa_icon_back));
        tvTitle.setText(getString(R.string.risk_profile));

        tvMenu.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    // icon set
    void setIcon(Util util) {
        FontManager.markAsIconContainer(tvUserHeader, util.iconFont);
        FontManager.markAsIconContainer(tvBellHeader, util.iconFont);
        FontManager.markAsIconContainer(tvCartHeader, util.iconFont);
        FontManager.markAsIconContainer(tvMenu, util.iconFont);
        FontManager.markAsIconContainer(txtAboutUs, util.iconFont);
    }

    // handle listener here...
    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.menu) {
            onBackPressed();
        } else if (id == R.id.btnNext) {
            String text = btnNext.getText().toString();

            if (text.equalsIgnoreCase("Submit")) {

                callSubmitAPI();

            } else {

                count = count + 1;

                if (riskProfileQuestionCollectionArrayList.size() - 1 >= count) {

                    setQuestionAdapter();

                } else {

                    btnNext.setText("Submit");
                }
            }
        }
    }

    private void callSubmitAPI(){

        apiInterface = BOBApp.getApi(getApplicationContext(), Constants.ACTION_RISK_PROFILE_SUBMIT);

        GlobalRequestObject globalRequestObject = new GlobalRequestObject();

        RequestBodyObject requestBodyObject = new RequestBodyObject();

        requestBodyObject.setClientCode(BOBActivity.authResponse.getUserCode());

        RiskProfileQuestionnaireBean riskProfileQuestionnaireBean = new RiskProfileQuestionnaireBean();

        riskProfileQuestionnaireBean.setQuestionSetCode(riskProfileResponse.getQuestionSetCode());

        riskProfileQuestionnaireBean.setRiskProfileQuestionCollection(tempArrayList);

        requestBodyObject.setRiskProfileQuestionnaire(riskProfileQuestionnaireBean);

        UUID uuid = UUID.randomUUID();

        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);

        globalRequestObject.setRequestBodyObject(requestBodyObject);

        globalRequestObject.setUniqueIdentifier(uniqueIdentifier);

        globalRequestObject.setSource(Constants.SOURCE);

        RiskProfileRequestObject.createGlobalRequestObject(globalRequestObject);

        util.showProgressDialog(RiskProfileActivity.this, true);

        apiInterface.RiskProfileSubmitResponse(RiskProfileRequestObject.getGlobalRequestObject()).enqueue(new Callback<RiskProfileSubmitResponse>() {

            @Override
            public void onResponse(Call<RiskProfileSubmitResponse> call, Response<RiskProfileSubmitResponse> response) {

                util.showProgressDialog(RiskProfileActivity.this, false);

                if (response.isSuccessful()) {

                    RiskProfileSubmitResponse riskProfileSubmitResponse = response.body();

                    if(riskProfileSubmitResponse != null) {

                        Toast.makeText(getApplicationContext(), "Answers submitted successfully!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(context, BOBActivity.class);

                        startActivity(intent);
                    }

                } else {

                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RiskProfileSubmitResponse> call, Throwable t) {

                util.showProgressDialog(getApplicationContext(), false);

                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // question adapter
    private void setQuestionAdapter() {
        questionAdapter = new QuestionAdapter(getApplicationContext(), riskProfileQuestionCollectionArrayList, count, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerQuestion.setLayoutManager(linearLayoutManager);
        recyclerQuestion.setAdapter(questionAdapter);
    }

    // item listener
    @Override
    public void onItemListener(String selected, String answerDescription, int position) {
        //Toast.makeText(getApplicationContext(),answerDescription,Toast.LENGTH_SHORT).show();

        //String json = new Gson().toJson(tempArrayList);
        //Log.d("asd",json);

    }

    // api calling
    private void RiskProfileQuestionnaireAPiCall() {
        util.showProgressDialog(RiskProfileActivity.this, true);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        FundTypesRequestBody requestBody = new FundTypesRequestBody();
        requestBody.setClientCode(authenticateResponse.getUserCode());


        FundTypesRequest model = new FundTypesRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(getApplicationContext(), uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.RiskProfileQuestionnaire(model).enqueue(new Callback<RiskProfileResponse>() {
            @Override
            public void onResponse(Call<RiskProfileResponse> call, Response<RiskProfileResponse> response) {
                util.showProgressDialog(RiskProfileActivity.this, false);
                if (response.isSuccessful()) {
                    riskProfileResponse = response.body();
                    riskProfileQuestionCollectionArrayList = response.body().getRiskProfileQuestionCollection();
                    setQuestionAdapter();
                    tempArrayList = riskProfileQuestionCollectionArrayList;

                } else {
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RiskProfileResponse> call, Throwable t) {
                util.showProgressDialog(getApplicationContext(), false);
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


}