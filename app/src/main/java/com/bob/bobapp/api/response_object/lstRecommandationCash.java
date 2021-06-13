package com.bob.bobapp.api.response_object;

public class lstRecommandationCash
{
    private String Nature;

    private String  Options;

    private String ReturnIn3Year;

    private String FundName;

    private String SchemeCode;

    private String Classification;

    private String ReturnIn6Month;

    private String ReturnIn3Month;

    private String ReturnIn1Year;

    private String SinceInception;

    public String getNature ()
    {
        return Nature;
    }

    public void setNature (String Nature)
    {
        this.Nature = Nature;
    }

    public String  getOptions ()
    {
        return Options;
    }

    public void setOptions (String Options)
    {
        this.Options = Options;
    }

    public String getReturnIn3Year ()
    {
        return ReturnIn3Year;
    }

    public void setReturnIn3Year (String ReturnIn3Year)
    {
        this.ReturnIn3Year = ReturnIn3Year;
    }

    public String getFundName ()
    {
        return FundName;
    }

    public void setFundName (String FundName)
    {
        this.FundName = FundName;
    }

    public String getSchemeCode ()
    {
        return SchemeCode;
    }

    public void setSchemeCode (String SchemeCode)
    {
        this.SchemeCode = SchemeCode;
    }

    public String getClassification ()
    {
        return Classification;
    }

    public void setClassification (String Classification)
    {
        this.Classification = Classification;
    }

    public String getReturnIn6Month ()
    {
        return ReturnIn6Month;
    }

    public void setReturnIn6Month (String ReturnIn6Month)
    {
        this.ReturnIn6Month = ReturnIn6Month;
    }

    public String getReturnIn3Month ()
    {
        return ReturnIn3Month;
    }

    public void setReturnIn3Month (String ReturnIn3Month)
    {
        this.ReturnIn3Month = ReturnIn3Month;
    }

    public String getReturnIn1Year ()
    {
        return ReturnIn1Year;
    }

    public void setReturnIn1Year (String ReturnIn1Year)
    {
        this.ReturnIn1Year = ReturnIn1Year;
    }

    public String getSinceInception ()
    {
        return SinceInception;
    }

    public void setSinceInception (String SinceInception)
    {
        this.SinceInception = SinceInception;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Nature = "+Nature+", Options = "+Options+", ReturnIn3Year = "+ReturnIn3Year+", FundName = "+FundName+", SchemeCode = "+SchemeCode+", Classification = "+Classification+", ReturnIn6Month = "+ReturnIn6Month+", ReturnIn3Month = "+ReturnIn3Month+", ReturnIn1Year = "+ReturnIn1Year+", SinceInception = "+SinceInception+"]";
    }
}
