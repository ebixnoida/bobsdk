package com.bob.bobapp.api.request_object;

import android.content.Context;

import com.bob.bobapp.encryption.AESEncryption;
import com.google.gson.annotations.SerializedName;

public class ClientHoldingRequest {

    private static ClientHoldingRequest clientHoldingRequest = null;

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

    public static ClientHoldingRequest getClientHoldingRequestObject() {

        if (clientHoldingRequest == null) {

            clientHoldingRequest = new ClientHoldingRequest();
        }

        return clientHoldingRequest;
    }

    public static void createClientHoldingRequestObject(String uniqueIdentifier, String source, RequestBodyObject requestBodyObject) {

        clientHoldingRequest = getClientHoldingRequestObject();

        clientHoldingRequest.setUniqueIdentifier(uniqueIdentifier);

        clientHoldingRequest.setSource(source);

        clientHoldingRequest.setRequestBodyObject(requestBodyObject);
    }
}
