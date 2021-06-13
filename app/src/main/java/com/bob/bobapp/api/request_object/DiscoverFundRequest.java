package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class DiscoverFundRequest {

    @SerializedName("UniqueIdentifier")
    private String uniqueIdentifier;

    @SerializedName("Source")
    private String source;

    @SerializedName("RequestBody")
    private DiscoverFundRequestBody requestBodyObject;

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

    public DiscoverFundRequestBody getRequestBodyObject() {
        return requestBodyObject;
    }

    public void setRequestBodyObject(DiscoverFundRequestBody requestBodyObject) {
        this.requestBodyObject = requestBodyObject;
    }
}
