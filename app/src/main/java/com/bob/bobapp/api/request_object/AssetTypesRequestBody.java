package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class AssetTypesRequestBody {
    @SerializedName("UserId")
    private String UserId;

    @SerializedName("LastBusinessDate")
    private String LastBusinessDate;

    @SerializedName("ClientCode")
    private String ClientCode;

    @SerializedName("AllocationType")
    private String AllocationType;

    @SerializedName("CurrencyCode")
    private String CurrencyCode;

    @SerializedName("AccountLevel")
    private String AccountLevel;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getLastBusinessDate() {
        return LastBusinessDate;
    }

    public void setLastBusinessDate(String lastBusinessDate) {
        LastBusinessDate = lastBusinessDate;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getAllocationType() {
        return AllocationType;
    }

    public void setAllocationType(String allocationType) {
        AllocationType = allocationType;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    public String getAccountLevel() {
        return AccountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        AccountLevel = accountLevel;
    }
}

