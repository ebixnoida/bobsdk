package com.bob.bobapp.api.response_object;

import com.bob.bobapp.api.bean.BankAccountCollection;
import com.bob.bobapp.api.bean.DematAccountCollection;
import com.bob.bobapp.api.bean.FamilyMemberCollection;
import com.bob.bobapp.api.bean.FilePathCollection;

import java.util.List;

public class RMDetailResponseObject {

    private String PrimaryRMCode;

    private String PrimaryRMName;

    private String PrimaryRMContactNo;

    private String PrimaryRMEmail;

    private String PrimaryRMBranch;

    private String SecondaryRMCode;

    private String SecondaryRMName;

    private String SecondaryRMContactNo;

    private String SecondaryRMEmail;

    private String SecondaryRMBranch;

    private String ClientCode;

    private String OnlineAccountCode;

    private String Salutation;

    private String ClientName;

    private String ClientFirstName;

    private String ClientMiddleName;

    private String ClientLastName;

    private String ContactNo;

    private String EmailAddress;

    private String Category;

    private String RiskProfile;

    private String AUM;

    private int Revenue;

    private String TaxID;

    private String Address;

    private List<FamilyMemberCollection> FamilyMemberCollection;

    private int Gender;

    private String FamilyName;

    private int MaritalStatus;

    private String DateOfBirth;

    private String AnniversaryDate;

    private List<BankAccountCollection> BankAccountCollection;

    private List<DematAccountCollection> DematAccountCollection;

    private String CommunicationAddress;

    private String CommunicationContact;

    private String Potential;

    private String BusinessUnit;

    private String Classification;

    private String CurrencyName;

    private int CurrencyCode;

    private List<FilePathCollection> FilePathCollection;

    private String TaskID;

    private String Identifier;

    private String RiskProfileAsOnDate;

    private boolean FamilyHead;

    private String ClientId;

    private String FamilyCode;

    private String CategoryDate;

    private String RiskProfileDate;

    private String InfinityId;

    private String City;

    private String IsRiskProfileExpired;

    private String KYCFlag;

