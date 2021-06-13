package com.bob.bobapp.api.response_object;

import com.bob.bobapp.api.bean.PortfolioPerformanceDetailCollection;

import java.util.ArrayList;

public class PortfolioPerformanceResponseObject {

    private String ClientCode;

    private String InvestmentCostValue;

    private String InvestmentMarketValue;

    private String ProfitLoss;

    private String InceptionPerc;

    private ArrayList<PortfolioPerformanceDetailCollection> PortfolioPerformanceDetailCollection;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getInvestmentCostValue() {
        return InvestmentCostValue;
    }

    public void setInvestmentCostValue(String investmentCostValue) {
        InvestmentCostValue = investmentCostValue;
    }

    public String getInvestmentMarketValue() {
        return InvestmentMarketValue;
    }

    public void setInvestmentMarketValue(String investmentMarketValue) {
        InvestmentMarketValue = investmentMarketValue;
    }

    public String getProfitLoss() {
        return ProfitLoss;
    }

    public void setProfitLoss(String profitLoss) {
        ProfitLoss = profitLoss;
    }

    public String getInceptionPerc() {
        return InceptionPerc;
    }

    public void setInceptionPerc(String inceptionPerc) {
        InceptionPerc = inceptionPerc;
    }

    public ArrayList<com.bob.bobapp.api.bean.PortfolioPerformanceDetailCollection> getPortfolioPerformanceDetailCollection() {
        return PortfolioPerformanceDetailCollection;
    }

    public void setPortfolioPerformanceDetailCollection(ArrayList<com.bob.bobapp.api.bean.PortfolioPerformanceDetailCollection> portfolioPerformanceDetailCollection) {
        PortfolioPerformanceDetailCollection = portfolioPerformanceDetailCollection;
    }
}
