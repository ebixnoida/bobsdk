package com.bob.bobapp.api.request_object;
import com.bob.bobapp.api.bean.RiskProfileQuestionnaireBean;
import com.google.gson.annotations.SerializedName;

public class RequestBodyObject
{
    private static RequestBodyObject requestBodyObject = null;

    @SerializedName("UserId")
    private String userId;

    @SerializedName("UserType")
    private String userType;

    @SerializedName("UserCode")
    private String userCode;

    @SerializedName("LastBusinessDate")
    private String lastBusinessDate;

    @SerializedName("CurrencyCode")
    private String currencyCode;

    @SerializedName("AmountDenomination")
    private String amountDenomination;

    @SerializedName("AccountLevel")
    private String accountLevel;

    @SerializedName("ClientCode")
    private String clientCode;

    @SerializedName("ClientType")
    private String ClientType;

    @SerializedName("IsFundware")
    private String IsFundware;

    @SerializedName("ParentChannelID")
    private String parentChannelID;

    @SerializedName("AllocationType")
    private String AllocationType;

    @SerializedName("IndexType")
    private String IndexType;

    @SerializedName("FromDate")
    private String FromDate;

    @SerializedName("ReminderPeriod")
    private String ReminderPeriod;

    @SerializedName("MWIClientCode")
    private String MWIClientCode;

    @SerializedName("SchemeCode")
    private String SchemeCode;

    @SerializedName("TransactionType")
    private String TransactionType;

    @SerializedName("TillDate")
    private String TillDate;

    @SerializedName("RiskProfileQuestionnaire")
    private RiskProfileQuestionnaireBean RiskProfileQuestionnaire;

    @SerializedName("LatestNAV")
    private String LatestNAV;

    @SerializedName("SchemeName")
    private String SchemeName;

    @SerializedName("ValueResearchRating")
    private String ValueResearchRating;

    @SerializedName("FundRiskRating")
    private String FundRiskRating;

    @SerializedName("AssetClassCode")
    private String AssetClassCode;

    @SerializedName("inputmode")
    private String inputmode;

    @SerializedName("TxnAmountUnit")
    private String TxnAmountUnit;

    @SerializedName("IsDividend")
    private String IsDividend;

    @SerializedName("DividendOption")
    private String DividendOption;

    @SerializedName("L4ClientCode")
    private String L4ClientCode;

    @SerializedName("CurrentUnits")
    private String CurrentUnits;

    @SerializedName("CurrentFundValue")
    private String CurrentFundValue;

    @SerializedName("CostofInvestment")
    private String CostofInvestment;

    @SerializedName("frequency")
    private String frequency;

    @SerializedName("AllorPartial")
    private String AllorPartial;

    @SerializedName("AmountOrUnit")
    private String AmountOrUnit;

    @SerializedName("StartDate")
    private String StartDate;

    @SerializedName("TargetFundCode")
    private String TargetFundCode;

    @SerializedName("Period")
    private String Period;

    @SerializedName("NoofMonth")
    private String NoofMonth;

    @SerializedName("ICDID")
    private String ICDID;

    @SerializedName("SettlementBankCode")
    private String SettlementBankCode;

    @SerializedName("SipStartDates")
    private String SipStartDates;

    @SerializedName("NomineeName1")
    private String NomineeName1;

    @SerializedName("DateOfBirth1")
    private String DateOfBirth1;

    @SerializedName("NomineeRelationship1")
    private String NomineeRelationship1;

    @SerializedName("NomineeShare1")
    private String NomineeShare1;

    @SerializedName("NomineeAddress1")
    private String NomineeAddress1;

    @SerializedName("NomineeIsMinor1")
    private String NomineeIsMinor1;

    @SerializedName("NomineeName2")
    private String NomineeName2;

    @SerializedName("DateOfBirth2")
    private String DateOfBirth2;

    @SerializedName("NomineeRelationship2")
    private String NomineeRelationship2;

    @SerializedName("NomineeShare2")
    private String NomineeShare2;

    @SerializedName("NomineeAddress2")
    private String NomineeAddress2;

    @SerializedName("NomineeIsMinor2")
    private String NomineeIsMinor2;

    @SerializedName("GuardianName2")
    private String GuardianName2;

    @SerializedName("NomineeName3")
    private String NomineeName3;

    @SerializedName("DateOfBirth3")
    private String DateOfBirth3;

    @SerializedName("NomineeRelationship3")
    private String NomineeRelationship3;

    @SerializedName("NomineeShare3")
    private String NomineeShare3;

    @SerializedName("NomineeAddress3")
    private String NomineeAddress3;

    @SerializedName("NomineeIsMinor3")
    private String NomineeIsMinor3;

