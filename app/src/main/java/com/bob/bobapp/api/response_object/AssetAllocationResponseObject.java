package com.bob.bobapp.api.response_object;

public class AssetAllocationResponseObject {

    private String AssetAllocationType;

    private String ClientCode;

    private String AssetClassCode;

    private String AssetClassName;

    private String ValueAmount;

    private String ValuePercentage;

    private String TargetValuePercentage;

    public String getAssetAllocationType() {
        return AssetAllocationType;
    }

    public void setAssetAllocationType(String assetAllocationType) {
        AssetAllocationType = assetAllocationType;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getAssetClassCode() {
        return AssetClassCode;
    }

    public void setAssetClassCode(String assetClassCode) {
        AssetClassCode = assetClassCode;
    }

    public String getAssetClassName() {
        return AssetClassName;
    }

    public void setAssetClassName(String assetClassName) {
        AssetClassName = assetClassName;
    }

    public String getValueAmount() {
        return ValueAmount;
    }

    public void setValueAmount(String valueAmount) {
        ValueAmount = valueAmount;
    }

    public String getValuePercentage() {
        return ValuePercentage;
    }

    public void setValuePercentage(String valuePercentage) {
        ValuePercentage = valuePercentage;
    }

    public String getTargetValuePercentage() {
        return TargetValuePercentage;
    }

    public void setTargetValuePercentage(String targetValuePercentage) {
        TargetValuePercentage = targetValuePercentage;
    }
}
