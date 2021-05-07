package com.bob.bobapp.api.bean;

public class PortfolioPerformanceDetailCollection {

    private String Type;

    private String ReturnSinceInception;

    private String DateRangeInception;

    private String YTDReturn;

    private String DateRangeYTD;

    private String QTDReturn;

    private String DateRangeQTD;

    private String IndexCode;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDateRangeInception() {
        return DateRangeInception;
    }

    public void setDateRangeInception(String dateRangeInception) {
        DateRangeInception = dateRangeInception;
    }

    public String getDateRangeYTD() {
        return DateRangeYTD;
    }

    public void setDateRangeYTD(String dateRangeYTD) {
        DateRangeYTD = dateRangeYTD;
    }

    public String getDateRangeQTD() {
        return DateRangeQTD;
    }

    public void setDateRangeQTD(String dateRangeQTD) {
        DateRangeQTD = dateRangeQTD;
    }

    public String getIndexCode() {
        return IndexCode;
    }

    public void setIndexCode(String indexCode) {
        IndexCode = indexCode;
    }

    public String getReturnSinceInception() {
        return ReturnSinceInception;
    }

    public void setReturnSinceInception(String returnSinceInception) {
        ReturnSinceInception = returnSinceInception;
    }

    public String getYTDReturn() {
        return YTDReturn;
    }

    public void setYTDReturn(String YTDReturn) {
        this.YTDReturn = YTDReturn;
    }

    public String getQTDReturn() {
        return QTDReturn;
    }

    public void setQTDReturn(String QTDReturn) {
        this.QTDReturn = QTDReturn;
    }
}
