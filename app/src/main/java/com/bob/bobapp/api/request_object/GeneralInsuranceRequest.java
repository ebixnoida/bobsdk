package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class GeneralInsuranceRequest {

    @SerializedName("UniqueIdentifier")
    private String uniqueIdentifier;

    @SerializedName("Source")
    private String source;

    @SerializedName("RequestBody")
    private GeneralInsuranceRequestBody requestBodyObject;

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

    public GeneralInsuranceRequestBody getRequestBodyObject() {
        return requestBodyObject;
    }

    public void setRequestBodyObject(GeneralInsuranceRequestBody requestBodyObject) {
        this.requestBodyObject = requestBodyObject;
    }

}
