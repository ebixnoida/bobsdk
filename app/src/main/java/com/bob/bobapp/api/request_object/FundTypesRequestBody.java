package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class FundTypesRequestBody {
    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    @SerializedName("ClientCode")
    private String ClientCode;
}
