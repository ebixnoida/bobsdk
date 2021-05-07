package com.bob.bobapp.api.response_object;

public class BankAccountResponse {
    private String BankName;

    private String InternalCLient;

    private String CurrencyDecimal;

    private String BankAccountNo;

    private String BankSource;

    private String BankCode;

    private String ShortName;

    public String getBankName ()
    {
        return BankName;
    }

    public void setBankName (String BankName)
    {
        this.BankName = BankName;
    }

    public String getInternalCLient ()
    {
        return InternalCLient;
    }

    public void setInternalCLient (String InternalCLient)
    {
        this.InternalCLient = InternalCLient;
    }

    public String getCurrencyDecimal ()
    {
        return CurrencyDecimal;
    }

    public void setCurrencyDecimal (String CurrencyDecimal)
    {
        this.CurrencyDecimal = CurrencyDecimal;
    }

    public String getBankAccountNo ()
    {
        return BankAccountNo;
    }

    public void setBankAccountNo (String BankAccountNo)
    {
        this.BankAccountNo = BankAccountNo;
    }

    public String getBankSource ()
    {
        return BankSource;
    }

    public void setBankSource (String BankSource)
    {
        this.BankSource = BankSource;
    }

    public String getBankCode ()
    {
        return BankCode;
    }

    public void setBankCode (String BankCode)
    {
        this.BankCode = BankCode;
    }

    public String getShortName ()
    {
        return ShortName;
    }

    public void setShortName (String ShortName)
    {
        this.ShortName = ShortName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [BankName = "+BankName+", InternalCLient = "+InternalCLient+", CurrencyDecimal = "+CurrencyDecimal+", BankAccountNo = "+BankAccountNo+", BankSource = "+BankSource+", BankCode = "+BankCode+", ShortName = "+ShortName+"]";
    }
}
