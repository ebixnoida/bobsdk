package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class AuthenticateRequest {

    private static AuthenticateRequest authenticateRequestObject = null;

    @SerializedName("IsFundware")
    private String IsFundware;

    @SerializedName("UCC")
    private String UCC;

    @SerializedName("IsAuthenticated")
    private String IsAuthenticated;

    @SerializedName("channel")
    private String channel;

    @SerializedName("FLAG")
    private String FLAG;

    @SerializedName("tandc")
    private String tandc;

    public String getIsFundware() {
        return IsFundware;
    }

    public void setIsFundware(String isFundware) {
        IsFundware = isFundware;
    }

    public String getUCC() {
        return UCC;
    }

    public void setUCC(String UCC) {
        this.UCC = UCC;
    }

    public String getIsAuthenticated() {
        return IsAuthenticated;
    }

    public void setIsAuthenticated(String isAuthenticated) {
        IsAuthenticated = isAuthenticated;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFLAG() {
        return FLAG;
    }

    public void setFLAG(String FLAG) {
        this.FLAG = FLAG;
    }

    public String getTandc() {
        return tandc;
    }

    public void setTandc(String tandc) {
        this.tandc = tandc;
    }

    public static AuthenticateRequest getAuthenticateRequestObject() {

        if (authenticateRequestObject == null) {

            authenticateRequestObject = new AuthenticateRequest();
        }

        return authenticateRequestObject;
    }

    public static void createAuthenticateRequestObject(String isFundware, String ucc, String isAuthenticated, String channel, String FLAG, String tandc) {

        authenticateRequestObject = getAuthenticateRequestObject();

        authenticateRequestObject.setIsFundware(isFundware);

        authenticateRequestObject.setUCC(ucc);

        authenticateRequestObject.setIsAuthenticated(isAuthenticated);

        authenticateRequestObject.setChannel(channel);

        authenticateRequestObject.setFLAG(FLAG);

        authenticateRequestObject.setTandc(tandc);
    }
}
