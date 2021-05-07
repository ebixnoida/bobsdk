package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class InvestmentcartCountsRequest {

    @SerializedName("UniqueIdentifier")
    private String uniqueIdentifier;

    @SerializedName("Source")
    private String source;

    @SerializedName("RequestBody")
    private InvestmentcartCountsRequestBody requestBodyObject;

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public InvestmentcartCountsRequestBody getRequestBodyObject() {
        return requestBodyObject;
    }

    public void setRequestBodyObject(InvestmentcartCountsRequestBody requestBodyObject) {
        this.requestBodyObject = requestBodyObject;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


}
