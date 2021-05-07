package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class InvestmentCartDetailsRequestBody {
    @SerializedName("ClientCode")
    private String ClientCode;

    public String getParentChannelID() {
        return ParentChannelID;
    }

    public void setParentChannelID(String parentChannelID) {
        ParentChannelID = parentChannelID;
    }

    @SerializedName("ParentChannelID")
    private String ParentChannelID;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }



}
