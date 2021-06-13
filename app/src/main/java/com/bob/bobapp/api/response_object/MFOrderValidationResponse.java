package com.bob.bobapp.api.response_object;

import java.util.ArrayList;

public class MFOrderValidationResponse {

    private String FundOption;

    private String DividendOption;

    private String ExistingAmount;

    private String LatestNAV;

    private String MinPurchaseAmt;

    private String IsDividend;

    private String MinSWPUnit;

    private String SWPAllowed;

    private String MinSIPInstallments;

    private String MinRedeemUnit;

    private String SipFrequency;

    private String cutOffTimeCrossed;

    private String STPAllowed;

    private ArrayList<FolioWisePendingUnitsCollection> FolioWisePendingUnitsCollection;

    private String SipStartDates;

    private String ExistingUnits;

    private String SwitchOutAllowed;

    private String FundRiskRating;

    private String AwaitingHoldingFundValue;

    private String MinInvAmount;

    private String ValueResearchRating;

    private String SIPAllowed;

    private String REDEEMAllowed;

    private String AwaitingHoldingUnit;

    public String getFundOption ()
    {
        return FundOption;
    }

    public void setFundOption (String FundOption)
    {
        this.FundOption = FundOption;
    }

    public String getDividendOption ()
    {
        return DividendOption;
    }

    public void setDividendOption (String DividendOption)
    {
        this.DividendOption = DividendOption;
    }

    public String getExistingAmount ()
    {
        return ExistingAmount;
    }

    public void setExistingAmount (String ExistingAmount)
    {
        this.ExistingAmount = ExistingAmount;
    }

    public String getLatestNAV ()
    {
        return LatestNAV;
    }

    public void setLatestNAV (String LatestNAV)
    {
        this.LatestNAV = LatestNAV;
    }

    public String getMinPurchaseAmt ()
    {
        return MinPurchaseAmt;
    }

    public void setMinPurchaseAmt (String MinPurchaseAmt)
    {
        this.MinPurchaseAmt = MinPurchaseAmt;
    }

    public String getIsDividend ()
    {
        return IsDividend;
    }

    public void setIsDividend (String IsDividend)
    {
        this.IsDividend = IsDividend;
    }

    public String getMinSWPUnit ()
    {
        return MinSWPUnit;
    }

    public void setMinSWPUnit (String MinSWPUnit)
    {
        this.MinSWPUnit = MinSWPUnit;
    }

    public String getSWPAllowed ()
    {
        return SWPAllowed;
    }

    public void setSWPAllowed (String SWPAllowed)
    {
        this.SWPAllowed = SWPAllowed;
    }

    public String getMinRedeemUnit ()
    {
        return MinRedeemUnit;
    }

    public void setMinRedeemUnit (String MinRedeemUnit)
    {
        this.MinRedeemUnit = MinRedeemUnit;
    }

    public String getSipFrequency ()
    {
        return SipFrequency;
    }

    public void setSipFrequency (String SipFrequency)
    {
        this.SipFrequency = SipFrequency;
    }

    public String getCutOffTimeCrossed ()
    {
        return cutOffTimeCrossed;
    }

    public void setCutOffTimeCrossed (String cutOffTimeCrossed)
    {
        this.cutOffTimeCrossed = cutOffTimeCrossed;
    }

    public String getSTPAllowed ()
    {
        return STPAllowed;
    }

    public void setSTPAllowed (String STPAllowed)
    {
        this.STPAllowed = STPAllowed;
    }

    public String getSipStartDates ()
    {
        return SipStartDates;
    }

    public void setSipStartDates (String SipStartDates)
    {
        this.SipStartDates = SipStartDates;
    }

    public String getExistingUnits ()
    {
        return ExistingUnits;
    }

    public void setExistingUnits (String ExistingUnits)
    {
        this.ExistingUnits = ExistingUnits;
    }

    public String getSwitchOutAllowed ()
    {
        return SwitchOutAllowed;
    }

    public void setSwitchOutAllowed (String SwitchOutAllowed)
    {
        this.SwitchOutAllowed = SwitchOutAllowed;
    }

    public String getAwaitingHoldingFundValue ()
    {
        return AwaitingHoldingFundValue;
    }

    public void setAwaitingHoldingFundValue (String AwaitingHoldingFundValue)
    {
        this.AwaitingHoldingFundValue = AwaitingHoldingFundValue;
    }

    public String getMinInvAmount ()
    {
        return MinInvAmount;
    }

    public void setMinInvAmount (String MinInvAmount)
    {
        this.MinInvAmount = MinInvAmount;
    }

    public String getValueResearchRating ()
    {
        return ValueResearchRating;
    }

    public void setValueResearchRating (String ValueResearchRating)
    {
        this.ValueResearchRating = ValueResearchRating;
    }

    public String getSIPAllowed ()
    {
        return SIPAllowed;
    }

    public void setSIPAllowed (String SIPAllowed)
    {
        this.SIPAllowed = SIPAllowed;
    }

    public String getREDEEMAllowed ()
    {
        return REDEEMAllowed;
    }

    public void setREDEEMAllowed (String REDEEMAllowed)
    {
        this.REDEEMAllowed = REDEEMAllowed;
    }

    public String getAwaitingHoldingUnit ()
    {
        return AwaitingHoldingUnit;
    }

    public void setAwaitingHoldingUnit (String AwaitingHoldingUnit)
    {
        this.AwaitingHoldingUnit = AwaitingHoldingUnit;
    }

    public String getMinSIPInstallments() {
        return MinSIPInstallments;
    }

    public void setMinSIPInstallments(String minSIPInstallments) {
        MinSIPInstallments = minSIPInstallments;
    }

    public String getFundRiskRating() {
        return FundRiskRating;
    }

    public void setFundRiskRating(String fundRiskRating) {
        FundRiskRating = fundRiskRating;
    }

    public ArrayList<com.bob.bobapp.api.response_object.FolioWisePendingUnitsCollection> getFolioWisePendingUnitsCollection() {
        return FolioWisePendingUnitsCollection;
    }

    public void setFolioWisePendingUnitsCollection(ArrayList<com.bob.bobapp.api.response_object.FolioWisePendingUnitsCollection> folioWisePendingUnitsCollection) {
        FolioWisePendingUnitsCollection = folioWisePendingUnitsCollection;
    }
}