    @SerializedName("GuardianName3")
    private String GuardianName3;

    @SerializedName("IsApplyNominee")
    private String IsApplyNominee;


    public RiskProfileQuestionnaireBean getRiskProfileQuestionnaire() {
        return RiskProfileQuestionnaire;
    }

    public void setRiskProfileQuestionnaire(RiskProfileQuestionnaireBean riskProfileQuestionnaire) {
        RiskProfileQuestionnaire = riskProfileQuestionnaire;
    }

    public String getMWIClientCode() {
        return MWIClientCode;
    }

    public void setMWIClientCode(String MWIClientCode) {
        this.MWIClientCode = MWIClientCode;
    }

    public String getSchemeCode() {
        return SchemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        SchemeCode = schemeCode;
    }

    public String getReminderPeriod() {
        return ReminderPeriod;
    }

    public void setReminderPeriod(String reminderPeriod) {
        ReminderPeriod = reminderPeriod;
    }

    public String getFromDate() {
        return FromDate;
    }

    public void setFromDate(String fromDate) {
        FromDate = fromDate;
    }

    public String getIndexType() {
        return IndexType;
    }

    public void setIndexType(String indexType) {
        IndexType = indexType;
    }

    public String getAllocationType() {
        return AllocationType;
    }

    public void setAllocationType(String allocationType) {
        AllocationType = allocationType;
    }

    public String getIsFundware() {
        return IsFundware;
    }

    public void setIsFundware(String isFundware) {
        IsFundware = isFundware;
    }

    public String getClientType() {
        return ClientType;
    }

