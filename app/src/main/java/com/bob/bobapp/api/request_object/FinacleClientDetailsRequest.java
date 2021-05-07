package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class FinacleClientDetailsRequest {

    @SerializedName("RequestBody")
    private FinacleClientDetailsRequestBody requestBodyObject;

    public FinacleClientDetailsRequestBody getRequestBodyObject() {
        return requestBodyObject;
    }

    public void setRequestBodyObject(FinacleClientDetailsRequestBody requestBodyObject) {
        this.requestBodyObject = requestBodyObject;
    }

    @SerializedName("UniqueIdentifier")
    private String uniqueIdentifier;

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

    @SerializedName("Source")
    private String source;
}
