package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class GlobalRequestObject extends RequestBodyObject{

    @SerializedName("UniqueIdentifier")
    private String uniqueIdentifier;

    @SerializedName("Source")
    private String source;

    @SerializedName("RequestBody")
    private RequestBodyObject requestBodyObject;

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

    public RequestBodyObject getRequestBodyObject() {
        return requestBodyObject;
    }

    public void setRequestBodyObject(RequestBodyObject requestBodyObject) {
        this.requestBodyObject = requestBodyObject;
    }
}
