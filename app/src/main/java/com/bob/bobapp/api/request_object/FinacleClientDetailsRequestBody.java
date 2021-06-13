package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class FinacleClientDetailsRequestBody
{
    public String getpInfinityID() {
        return pInfinityID;
    }

    public void setpInfinityID(String pInfinityID) {
        this.pInfinityID = pInfinityID;
    }

    @SerializedName("pInfinityID")
    private String pInfinityID;
}
