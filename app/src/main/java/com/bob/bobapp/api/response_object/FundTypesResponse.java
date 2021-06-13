package com.bob.bobapp.api.response_object;

public class FundTypesResponse {
    public String  ClientCode;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getFundTypeCode() {
        return FundTypeCode;
    }

    public void setFundTypeCode(String fundTypeCode) {
        FundTypeCode = fundTypeCode;
    }

    public String getFundTypeName() {
        return FundTypeName;
    }

    public void setFundTypeName(String fundTypeName) {
        FundTypeName = fundTypeName;
    }

    public String  FundTypeCode;
    public String  FundTypeName;
}
