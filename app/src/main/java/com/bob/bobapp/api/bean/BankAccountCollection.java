package com.bob.bobapp.api.bean;

public class BankAccountCollection {

    private String Name;

    private String AccountNo;

    private String Branch;

    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public void setAccountNo(String AccountNo){
        this.AccountNo = AccountNo;
    }
    public String getAccountNo(){
        return this.AccountNo;
    }
    public void setBranch(String Branch){
        this.Branch = Branch;
    }
    public String getBranch(){
        return this.Branch;
    }
}
