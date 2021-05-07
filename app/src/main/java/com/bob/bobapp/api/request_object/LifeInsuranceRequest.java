package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class LifeInsuranceRequest {


    @SerializedName("UniqueIdentifier")
    private String uniqueIdentifier;

    @SerializedName("Source")
    private String source;

    @SerializedName("RequestBody")
    private LifeInsuranceRequestBody requestBodyObject;

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
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

    public LifeInsuranceRequestBody getRequestBodyObject() {
        return requestBodyObject;
    }

    public void setRequestBodyObject(LifeInsuranceRequestBody requestBodyObject) {
        this.requestBodyObject = requestBodyObject;
    }
}
