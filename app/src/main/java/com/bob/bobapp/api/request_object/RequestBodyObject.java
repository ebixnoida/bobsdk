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

    @SerializedName("RiskProfileQuestionnaire")
    private RiskProfileQuestionnaireBean RiskProfileQuestionnaire;

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

    /*public static RequestBodyObject getRequestBodyObject() {

        if (requestBodyObject == null) {

            requestBodyObject = new RequestBodyObject();
        }

        return requestBodyObject;
    }

    public static void createRequestBodyObject(String userId, String userType, String userCode, String lastBusinessDate, String currencyCode, String amountDenomination, String accountLevel) {

        requestBodyObject = getRequestBodyObject();

        requestBodyObject.setUserId(userId);

        requestBodyObject.setUserType(userType);

        requestBodyObject.setUserCode(userCode);

        requestBodyObject.setLastBusinessDate(lastBusinessDate);

        requestBodyObject.setCurrencyCode(currencyCode);

        requestBodyObject.setAmountDenomination(amountDenomination);

        requestBodyObject.setAccountLevel(accountLevel);
    }*/
}
