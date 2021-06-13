package com.bob.bobapp.api.response_object;

public class InvestmentCartCountResponse
{
    public String getTranCount() {
        return TranCount;
    }

    public void setTranCount(String tranCount) {
        TranCount = tranCount;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String TranCount;
    public String TransactionType;
}
