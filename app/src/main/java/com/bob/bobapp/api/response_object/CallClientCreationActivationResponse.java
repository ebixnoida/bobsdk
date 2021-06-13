package com.bob.bobapp.api.response_object;

public class CallClientCreationActivationResponse {
    public String  ClientCode;
    public String  ErrorCode;
    public String  ErrorDescription;
    public String  KYCStatusDesc;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorDescription() {
        return ErrorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        ErrorDescription = errorDescription;
    }

    public String getKYCStatusDesc() {
        return KYCStatusDesc;
    }

    public void setKYCStatusDesc(String KYCStatusDesc) {
        this.KYCStatusDesc = KYCStatusDesc;
    }
}
