package com.bob.bobapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
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
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.fragments.DashboardFragment;
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

public class RiskProfileActivity extends BaseFragment implements View.OnClickListener, onAnswerItemListener {

    private TextView txtAboutUs;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_risk_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        RiskProfileQuestionnaireAPiCall();
    }

    @Override
    protected void getIds(View view) {

        apiInterface = BOBApp.getApi(context, Constants.ACTION_RiskProfileQuestionnaire);

        util = new Util(context);

        txtAboutUs = view.findViewById(R.id.txtAboutUs);

        recyclerQuestion = view.findViewById(R.id.recyclerQuestion);

        btnNext = view.findViewById(R.id.btnNext);
    }

    @Override
    protected void setIcon(Util util) {

        FontManager.markAsIconContainer(txtAboutUs, util.iconFont);
    }

    @Override
    protected void handleListener() {

        BOBActivity.imgBack.setOnClickListener(this);

        btnNext.setOnClickListener(this);
    }

    @Override
    protected void initializations() {

        BOBActivity.llMenu.setVisibility(View.GONE);

        BOBActivity.title.setText("Risk Profile");
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.menu) {

            getActivity().onBackPressed();

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
        }else if (id == R.id.imgBack) {

            getActivity().onBackPressed();
        }
    }

    private void callSubmitAPI(){

        apiInterface = BOBApp.getApi(context, Constants.ACTION_RISK_PROFILE_SUBMIT);

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

        util.showProgressDialog(context, true);

        apiInterface.RiskProfileSubmitResponse(RiskProfileRequestObject.getGlobalRequestObject()).enqueue(new Callback<RiskProfileSubmitResponse>() {

            @Override
            public void onResponse(Call<RiskProfileSubmitResponse> call, Response<RiskProfileSubmitResponse> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {

                    RiskProfileSubmitResponse riskProfileSubmitResponse = response.body();

                    if(riskProfileSubmitResponse != null) {

                        Toast.makeText(context, "Answers submitted successfully!", Toast.LENGTH_SHORT).show();

                        ((BaseContainerFragment)getParentFragment()).clearBackStackExceptFragment(new DashboardFragment());
                    }

                } else {

                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RiskProfileSubmitResponse> call, Throwable t) {

                util.showProgressDialog(context, false);

                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // question adapter
    private void setQuestionAdapter() {
        questionAdapter = new QuestionAdapter(context, riskProfileQuestionCollectionArrayList, count, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
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
        util.showProgressDialog(context, true);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;
        FundTypesRequestBody requestBody = new FundTypesRequestBody();
        requestBody.setClientCode(authenticateResponse.getUserCode());


        FundTypesRequest model = new FundTypesRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.RiskProfileQuestionnaire(model).enqueue(new Callback<RiskProfileResponse>() {
            @Override
            public void onResponse(Call<RiskProfileResponse> call, Response<RiskProfileResponse> response) {
                util.showProgressDialog(context, false);
                if (response.isSuccessful()) {
                    riskProfileResponse = response.body();
                    riskProfileQuestionCollectionArrayList = response.body().getRiskProfileQuestionCollection();
                    setQuestionAdapter();
                    tempArrayList = riskProfileQuestionCollectionArrayList;

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RiskProfileResponse> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


}