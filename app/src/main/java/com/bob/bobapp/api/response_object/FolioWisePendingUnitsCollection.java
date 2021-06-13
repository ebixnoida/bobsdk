package com.bob.bobapp.api.response_object;

public class FolioWisePendingUnitsCollection {

    private String AwaitinHoldingAmount;

    private String FolioNo;

    private String AwaitinHoldingUnits;

    public String getAwaitinHoldingAmount ()
    {
        return AwaitinHoldingAmount;
    }

    public void setAwaitinHoldingAmount (String AwaitinHoldingAmount)
    {
        this.AwaitinHoldingAmount = AwaitinHoldingAmount;
    }

    public String getFolioNo() {
        return FolioNo;
    }

    public void setFolioNo(String folioNo) {
        FolioNo = folioNo;
    }

    public String getAwaitinHoldingUnits ()
    {
        return AwaitinHoldingUnits;
    }

    public void setAwaitinHoldingUnits (String AwaitinHoldingUnits)
    {
        this.AwaitinHoldingUnits = AwaitinHoldingUnits;
    }
}
