package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class AccountRequestBody
{
    @SerializedName("ClientCode")
    private String ClientCode;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }
}
