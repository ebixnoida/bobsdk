package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class BankAccountBody
{
    @SerializedName("ClientCode")
    private String ClientCode;

    @SerializedName("L4ClientCode")
    private String L4ClientCode;

    @SerializedName("BankAccountTranNo")
    private String BankAccountTranNo;

    @SerializedName("IsPortal")
    private String IsPortal;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getL4ClientCode() {
        return L4ClientCode;
    }

    public void setL4ClientCode(String l4ClientCode) {
        L4ClientCode = l4ClientCode;
    }

    public String getBankAccountTranNo() {
        return BankAccountTranNo;
    }

    public void setBankAccountTranNo(String bankAccountTranNo) {
        BankAccountTranNo = bankAccountTranNo;
    }

    public String getIsPortal() {
        return IsPortal;
    }

    public void setIsPortal(String isPortal) {
        IsPortal = isPortal;
    }
}
