package com.bob.bobapp.api.response_object;

import java.util.ArrayList;

public class DiscoverFundResponse {
    public ArrayList<LstRecommandationDebt> getLstRecommandationDebt() {
        return lstRecommandationDebt;
    }

    public void setLstRecommandationDebt(ArrayList<LstRecommandationDebt> lstRecommandationDebt) {
        this.lstRecommandationDebt = lstRecommandationDebt;
    }

    public ArrayList<LstRecommandationDebt>lstRecommandationDebt;

    public ArrayList<com.bob.bobapp.api.response_object.lstRecommandationEquity> getLstRecommandationEquity() {
        return lstRecommandationEquity;
    }

    public void setLstRecommandationEquity(ArrayList<com.bob.bobapp.api.response_object.lstRecommandationEquity> lstRecommandationEquity) {
        this.lstRecommandationEquity = lstRecommandationEquity;
    }

    private ArrayList<com.bob.bobapp.api.response_object.lstRecommandationEquity>lstRecommandationEquity;

    public ArrayList<com.bob.bobapp.api.response_object.lstRecommandationCash> getLstRecommandationCash() {
        return lstRecommandationCash;
    }

    public void setLstRecommandationCash(ArrayList<com.bob.bobapp.api.response_object.lstRecommandationCash> lstRecommandationCash) {
        this.lstRecommandationCash = lstRecommandationCash;
    }

    private ArrayList<com.bob.bobapp.api.response_object.lstRecommandationCash>lstRecommandationCash;
}
