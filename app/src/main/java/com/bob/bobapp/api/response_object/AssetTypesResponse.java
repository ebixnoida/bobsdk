package com.bob.bobapp.api.response_object;

public class AssetTypesResponse {
    private String AssetClassCode;

    private String AssetClassName;

    private String ClientCode;

    private String TargetValuePercentage;

    private String AssetAllocationType;

    private String ValuePercentage;

    private String ValueAmount;

    public String getAssetClassCode ()
    {
        return AssetClassCode;
    }

    public void setAssetClassCode (String AssetClassCode)
    {
        this.AssetClassCode = AssetClassCode;
    }

    public String getAssetClassName ()
    {
        return AssetClassName;
    }

    public void setAssetClassName (String AssetClassName)
    {
        this.AssetClassName = AssetClassName;
    }

    public String getClientCode ()
    {
        return ClientCode;
    }

    public void setClientCode (String ClientCode)
    {
        this.ClientCode = ClientCode;
    }

    public String getTargetValuePercentage ()
    {
        return TargetValuePercentage;
    }

    public void setTargetValuePercentage (String TargetValuePercentage)
    {
        this.TargetValuePercentage = TargetValuePercentage;
    }

    public String getAssetAllocationType ()
    {
        return AssetAllocationType;
    }

    public void setAssetAllocationType (String AssetAllocationType)
    {
        this.AssetAllocationType = AssetAllocationType;
    }

    public String getValuePercentage ()
    {
        return ValuePercentage;
    }

    public void setValuePercentage (String ValuePercentage)
    {
        this.ValuePercentage = ValuePercentage;
    }

    public String getValueAmount ()
    {
        return ValueAmount;
    }

    public void setValueAmount (String ValueAmount)
    {
        this.ValueAmount = ValueAmount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [AssetClassCode = "+AssetClassCode+", AssetClassName = "+AssetClassName+", ClientCode = "+ClientCode+", TargetValuePercentage = "+TargetValuePercentage+", AssetAllocationType = "+AssetAllocationType+", ValuePercentage = "+ValuePercentage+", ValueAmount = "+ValueAmount+"]";
    }
}
