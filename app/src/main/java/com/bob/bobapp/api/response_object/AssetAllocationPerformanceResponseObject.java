package com.bob.bobapp.api.response_object;

public class AssetAllocationPerformanceResponseObject {

    private String ClientCode;

    private String AssetClass;

    private String BenchMarkPercentage;

    private String XIRRPercentage;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getAssetClass() {
        return AssetClass;
    }

    public void setAssetClass(String assetClass) {
        AssetClass = assetClass;
    }

    public String getBenchMarkPercentage() {
        return BenchMarkPercentage;
    }

    public void setBenchMarkPercentage(String benchMarkPercentage) {
        BenchMarkPercentage = benchMarkPercentage;
    }

    public String getXIRRPercentage() {
        return XIRRPercentage;
    }

    public void setXIRRPercentage(String XIRRPercentage) {
        this.XIRRPercentage = XIRRPercentage;
    }
}