    public void setClientType(String clientType) {
        ClientType = clientType;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getParentChannelID() {
        return parentChannelID;
    }

    public void setParentChannelID(String parentChannelID) {
        this.parentChannelID = parentChannelID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLastBusinessDate() {
        return lastBusinessDate;
    }

    public void setLastBusinessDate(String lastBusinessDate) {
        this.lastBusinessDate = lastBusinessDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmountDenomination() {
        return amountDenomination;
    }

    public void setAmountDenomination(String amountDenomination) {
        this.amountDenomination = amountDenomination;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String getTillDate() {
        return TillDate;
    }

    public void setTillDate(String tillDate) {
        TillDate = tillDate;
    }

    public String getLatestNAV() {
        return LatestNAV;
    }

    public void setLatestNAV(String latestNAV) {
        LatestNAV = latestNAV;
    }

    public String getSchemeName() {
        return SchemeName;
    }

    public void setSchemeName(String schemeName) {
        SchemeName = schemeName;
    }

    public String getValueResearchRating() {
        return ValueResearchRating;
    }

    public void setValueResearchRating(String valueResearchRating) {
        ValueResearchRating = valueResearchRating;
    }

    public String getFundRiskRating() {
        return FundRiskRating;
    }

    public void setFundRiskRating(String fundRiskRating) {
        FundRiskRating = fundRiskRating;
    }

    public String getAssetClassCode() {
        return AssetClassCode;
    }

    public void setAssetClassCode(String assetClassCode) {
        AssetClassCode = assetClassCode;
    }

    public String getInputmode() {
        return inputmode;
    }

    public void setInputmode(String inputmode) {
        this.inputmode = inputmode;
    }

    public String getTxnAmountUnit() {
        return TxnAmountUnit;
    }

    public void setTxnAmountUnit(String txnAmountUnit) {
        TxnAmountUnit = txnAmountUnit;
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

    public String getL4ClientCode() {
        return L4ClientCode;
    }

    public void setL4ClientCode(String l4ClientCode) {
        L4ClientCode = l4ClientCode;
    }

    public String getCurrentUnits() {
        return CurrentUnits;
    }

    public void setCurrentUnits(String currentUnits) {
        CurrentUnits = currentUnits;
    }

    public String getCurrentFundValue() {
        return CurrentFundValue;
    }

    public void setCurrentFundValue(String currentFundValue) {
        CurrentFundValue = currentFundValue;
    }

    public String getCostofInvestment() {
        return CostofInvestment;
    }

    public void setCostofInvestment(String costofInvestment) {
        CostofInvestment = costofInvestment;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAllorPartial() {
        return AllorPartial;
    }

    public void setAllorPartial(String allorPartial) {
        AllorPartial = allorPartial;
    }

    public String getAmountOrUnit() {
        return AmountOrUnit;
    }

    public void setAmountOrUnit(String amountOrUnit) {
        AmountOrUnit = amountOrUnit;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getTargetFundCode() {
        return TargetFundCode;
    }

    public void setTargetFundCode(String targetFundCode) {
        TargetFundCode = targetFundCode;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getNoofMonth() {
        return NoofMonth;
    }

    public void setNoofMonth(String noofMonth) {
        NoofMonth = noofMonth;
    }

    public String getICDID() {
        return ICDID;
    }

    public void setICDID(String ICDID) {
        this.ICDID = ICDID;
    }

    public String getSettlementBankCode() {
        return SettlementBankCode;
    }

    public void setSettlementBankCode(String settlementBankCode) {
        SettlementBankCode = settlementBankCode;
    }

    public String getSipStartDates() {
        return SipStartDates;
    }

    public void setSipStartDates(String sipStartDates) {
        SipStartDates = sipStartDates;
    }

    public String getNomineeName1() {
        return NomineeName1;
    }

    public void setNomineeName1(String nomineeName1) {
        NomineeName1 = nomineeName1;
    }

    public String getDateOfBirth1() {
        return DateOfBirth1;
    }

    public void setDateOfBirth1(String dateOfBirth1) {
        DateOfBirth1 = dateOfBirth1;
    }

    public String getNomineeRelationship1() {
        return NomineeRelationship1;
    }

    public void setNomineeRelationship1(String nomineeRelationship1) {
        NomineeRelationship1 = nomineeRelationship1;
    }

    public String getNomineeShare1() {
        return NomineeShare1;
    }

    public void setNomineeShare1(String nomineeShare1) {
        NomineeShare1 = nomineeShare1;
    }

    public String getNomineeAddress1() {
        return NomineeAddress1;
    }

    public void setNomineeAddress1(String nomineeAddress1) {
        NomineeAddress1 = nomineeAddress1;
    }

    public String getNomineeIsMinor1() {
        return NomineeIsMinor1;
    }

    public void setNomineeIsMinor1(String nomineeIsMinor1) {
        NomineeIsMinor1 = nomineeIsMinor1;
    }

    public String getNomineeName2() {
        return NomineeName2;
    }

    public void setNomineeName2(String nomineeName2) {
        NomineeName2 = nomineeName2;
    }

    public String getDateOfBirth2() {
        return DateOfBirth2;
    }

    public void setDateOfBirth2(String dateOfBirth2) {
        DateOfBirth2 = dateOfBirth2;
    }

    public String getNomineeRelationship2() {
        return NomineeRelationship2;
    }

    public void setNomineeRelationship2(String nomineeRelationship2) {
        NomineeRelationship2 = nomineeRelationship2;
    }

    public String getNomineeShare2() {
        return NomineeShare2;
    }

    public void setNomineeShare2(String nomineeShare2) {
        NomineeShare2 = nomineeShare2;
    }

    public String getNomineeAddress2() {
        return NomineeAddress2;
    }

    public void setNomineeAddress2(String nomineeAddress2) {
        NomineeAddress2 = nomineeAddress2;
    }

    public String getNomineeIsMinor2() {
        return NomineeIsMinor2;
    }

    public void setNomineeIsMinor2(String nomineeIsMinor2) {
        NomineeIsMinor2 = nomineeIsMinor2;
    }

    public String getGuardianName2() {
        return GuardianName2;
    }

    public void setGuardianName2(String guardianName2) {
        GuardianName2 = guardianName2;
    }

    public String getNomineeName3() {
        return NomineeName3;
    }

    public void setNomineeName3(String nomineeName3) {
        NomineeName3 = nomineeName3;
    }

    public String getDateOfBirth3() {
        return DateOfBirth3;
    }

    public void setDateOfBirth3(String dateOfBirth3) {
        DateOfBirth3 = dateOfBirth3;
    }

    public String getNomineeRelationship3() {
        return NomineeRelationship3;
    }

    public void setNomineeRelationship3(String nomineeRelationship3) {
        NomineeRelationship3 = nomineeRelationship3;
    }

    public String getNomineeShare3() {
        return NomineeShare3;
    }

    public void setNomineeShare3(String nomineeShare3) {
        NomineeShare3 = nomineeShare3;
    }

    public String getNomineeAddress3() {
        return NomineeAddress3;
    }

    public void setNomineeAddress3(String nomineeAddress3) {
        NomineeAddress3 = nomineeAddress3;
    }

    public String getNomineeIsMinor3() {
        return NomineeIsMinor3;
    }

    public void setNomineeIsMinor3(String nomineeIsMinor3) {
        NomineeIsMinor3 = nomineeIsMinor3;
    }

    public String getGuardianName3() {
        return GuardianName3;
    }

    public void setGuardianName3(String guardianName3) {
        GuardianName3 = guardianName3;
    }

    public String getIsApplyNominee() {
        return IsApplyNominee;
    }

    public void setIsApplyNominee(String isApplyNominee) {
        IsApplyNominee = isApplyNominee;
    }
}
