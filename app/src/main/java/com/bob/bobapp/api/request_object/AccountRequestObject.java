package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class AccountRequestObject extends RequestBodyObject{

    private static AccountRequestObject accountRequestObject = null;

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

    public static AccountRequestObject getAccountRequestObject() {

        if (accountRequestObject == null) {

            accountRequestObject = new AccountRequestObject();
        }

        return accountRequestObject;
    }

    public static void createAccountRequestObject(String uniqueIdentifier, String source, RequestBodyObject requestBodyObject) {

        accountRequestObject = getAccountRequestObject();

        accountRequestObject.setUniqueIdentifier(uniqueIdentifier);

        accountRequestObject.setSource(source);

        accountRequestObject.setRequestBodyObject(requestBodyObject);
    }
}
