package com.bob.bobapp.api.response_object;

public class AccountsResponse {
    private String  OnlineAccountCode;

    private String HatCode;

    private String ClientName;

    private String ClientCode;

    private String JHNames;

    private String TName;

    public String getOnlineAccountCode ()
    {
        return OnlineAccountCode;
    }

    public void setOnlineAccountCode (String OnlineAccountCode)
    {
        this.OnlineAccountCode = OnlineAccountCode;
    }

    public String getHatCode ()
    {
        return HatCode;
    }

    public void setHatCode (String HatCode)
    {
        this.HatCode = HatCode;
    }

    public String getClientName ()
    {
        return ClientName;
    }

    public void setClientName (String ClientName)
    {
        this.ClientName = ClientName;
    }

    public String getClientCode ()
    {
        return ClientCode;
    }

    public void setClientCode (String ClientCode)
    {
        this.ClientCode = ClientCode;
    }

    public String getJHNames ()
    {
        return JHNames;
    }

    public void setJHNames (String JHNames)
    {
        this.JHNames = JHNames;
    }

    public String getTName ()
    {
        return TName;
    }

    public void setTName (String TName)
    {
        this.TName = TName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [OnlineAccountCode = "+OnlineAccountCode+", HatCode = "+HatCode+", ClientName = "+ClientName+", ClientCode = "+ClientCode+", JHNames = "+JHNames+", TName = "+TName+"]";
    }
}
