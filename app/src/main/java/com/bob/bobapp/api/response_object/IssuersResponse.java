package com.bob.bobapp.api.response_object;

public class IssuersResponse {
    public  String  ClientCode;
    public  String  AMCCode;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getAMCCode() {
        return AMCCode;
    }

    public void setAMCCode(String AMCCode) {
        this.AMCCode = AMCCode;
    }

    public String getAMCName() {
        return AMCName;
    }

    public void setAMCName(String AMCName) {
        this.AMCName = AMCName;
    }

    public  String  AMCName;
}
