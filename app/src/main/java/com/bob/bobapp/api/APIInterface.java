package com.bob.bobapp.api;

import com.bob.bobapp.api.bean.ClientHoldingObject;
import com.bob.bobapp.api.bean.InvestmentCartCountObject;
import com.bob.bobapp.api.request_object.AccountRequestObject;
import com.bob.bobapp.api.request_object.AccountsRequest;
import com.bob.bobapp.api.request_object.AssetTypesRequest;
import com.bob.bobapp.api.request_object.AuthenticateRequest;
import com.bob.bobapp.api.request_object.BankAccountRequest;
import com.bob.bobapp.api.request_object.CallClientCreationActivationRequest;
import com.bob.bobapp.api.request_object.ClientHoldingRequest;
import com.bob.bobapp.api.request_object.DiscoverFundRequest;
import com.bob.bobapp.api.request_object.FinacleClientDetailsRequest;
import com.bob.bobapp.api.request_object.FundTypesRequest;
import com.bob.bobapp.api.request_object.GeneralInsuranceRequest;
import com.bob.bobapp.api.request_object.GenerateTokenRequestObject;
import com.bob.bobapp.api.request_object.GetDropDownDatasForKYCRegisteredRequest;
import com.bob.bobapp.api.request_object.GlobalRequestObject;
import com.bob.bobapp.api.request_object.InvestmentCartCountRequest;
import com.bob.bobapp.api.request_object.InvestmentcartCountsRequest;
import com.bob.bobapp.api.request_object.LifeInsuranceRequest;
import com.bob.bobapp.api.request_object.MaturityReportRequestModel;
import com.bob.bobapp.api.request_object.OrderStatusRequest;
import com.bob.bobapp.api.request_object.RealisedGainLossRequestModel;
import com.bob.bobapp.api.request_object.RiskProfileRequestObject;
import com.bob.bobapp.api.request_object.SIPSWPSTPRequestModel;
import com.bob.bobapp.api.request_object.TransactionRequestModel;
import com.bob.bobapp.api.response_object.AccountResponseObject;
import com.bob.bobapp.api.response_object.AccountsResponse;
import com.bob.bobapp.api.response_object.AddInvCartResponse;
import com.bob.bobapp.api.response_object.AssetAllocationPerformanceResponseObject;
import com.bob.bobapp.api.response_object.AssetAllocationResponseObject;
import com.bob.bobapp.api.response_object.AssetTypesResponse;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.BankAccountResponse;
import com.bob.bobapp.api.response_object.CallClientCreationActivationResponse;
import com.bob.bobapp.api.response_object.DiscoverFundResponse;
import com.bob.bobapp.api.response_object.FinacleClientDetailsResponse;
import com.bob.bobapp.api.response_object.FundDetailResponse;
import com.bob.bobapp.api.response_object.FundTypesResponse;
import com.bob.bobapp.api.response_object.GeneralInsuranceResponse;
import com.bob.bobapp.api.response_object.GenerateTokenResponseObject;
import com.bob.bobapp.api.response_object.GetDropDownDatasForKYCRegisteredResponse;
import com.bob.bobapp.api.response_object.InvestmentCartCountResponse;
import com.bob.bobapp.api.request_object.InvestmentCartDetailsRequest;
import com.bob.bobapp.api.response_object.InvestmentCartDetailsResponse;
import com.bob.bobapp.api.response_object.InvestmentMaturityModel;
import com.bob.bobapp.api.response_object.IssuersResponse;
import com.bob.bobapp.api.response_object.LifeInsuranceResponse;
import com.bob.bobapp.api.response_object.MFOrderValidationResponse;
import com.bob.bobapp.api.response_object.NationalitiesResponse;
import com.bob.bobapp.api.response_object.NotificationObject;
import com.bob.bobapp.api.response_object.OrderStatusResponse;
import com.bob.bobapp.api.response_object.PortfolioPerformanceResponseObject;
import com.bob.bobapp.api.response_object.RMDetailResponseObject;
import com.bob.bobapp.api.response_object.RealizedGainLoss;
import com.bob.bobapp.api.response_object.RiskProfileResponse;
import com.bob.bobapp.api.response_object.RiskProfileSubmitResponse;
import com.bob.bobapp.api.response_object.SIPDueReportResponse;
import com.bob.bobapp.api.response_object.TransactionResponseModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("Client/Accounts")
    Call<ArrayList<AccountResponseObject>> getAccountResponse(@Body AccountRequestObject body);

    @POST("Client/Profile")
    Call<ArrayList<RMDetailResponseObject>> getRMDetailResponse(@Body GlobalRequestObject body);

    @POST("Authentication/Authenticate")
    Call<AuthenticateResponse> getAuthenticateResponse(@Body AuthenticateRequest body);

    @POST("Authentication/GenerateToken")
    Call<GenerateTokenResponseObject> getGenerateTokenResponse(@Body GenerateTokenRequestObject body);

    @POST("Client/Holdings")
    Call<ArrayList<ClientHoldingObject>> getHoldingResponse(@Body ClientHoldingRequest body);

    @POST("Order/InvestmentCartCount")
    Call<ArrayList<InvestmentCartCountObject>> getInvestmentCartCountResponse(@Body InvestmentCartCountRequest body);

    @POST("Client/Transactions")
    Call<ArrayList<TransactionResponseModel>> getTransactionApiCall(@Body TransactionRequestModel body);

    @POST("Client/SIPDueReport")
    Call<ArrayList<SIPDueReportResponse>> getSIPDueReportApiCall(@Body SIPSWPSTPRequestModel body);


    @POST("Client/InvestmentMaturityReport")
    Call<ArrayList<InvestmentMaturityModel>> getInvestmentMaturityReportApiCall(@Body MaturityReportRequestModel body);

    @POST("Client/RealisedGainLoss")
    Call<ArrayList<RealizedGainLoss>> getRealisedGainLossReportApiCall(@Body RealisedGainLossRequestModel body);

    @POST("Client/LifeInsurance")
    Call<ArrayList<LifeInsuranceResponse>> getLifeInsuranceApiCall(@Body LifeInsuranceRequest body);

    @POST("Order/InvestmentCartCount")
    Call<ArrayList<InvestmentCartCountResponse>> getInvestmentCartCount(@Body InvestmentcartCountsRequest body);

    @POST("Order/InvestmentCartDetails")
    Call<ArrayList<InvestmentCartDetailsResponse>> getInvestmentCartDetails(@Body InvestmentCartDetailsRequest body);

    @POST("Client/Accounts")
    Call<ArrayList<AccountsResponse>> getAccounts(@Body AccountsRequest body);

    @POST("Client/BankAccount")
    Call<ArrayList<BankAccountResponse>> getBankAccount(@Body BankAccountRequest body);

    @POST("Client/AssetAllocation")
    Call<ArrayList<AssetAllocationResponseObject>> getAssetAllocationAPIResponse(@Body GlobalRequestObject body);

    @POST("Client/AssetAllocationPerformance")
    Call<ArrayList<AssetAllocationPerformanceResponseObject>> getAssetAllocationPerformanceAPIResponse(@Body GlobalRequestObject body);

    @POST("Client/PortfolioPerformance")
    Call<PortfolioPerformanceResponseObject> getPortfolioPerformanceAPIResponse(@Body GlobalRequestObject body);

    @POST("Client/OrderStatusReport")
    Call<ArrayList<OrderStatusResponse>> getOrderStatusApiCall(@Body OrderStatusRequest body);

    @POST("Comman/GetDropDownDatasForKYCRegistered")
    Call<GetDropDownDatasForKYCRegisteredResponse> GetDropDownDatasForKYCRegistered(@Body GetDropDownDatasForKYCRegisteredRequest body);

    @POST("Nationality/Nationalities")
    Call<ArrayList<NationalitiesResponse>> getNationalities(@Body GetDropDownDatasForKYCRegisteredRequest body);

    @POST("Comman/GetFinacleClientDetails")
    Call<FinacleClientDetailsResponse> GetFinacleClientDetails(@Body FinacleClientDetailsRequest body);

    @POST("Comman/CallClientCreationActivation")
    Call<CallClientCreationActivationResponse> CallClientCreationActivation(@Body CallClientCreationActivationRequest body);

    @POST("AssetType/AssetTypes")
    Call<ArrayList<AssetTypesResponse>> AssetTypes(@Body AssetTypesRequest body);

    @POST("FundType/FundTypes")
    Call<ArrayList<FundTypesResponse>> FundTypes(@Body FundTypesRequest body);

    @POST("Issuer/Issuers")
    Call<ArrayList<IssuersResponse>> Issuers(@Body FundTypesRequest body);

    @POST("Alert/Premiums")
    Call<ArrayList<NotificationObject>> getNotificationResponse(@Body GlobalRequestObject body);

    @POST("FundDetails/FundDetails")
    Call<FundDetailResponse> getFundDetailsResponse(@Body GlobalRequestObject body);

    @POST("Client/GeneralInsurance")
    Call<ArrayList<GeneralInsuranceResponse>> getGeneralInsuranceApiCall(@Body GeneralInsuranceRequest body);

    @POST("Client/GetRecommandations")
    Call<DiscoverFundResponse> getDiscoverFundApiCall(@Body DiscoverFundRequest body);

    @POST("RiskProfile/RiskProfileQuestionnaire")
    Call<RiskProfileResponse> RiskProfileQuestionnaire(@Body FundTypesRequest body);

    @POST("Client/RiskProfileResponse")
    Call<RiskProfileSubmitResponse> RiskProfileSubmitResponse(@Body GlobalRequestObject body);

    @POST("Order/MFOrderValidationData")
    Call<MFOrderValidationResponse> getOrderValidationData(@Body GlobalRequestObject body);

    @POST("Order/AddInvCart")
    Call<AddInvCartResponse> addInvestmentCart(@Body GlobalRequestObject body);
}