    public void setPrimaryRMCode(String PrimaryRMCode){
        this.PrimaryRMCode = PrimaryRMCode;
    }
    public String getPrimaryRMCode(){
        return this.PrimaryRMCode;
    }
    public void setPrimaryRMName(String PrimaryRMName){
        this.PrimaryRMName = PrimaryRMName;
    }
    public String getPrimaryRMName(){
        return this.PrimaryRMName;
    }
    public void setPrimaryRMContactNo(String PrimaryRMContactNo){
        this.PrimaryRMContactNo = PrimaryRMContactNo;
    }
    public String getPrimaryRMContactNo(){
        return this.PrimaryRMContactNo;
    }
    public void setPrimaryRMEmail(String PrimaryRMEmail){
        this.PrimaryRMEmail = PrimaryRMEmail;
    }
    public String getPrimaryRMEmail(){
        return this.PrimaryRMEmail;
    }
    public void setPrimaryRMBranch(String PrimaryRMBranch){
        this.PrimaryRMBranch = PrimaryRMBranch;
    }
    public String getPrimaryRMBranch(){
        return this.PrimaryRMBranch;
    }
    public void setSecondaryRMCode(String SecondaryRMCode){
        this.SecondaryRMCode = SecondaryRMCode;
    }
    public String getSecondaryRMCode(){
        return this.SecondaryRMCode;
    }
    public void setSecondaryRMName(String SecondaryRMName){
        this.SecondaryRMName = SecondaryRMName;
    }
    public String getSecondaryRMName(){
        return this.SecondaryRMName;
    }
    public void setSecondaryRMContactNo(String SecondaryRMContactNo){
        this.SecondaryRMContactNo = SecondaryRMContactNo;
    }
    public String getSecondaryRMContactNo(){
        return this.SecondaryRMContactNo;
    }
    public void setSecondaryRMEmail(String SecondaryRMEmail){
        this.SecondaryRMEmail = SecondaryRMEmail;
    }
    public String getSecondaryRMEmail(){
        return this.SecondaryRMEmail;
    }
    public void setSecondaryRMBranch(String SecondaryRMBranch){
        this.SecondaryRMBranch = SecondaryRMBranch;
    }
    public String getSecondaryRMBranch(){
        return this.SecondaryRMBranch;
    }
    public void setClientCode(String ClientCode){
        this.ClientCode = ClientCode;
    }
    public String getClientCode(){
        return this.ClientCode;
    }
    public void setOnlineAccountCode(String OnlineAccountCode){
        this.OnlineAccountCode = OnlineAccountCode;
    }
    public String getOnlineAccountCode(){
        return this.OnlineAccountCode;
    }
    public void setSalutation(String Salutation){
        this.Salutation = Salutation;
    }
    public String getSalutation(){
        return this.Salutation;
    }
    public void setClientName(String ClientName){
        this.ClientName = ClientName;
    }
    public String getClientName(){
        return this.ClientName;
    }
    public void setClientFirstName(String ClientFirstName){
        this.ClientFirstName = ClientFirstName;
    }
    public String getClientFirstName(){
        return this.ClientFirstName;
    }
    public void setClientMiddleName(String ClientMiddleName){
        this.ClientMiddleName = ClientMiddleName;
    }
    public String getClientMiddleName(){
        return this.ClientMiddleName;
    }
    public void setClientLastName(String ClientLastName){
        this.ClientLastName = ClientLastName;
    }
    public String getClientLastName(){
        return this.ClientLastName;
    }
    public void setContactNo(String ContactNo){
        this.ContactNo = ContactNo;
    }
    public String getContactNo(){
        return this.ContactNo;
    }
    public void setEmailAddress(String EmailAddress){
        this.EmailAddress = EmailAddress;
    }
    public String getEmailAddress(){
        return this.EmailAddress;
    }
    public void setCategory(String Category){
        this.Category = Category;
    }
    public String getCategory(){
        return this.Category;
    }
    public void setRiskProfile(String RiskProfile){
        this.RiskProfile = RiskProfile;
    }
    public String getRiskProfile(){
        return this.RiskProfile;
    }
    public void setAUM(String AUM){
        this.AUM = AUM;
    }
    public String getAUM(){
        return this.AUM;
    }
    public void setRevenue(int Revenue){
        this.Revenue = Revenue;
    }
    public int getRevenue(){
        return this.Revenue;
    }
    public void setTaxID(String TaxID){
        this.TaxID = TaxID;
    }
    public String getTaxID(){
        return this.TaxID;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public String getAddress(){
        return this.Address;
    }
    public void setFamilyMemberCollection(List<FamilyMemberCollection> FamilyMemberCollection){
        this.FamilyMemberCollection = FamilyMemberCollection;
    }
    public List<FamilyMemberCollection> getFamilyMemberCollection(){
        return this.FamilyMemberCollection;
    }
    public void setGender(int Gender){
        this.Gender = Gender;
    }
    public int getGender(){
        return this.Gender;
    }
    public void setFamilyName(String FamilyName){
        this.FamilyName = FamilyName;
    }
    public String getFamilyName(){
        return this.FamilyName;
    }
    public void setMaritalStatus(int MaritalStatus){
        this.MaritalStatus = MaritalStatus;
    }
    public int getMaritalStatus(){
        return this.MaritalStatus;
    }
    public void setDateOfBirth(String DateOfBirth){
        this.DateOfBirth = DateOfBirth;
    }
    public String getDateOfBirth(){
        return this.DateOfBirth;
    }
    public void setAnniversaryDate(String AnniversaryDate){
        this.AnniversaryDate = AnniversaryDate;
    }
    public String getAnniversaryDate(){
        return this.AnniversaryDate;
    }
    public void setBankAccountCollection(List<BankAccountCollection> BankAccountCollection){
        this.BankAccountCollection = BankAccountCollection;
    }
    public List<BankAccountCollection> getBankAccountCollection(){
        return this.BankAccountCollection;
    }
    public void setDematAccountCollection(List<DematAccountCollection> DematAccountCollection){
        this.DematAccountCollection = DematAccountCollection;
    }
    public List<DematAccountCollection> getDematAccountCollection(){
        return this.DematAccountCollection;
    }
    public void setCommunicationAddress(String CommunicationAddress){
        this.CommunicationAddress = CommunicationAddress;
    }
    public String getCommunicationAddress(){
        return this.CommunicationAddress;
    }
    public void setCommunicationContact(String CommunicationContact){
        this.CommunicationContact = CommunicationContact;
    }
    public String getCommunicationContact(){
        return this.CommunicationContact;
    }
    public void setPotential(String Potential){
        this.Potential = Potential;
    }
    public String getPotential(){
        return this.Potential;
    }
    public void setBusinessUnit(String BusinessUnit){
        this.BusinessUnit = BusinessUnit;
    }
    public String getBusinessUnit(){
        return this.BusinessUnit;
    }
    public void setClassification(String Classification){
        this.Classification = Classification;
    }
    public String getClassification(){
        return this.Classification;
    }
    public void setCurrencyName(String CurrencyName){
        this.CurrencyName = CurrencyName;
    }
    public String getCurrencyName(){
        return this.CurrencyName;
    }
    public void setCurrencyCode(int CurrencyCode){
        this.CurrencyCode = CurrencyCode;
    }
    public int getCurrencyCode(){
        return this.CurrencyCode;
    }
    public void setFilePathCollection(List<FilePathCollection> FilePathCollection){
        this.FilePathCollection = FilePathCollection;
    }
    public List<FilePathCollection> getFilePathCollection(){
        return this.FilePathCollection;
    }
    public void setTaskID(String TaskID){
        this.TaskID = TaskID;
    }
    public String getTaskID(){
        return this.TaskID;
    }
    public void setIdentifier(String Identifier){
        this.Identifier = Identifier;
    }
    public String getIdentifier(){
        return this.Identifier;
    }
    public void setRiskProfileAsOnDate(String RiskProfileAsOnDate){
        this.RiskProfileAsOnDate = RiskProfileAsOnDate;
    }
    public String getRiskProfileAsOnDate(){
        return this.RiskProfileAsOnDate;
    }
    public void setFamilyHead(boolean FamilyHead){
        this.FamilyHead = FamilyHead;
    }
    public boolean getFamilyHead(){
        return this.FamilyHead;
    }
    public void setClientId(String ClientId){
        this.ClientId = ClientId;
    }
    public String getClientId(){
        return this.ClientId;
    }
    public void setFamilyCode(String FamilyCode){
        this.FamilyCode = FamilyCode;
    }
    public String getFamilyCode(){
        return this.FamilyCode;
    }
    public void setCategoryDate(String CategoryDate){
        this.CategoryDate = CategoryDate;
    }
    public String getCategoryDate(){
        return this.CategoryDate;
    }
    public void setRiskProfileDate(String RiskProfileDate){
        this.RiskProfileDate = RiskProfileDate;
    }
    public String getRiskProfileDate(){
        return this.RiskProfileDate;
    }
    public void setInfinityId(String InfinityId){
        this.InfinityId = InfinityId;
    }
    public String getInfinityId(){
        return this.InfinityId;
    }
    public void setCity(String City){
        this.City = City;
    }
    public String getCity(){
        return this.City;
    }
    public void setIsRiskProfileExpired(String IsRiskProfileExpired){
        this.IsRiskProfileExpired = IsRiskProfileExpired;
    }
    public String getIsRiskProfileExpired(){
        return this.IsRiskProfileExpired;
    }
    public void setKYCFlag(String KYCFlag){
        this.KYCFlag = KYCFlag;
    }
    public String getKYCFlag(){
        return this.KYCFlag;
    }
}
