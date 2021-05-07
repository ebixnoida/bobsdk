package com.bob.bobapp.api.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ClientHoldingObject implements Parcelable {

    private String ClientCode;

    private String SchemeName;

    private String Folio;

    private String Quantity;

    private String ValueOfCost;

    private String CurrentPrice;

    private String MarketValue;

    private String Dividend;

    private String GainLossPercentage;

    private String NetGain;

    private String CommonScripCode;

    private String ClientName;

    private String AverageCost;

    private String MarketValue1;

    private String SortOrder;

    private String IncludeAmount;

    private String DataSource;

    private String Title;

    private String Source;

    private String BenchmarkXirr;

    private String CurrencyName;

    private String FolioNumber;

    private String InceptionDate;

    private String PortfolioWeight;

    private String XirrAsset;

    private String BenchmarkXirrAsset;

    private String L4Client_Code;

    private String FundOption;

    private String FundRiskRating;

    private String SipStartDates;

    private String AssetClassCode;

    private String AssetClassName;

    private String IsDividend;

    private String DividendOption;

    private String ValueResearchRating;

    private String MinInvAmount;

    private String MinSWPUnit;

    private String MinRedeemUnit;

    private String CurrentFundValue;

    private String AwaitingHoldingUnit;

    private String AwaitingHoldingFundValue;

    private String ExistingAmount;

    private String ExistingUnits;

    private String CurrentUnits;

    private String SwitchOutAllowed;

    private String SIPAggrAmt;

    private String SIPAllowed;

    private String REDEEMAllowed;

    private String SWPAllowed;

    private String CostofInvestment;

    private String Classification;

    private String Issuer;

    private String MaturityDate;

    private String SchemeCode;

    private String ELSSLocking;

    private String IIN;

    protected ClientHoldingObject(Parcel in) {
        ClientCode = in.readString();
        SchemeName = in.readString();
        Folio = in.readString();
        Quantity = in.readString();
        ValueOfCost = in.readString();
        CurrentPrice = in.readString();
        MarketValue = in.readString();
        Dividend = in.readString();
        GainLossPercentage = in.readString();
        NetGain = in.readString();
        CommonScripCode = in.readString();
        ClientName = in.readString();
        AverageCost = in.readString();
        MarketValue1 = in.readString();
        SortOrder = in.readString();
        IncludeAmount = in.readString();
        DataSource = in.readString();
        Title = in.readString();
        Source = in.readString();
        BenchmarkXirr = in.readString();
        CurrencyName = in.readString();
        FolioNumber = in.readString();
        InceptionDate = in.readString();
        PortfolioWeight = in.readString();
        XirrAsset = in.readString();
        BenchmarkXirrAsset = in.readString();
        L4Client_Code = in.readString();
        FundOption = in.readString();
        FundRiskRating = in.readString();
        SipStartDates = in.readString();
        AssetClassCode = in.readString();
        AssetClassName = in.readString();
        IsDividend = in.readString();
        DividendOption = in.readString();
        ValueResearchRating = in.readString();
        MinInvAmount = in.readString();
        MinSWPUnit = in.readString();
        MinRedeemUnit = in.readString();
        CurrentFundValue = in.readString();
        AwaitingHoldingUnit = in.readString();
        AwaitingHoldingFundValue = in.readString();
        ExistingAmount = in.readString();
        ExistingUnits = in.readString();
        CurrentUnits = in.readString();
        SwitchOutAllowed = in.readString();
        SIPAggrAmt = in.readString();
        SIPAllowed = in.readString();
        REDEEMAllowed = in.readString();
        SWPAllowed = in.readString();
        CostofInvestment = in.readString();
        Classification = in.readString();
        Issuer = in.readString();
        MaturityDate = in.readString();
        SchemeCode = in.readString();
        ELSSLocking = in.readString();
        IIN = in.readString();
    }

    public static final Creator<ClientHoldingObject> CREATOR = new Creator<ClientHoldingObject>() {
        @Override
        public ClientHoldingObject createFromParcel(Parcel in) {
            return new ClientHoldingObject(in);
        }

        @Override
        public ClientHoldingObject[] newArray(int size) {
            return new ClientHoldingObject[size];
        }
    };

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getSchemeName() {
        return SchemeName;
    }

    public void setSchemeName(String schemeName) {
        SchemeName = schemeName;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getValueOfCost() {
        return ValueOfCost;
    }

    public void setValueOfCost(String valueOfCost) {
        ValueOfCost = valueOfCost;
    }

    public String getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        CurrentPrice = currentPrice;
    }

    public String getMarketValue() {
        return MarketValue;
    }

    public void setMarketValue(String marketValue) {
        MarketValue = marketValue;
    }

    public String getDividend() {
        return Dividend;
    }

    public void setDividend(String dividend) {
        Dividend = dividend;
    }

    public String getGainLossPercentage() {
        return GainLossPercentage;
    }

    public void setGainLossPercentage(String gainLossPercentage) {
        GainLossPercentage = gainLossPercentage;
    }

    public String getNetGain() {
        return NetGain;
    }

    public void setNetGain(String netGain) {
        NetGain = netGain;
    }

    public String getCommonScripCode() {
        return CommonScripCode;
    }

    public void setCommonScripCode(String commonScripCode) {
        CommonScripCode = commonScripCode;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getAverageCost() {
        return AverageCost;
    }

    public void setAverageCost(String averageCost) {
        AverageCost = averageCost;
    }

    public String getMarketValue1() {
        return MarketValue1;
    }

    public void setMarketValue1(String marketValue1) {
        MarketValue1 = marketValue1;
    }

    public String getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(String sortOrder) {
        SortOrder = sortOrder;
    }

    public String getIncludeAmount() {
        return IncludeAmount;
    }

    public void setIncludeAmount(String includeAmount) {
        IncludeAmount = includeAmount;
    }

    public String getDataSource() {
        return DataSource;
    }

    public void setDataSource(String dataSource) {
        DataSource = dataSource;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getBenchmarkXirr() {
        return BenchmarkXirr;
    }

    public void setBenchmarkXirr(String benchmarkXirr) {
        BenchmarkXirr = benchmarkXirr;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public String getFolioNumber() {
        return FolioNumber;
    }

    public void setFolioNumber(String folioNumber) {
        FolioNumber = folioNumber;
    }

    public String getInceptionDate() {
        return InceptionDate;
    }

    public void setInceptionDate(String inceptionDate) {
        InceptionDate = inceptionDate;
    }

    public String getPortfolioWeight() {
        return PortfolioWeight;
    }

    public void setPortfolioWeight(String portfolioWeight) {
        PortfolioWeight = portfolioWeight;
    }

    public String getXirrAsset() {
        return XirrAsset;
    }

    public void setXirrAsset(String xirrAsset) {
        XirrAsset = xirrAsset;
    }

    public String getBenchmarkXirrAsset() {
        return BenchmarkXirrAsset;
    }

    public void setBenchmarkXirrAsset(String benchmarkXirrAsset) {
        BenchmarkXirrAsset = benchmarkXirrAsset;
    }

    public String getL4Client_Code() {
        return L4Client_Code;
    }

    public void setL4Client_Code(String l4Client_Code) {
        L4Client_Code = l4Client_Code;
    }

    public String getFundOption() {
        return FundOption;
    }

    public void setFundOption(String fundOption) {
        FundOption = fundOption;
    }

    public String getFundRiskRating() {
        return FundRiskRating;
    }

    public void setFundRiskRating(String fundRiskRating) {
        FundRiskRating = fundRiskRating;
    }

    public String getSipStartDates() {
        return SipStartDates;
    }

    public void setSipStartDates(String sipStartDates) {
        SipStartDates = sipStartDates;
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

    public String getIsDividend() {
        return IsDividend;
    }

    public void setIsDividend(String isDividend) {
        IsDividend = isDividend;
    }

    public String getDividendOption() {
        return DividendOption;
    }

    public void setDividendOption(String dividendOption) {
        DividendOption = dividendOption;
    }

    public String getValueResearchRating() {
        return ValueResearchRating;
    }

    public void setValueResearchRating(String valueResearchRating) {
        ValueResearchRating = valueResearchRating;
    }

    public String getMinInvAmount() {
        return MinInvAmount;
    }

    public void setMinInvAmount(String minInvAmount) {
        MinInvAmount = minInvAmount;
    }

    public String getMinSWPUnit() {
        return MinSWPUnit;
    }

    public void setMinSWPUnit(String minSWPUnit) {
        MinSWPUnit = minSWPUnit;
    }

    public String getMinRedeemUnit() {
        return MinRedeemUnit;
    }

    public void setMinRedeemUnit(String minRedeemUnit) {
        MinRedeemUnit = minRedeemUnit;
    }

    public String getCurrentFundValue() {
        return CurrentFundValue;
    }

    public void setCurrentFundValue(String currentFundValue) {
        CurrentFundValue = currentFundValue;
    }

    public String getAwaitingHoldingUnit() {
        return AwaitingHoldingUnit;
    }

    public void setAwaitingHoldingUnit(String awaitingHoldingUnit) {
        AwaitingHoldingUnit = awaitingHoldingUnit;
    }

    public String getAwaitingHoldingFundValue() {
        return AwaitingHoldingFundValue;
    }

    public void setAwaitingHoldingFundValue(String awaitingHoldingFundValue) {
        AwaitingHoldingFundValue = awaitingHoldingFundValue;
    }

    public String getExistingAmount() {
        return ExistingAmount;
    }

    public void setExistingAmount(String existingAmount) {
        ExistingAmount = existingAmount;
    }

    public String getExistingUnits() {
        return ExistingUnits;
    }

    public void setExistingUnits(String existingUnits) {
        ExistingUnits = existingUnits;
    }

    public String getCurrentUnits() {
        return CurrentUnits;
    }

    public void setCurrentUnits(String currentUnits) {
        CurrentUnits = currentUnits;
    }

    public String getSwitchOutAllowed() {
        return SwitchOutAllowed;
    }

    public void setSwitchOutAllowed(String switchOutAllowed) {
        SwitchOutAllowed = switchOutAllowed;
    }

    public String getSIPAggrAmt() {
        return SIPAggrAmt;
    }

    public void setSIPAggrAmt(String SIPAggrAmt) {
        this.SIPAggrAmt = SIPAggrAmt;
    }

    public String getSIPAllowed() {
        return SIPAllowed;
    }

    public void setSIPAllowed(String SIPAllowed) {
        this.SIPAllowed = SIPAllowed;
    }

    public String getREDEEMAllowed() {
        return REDEEMAllowed;
    }

    public void setREDEEMAllowed(String REDEEMAllowed) {
        this.REDEEMAllowed = REDEEMAllowed;
    }

    public String getSWPAllowed() {
        return SWPAllowed;
    }

    public void setSWPAllowed(String SWPAllowed) {
        this.SWPAllowed = SWPAllowed;
    }

    public String getCostofInvestment() {
        return CostofInvestment;
    }

    public void setCostofInvestment(String costofInvestment) {
        CostofInvestment = costofInvestment;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        Classification = classification;
    }

    public String getIssuer() {
        return Issuer;
    }

    public void setIssuer(String issuer) {
        Issuer = issuer;
    }

    public String getMaturityDate() {
        return MaturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        MaturityDate = maturityDate;
    }

    public String getSchemeCode() {
        return SchemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        SchemeCode = schemeCode;
    }

    public String getELSSLocking() {
        return ELSSLocking;
    }

    public void setELSSLocking(String ELSSLocking) {
        this.ELSSLocking = ELSSLocking;
    }

    public String getIIN() {
        return IIN;
    }

    public void setIIN(String IIN) {
        this.IIN = IIN;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ClientCode);
        parcel.writeString(SchemeName);
        parcel.writeString(Folio);
        parcel.writeString(Quantity);
        parcel.writeString(ValueOfCost);
        parcel.writeString(CurrentPrice);
        parcel.writeString(MarketValue);
        parcel.writeString(Dividend);
        parcel.writeString(GainLossPercentage);
        parcel.writeString(NetGain);
        parcel.writeString(CommonScripCode);
        parcel.writeString(ClientName);
        parcel.writeString(AverageCost);
        parcel.writeString(MarketValue1);
        parcel.writeString(SortOrder);
        parcel.writeString(IncludeAmount);
        parcel.writeString(DataSource);
        parcel.writeString(Title);
        parcel.writeString(Source);
        parcel.writeString(BenchmarkXirr);
        parcel.writeString(CurrencyName);
        parcel.writeString(FolioNumber);
        parcel.writeString(InceptionDate);
        parcel.writeString(PortfolioWeight);
        parcel.writeString(XirrAsset);
        parcel.writeString(BenchmarkXirrAsset);
        parcel.writeString(L4Client_Code);
        parcel.writeString(FundOption);
        parcel.writeString(FundRiskRating);
        parcel.writeString(SipStartDates);
        parcel.writeString(AssetClassCode);
        parcel.writeString(AssetClassName);
        parcel.writeString(IsDividend);
        parcel.writeString(DividendOption);
        parcel.writeString(ValueResearchRating);
        parcel.writeString(MinInvAmount);
        parcel.writeString(MinSWPUnit);
        parcel.writeString(MinRedeemUnit);
        parcel.writeString(CurrentFundValue);
        parcel.writeString(AwaitingHoldingUnit);
        parcel.writeString(AwaitingHoldingFundValue);
        parcel.writeString(ExistingAmount);
        parcel.writeString(ExistingUnits);
        parcel.writeString(CurrentUnits);
        parcel.writeString(SwitchOutAllowed);
        parcel.writeString(SIPAggrAmt);
        parcel.writeString(SIPAllowed);
        parcel.writeString(REDEEMAllowed);
        parcel.writeString(SWPAllowed);
        parcel.writeString(CostofInvestment);
        parcel.writeString(Classification);
        parcel.writeString(Issuer);
        parcel.writeString(MaturityDate);
        parcel.writeString(SchemeCode);
        parcel.writeString(ELSSLocking);
        parcel.writeString(IIN);
    }
}
