package com.bob.bobapp.api;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.bean.InvestmentCartCountObject;
import com.bob.bobapp.api.request_object.AccountRequestObject;
import com.bob.bobapp.api.request_object.AuthenticateRequest;
import com.bob.bobapp.api.request_object.ClientHoldingRequest;
import com.bob.bobapp.api.request_object.GenerateTokenRequestObject;
import com.bob.bobapp.api.request_object.InvestmentCartCountRequest;
import com.bob.bobapp.api.request_object.RMDetailRequestObject;
import com.bob.bobapp.api.request_object.RequestBodyObject;
import com.bob.bobapp.api.response_object.AccountResponseObject;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.ClientHoldingResponse;
import com.bob.bobapp.api.response_object.GenerateTokenResponseObject;
import com.bob.bobapp.api.response_object.InvestmentCartCountResponse;
import com.bob.bobapp.api.response_object.RMDetailResponseObject;
import com.bob.bobapp.encryption.AESEncryption;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.Util;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebService extends IntentService {

    static Context contextt;

    private APIInterface apiInterface;

    private static Util util;

    public WebService() {

        super("WebService");
    }

    public static void action(Context context, String action) {

        Intent intent = new Intent(context, WebService.class);

        intent.setAction(action);

        context.startService(intent);

        contextt = context;

        util = new Util(context);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        assert intent != null;

        String action = intent.getAction();

        apiInterface = BOBApp.getApi(contextt, action);

        if (Constants.ACTION_ACCOUNT.equals(action)) {

            getAccountResponse();

        }else if (Constants.ACTION_AUTHENTICATE.equals(action)) {

            getAuthenticateResponse();

        }else if (Constants.ACTION_GENERATE_TOKEN.equals(action)) {

            getGenerateTokenResponse();

        }else if (Constants.ACTION_CLIENT_HOLDING.equals(action)) {

            getClientHoldingResponse();

        }else if (Constants.ACTION_CART_COUNT.equals(action)) {

            getInvestmentCartCountResponse();

        }else if (Constants.ACTION_RM_DETAIL.equals(action)) {

            getRMDetailResponse();
        }
    }

    private void getAccountResponse() {

        apiInterface.getAccountResponse(AccountRequestObject.getAccountRequestObject()).enqueue(new Callback<ArrayList<AccountResponseObject>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<AccountResponseObject>> call, @NonNull Response<ArrayList<AccountResponseObject>> response) {

                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<AccountResponseObject>> call, @NonNull Throwable t) {

                call.cancel();
            }
        });
    }

    private void getAuthenticateResponse() {

        apiInterface.getAuthenticateResponse(AuthenticateRequest.getAuthenticateRequestObject()).enqueue(new Callback<AuthenticateResponse>() {

            @Override
            public void onResponse(@NonNull Call<AuthenticateResponse> call, @NonNull Response<AuthenticateResponse> response) {

                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<AuthenticateResponse> call, @NonNull Throwable t) {

                call.cancel();
            }
        });
    }

    private void getGenerateTokenResponse() {

        apiInterface.getGenerateTokenResponse(GenerateTokenRequestObject.getGenerateTokenRequestObject()).enqueue(new Callback<GenerateTokenResponseObject>() {

            @Override
            public void onResponse(@NonNull Call<GenerateTokenResponseObject> call, @NonNull Response<GenerateTokenResponseObject> response) {

                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<GenerateTokenResponseObject> call, @NonNull Throwable t) {

                call.cancel();
            }
        });
    }

    private void getClientHoldingResponse() {

        String request = new Gson().toJson(ClientHoldingRequest.getClientHoldingRequestObject());

        System.out.println("PLAIN HOLDING REQUEST :" +request);

        apiInterface.getHoldingResponse(ClientHoldingRequest.getClientHoldingRequestObject()).enqueue(new Callback<ArrayList<ClientHoldingObject>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<ClientHoldingObject>> call, @NonNull Response<ArrayList<ClientHoldingObject>> response) {

                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ClientHoldingObject>> call, @NonNull Throwable t) {

                call.cancel();
            }
        });
    }

    private void getInvestmentCartCountResponse() {

        apiInterface.getInvestmentCartCountResponse(InvestmentCartCountRequest.getInvestmentCartCountRequestObject()).enqueue(new Callback<ArrayList<InvestmentCartCountObject>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<InvestmentCartCountObject>> call, @NonNull Response<ArrayList<InvestmentCartCountObject>> response) {

                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<InvestmentCartCountObject>> call, @NonNull Throwable t) {

                call.cancel();
            }
        });
    }

    private void getRMDetailResponse() {

        apiInterface.getRMDetailResponse(RMDetailRequestObject.getGlobalRequestObject()).enqueue(new Callback<ArrayList<RMDetailResponseObject>>() {

            @Override
            public void onResponse(@NonNull Call<ArrayList<RMDetailResponseObject>> call, @NonNull Response<ArrayList<RMDetailResponseObject>> response) {

                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<RMDetailResponseObject>> call, @NonNull Throwable t) {

                call.cancel();
            }
        });
    }
}
