package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class CallClientCreationActivationRequestBody {
    @SerializedName("ConstitutionCode")
    private String ConstitutionCode;

    @SerializedName("CustStatus")
    private String CustStatus;

    @SerializedName("ClientStatus")
    private String ClientStatus;

    @SerializedName("ClientTaxId")
    private String ClientTaxId;

    @SerializedName("DateofIncorporation")
    private String DateofIncorporation;

    @SerializedName("IsNRE")
    private String IsNRE;

    @SerializedName("PAN")
    private String PAN;

    @SerializedName("Name")
    private String Name;

    @SerializedName("FirstName")
    private String FirstName;

    @SerializedName("MiddleName")
    private String MiddleName;

    @SerializedName("BirthDt")
    private String BirthDt;

    @SerializedName("LastName")
    private String LastName;

    @SerializedName("Gender")
    private String Gender;

    @SerializedName("DefaultAddrType")
    private String DefaultAddrType;

    @SerializedName("PassportNum")
    private String PassportNum;

    @SerializedName("MotherName")
    private String MotherName;

    @SerializedName("FatherOrHusbandName")
    private String FatherOrHusbandName;

    @SerializedName("Nationality")
    private String Nationality;


    @SerializedName("Email")
    private String Email;

    @SerializedName("MobNo")
    private String MobNo;

    @SerializedName("MAddrLine1")
    private String MAddrLine1;

    @SerializedName("MAddrLine2")
    private String MAddrLine2;

    @SerializedName("MAddrLine3")
    private String MAddrLine3;

    @SerializedName("MCity")
    private String MCity;

    @SerializedName("MState")
    private String MState;

    @SerializedName("MCountry")
    private String MCountry;

    @SerializedName("MPostalCode")
    private String MPostalCode;

    @SerializedName("UCC")
    private String UCC;

    @SerializedName("KYCVerified")
    private String KYCVerified;

    @SerializedName("KYCDescription")
    private String KYCDescription;

    @SerializedName("Title")
    private String Title;

    @SerializedName("MaritalStatus")
    private String MaritalStatus;

    @SerializedName("AddressType")
    private String AddressType;

    @SerializedName("ErrorMessage")
    private String ErrorMessage;

    @SerializedName("BirthPlace")
    private String BirthPlace;

    @SerializedName("BirthCountry")
    private String BirthCountry;

    @SerializedName("PoliticallyExposed")
    private String PoliticallyExposed;

    @SerializedName("grossannualincome")
    private String grossannualincome;

    @SerializedName("WealthSource")
    private String WealthSource;

    @SerializedName("EstimatedFinancialGrowth")
    private String EstimatedFinancialGrowth;

   @SerializedName("occupationcode")
    private String occupationcode;

   @SerializedName("occupation_code")
    private String occupation_code;

   @SerializedName("pan_no1")
    private String pan_no1;

   @SerializedName("email1")
    private String email1;

   @SerializedName("Occupation")
    private String Occupation;

   @SerializedName("Pin")
    private String Pin;

   @SerializedName("pInfinityID")
    private String pInfinityID;

   @SerializedName("isofflineclient")
    private String isofflineclient;

   @SerializedName("ClientIP")
    private String ClientIP;

   @SerializedName("IsApplyNominee")
    private String IsApplyNominee;

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

   @SerializedName("DateOfBirth2")
    private String DateOfBirth2;

   @SerializedName("NomineeShare2")
    private String NomineeShare2;

   @SerializedName("NomineeIsMinor2")
    private String NomineeIsMinor2;

    public String getConstitutionCode() {
        return ConstitutionCode;
    }

    public void setConstitutionCode(String constitutionCode) {
        ConstitutionCode = constitutionCode;
    }

    public String getCustStatus() {
        return CustStatus;
    }

    public void setCustStatus(String custStatus) {
        CustStatus = custStatus;
    }

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }

    public String getClientTaxId() {
        return ClientTaxId;
    }

    public void setClientTaxId(String clientTaxId) {
        ClientTaxId = clientTaxId;
    }

    public String getDateofIncorporation() {
        return DateofIncorporation;
    }

    public void setDateofIncorporation(String dateofIncorporation) {
        DateofIncorporation = dateofIncorporation;
    }

    public String getIsNRE() {
        return IsNRE;
    }

    public void setIsNRE(String isNRE) {
        IsNRE = isNRE;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getBirthDt() {
        return BirthDt;
    }

    public void setBirthDt(String birthDt) {
        BirthDt = birthDt;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDefaultAddrType() {
        return DefaultAddrType;
    }

    public void setDefaultAddrType(String defaultAddrType) {
        DefaultAddrType = defaultAddrType;
    }

    public String getPassportNum() {
        return PassportNum;
    }

    public void setPassportNum(String passportNum) {
        PassportNum = passportNum;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getFatherOrHusbandName() {
        return FatherOrHusbandName;
    }

    public void setFatherOrHusbandName(String fatherOrHusbandName) {
        FatherOrHusbandName = fatherOrHusbandName;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String mobNo) {
        MobNo = mobNo;
    }

    public String getMAddrLine1() {
        return MAddrLine1;
    }

    public void setMAddrLine1(String MAddrLine1) {
        this.MAddrLine1 = MAddrLine1;
    }

    public String getMAddrLine2() {
        return MAddrLine2;
    }

    public void setMAddrLine2(String MAddrLine2) {
        this.MAddrLine2 = MAddrLine2;
    }

    public String getMAddrLine3() {
        return MAddrLine3;
    }

    public void setMAddrLine3(String MAddrLine3) {
        this.MAddrLine3 = MAddrLine3;
    }

    public String getMCity() {
        return MCity;
    }

    public void setMCity(String MCity) {
        this.MCity = MCity;
    }

    public String getMState() {
        return MState;
    }

    public void setMState(String MState) {
        this.MState = MState;
    }

    public String getMCountry() {
        return MCountry;
    }

    public void setMCountry(String MCountry) {
        this.MCountry = MCountry;
    }

    public String getMPostalCode() {
        return MPostalCode;
    }

    public void setMPostalCode(String MPostalCode) {
        this.MPostalCode = MPostalCode;
    }

    public String getUCC() {
        return UCC;
    }

    public void setUCC(String UCC) {
        this.UCC = UCC;
    }

    public String getKYCVerified() {
        return KYCVerified;
    }

    public void setKYCVerified(String KYCVerified) {
        this.KYCVerified = KYCVerified;
    }

    public String getKYCDescription() {
        return KYCDescription;
    }

    public void setKYCDescription(String KYCDescription) {
        this.KYCDescription = KYCDescription;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String addressType) {
        AddressType = addressType;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getBirthPlace() {
        return BirthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        BirthPlace = birthPlace;
    }

    public String getBirthCountry() {
        return BirthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        BirthCountry = birthCountry;
    }

    public String getPoliticallyExposed() {
        return PoliticallyExposed;
    }

    public void setPoliticallyExposed(String politicallyExposed) {
        PoliticallyExposed = politicallyExposed;
    }

    public String getGrossannualincome() {
        return grossannualincome;
    }

    public void setGrossannualincome(String grossannualincome) {
        this.grossannualincome = grossannualincome;
    }

    public String getWealthSource() {
        return WealthSource;
    }

    public void setWealthSource(String wealthSource) {
        WealthSource = wealthSource;
    }

    public String getEstimatedFinancialGrowth() {
        return EstimatedFinancialGrowth;
    }

    public void setEstimatedFinancialGrowth(String estimatedFinancialGrowth) {
        EstimatedFinancialGrowth = estimatedFinancialGrowth;
    }

    public String getOccupationcode() {
        return occupationcode;
    }

    public void setOccupationcode(String occupationcode) {
        this.occupationcode = occupationcode;
    }

    public String getOccupation_code() {
        return occupation_code;
    }

    public void setOccupation_code(String occupation_code) {
        this.occupation_code = occupation_code;
    }

    public String getPan_no1() {
        return pan_no1;
    }

    public void setPan_no1(String pan_no1) {
        this.pan_no1 = pan_no1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public String getpInfinityID() {
        return pInfinityID;
    }

    public void setpInfinityID(String pInfinityID) {
        this.pInfinityID = pInfinityID;
    }

    public String getIsofflineclient() {
        return isofflineclient;
    }

    public void setIsofflineclient(String isofflineclient) {
        this.isofflineclient = isofflineclient;
    }

    public String getClientIP() {
        return ClientIP;
    }

    public void setClientIP(String clientIP) {
        ClientIP = clientIP;
    }

    public String getIsApplyNominee() {
        return IsApplyNominee;
    }

    public void setIsApplyNominee(String isApplyNominee) {
        IsApplyNominee = isApplyNominee;
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

    public String getDateOfBirth2() {
        return DateOfBirth2;
    }

    public void setDateOfBirth2(String dateOfBirth2) {
        DateOfBirth2 = dateOfBirth2;
    }

    public String getNomineeShare2() {
        return NomineeShare2;
    }

    public void setNomineeShare2(String nomineeShare2) {
        NomineeShare2 = nomineeShare2;
    }

    public String getNomineeIsMinor2() {
        return NomineeIsMinor2;
    }

    public void setNomineeIsMinor2(String nomineeIsMinor2) {
        NomineeIsMinor2 = nomineeIsMinor2;
    }

    public String getDateOfBirth3() {
        return DateOfBirth3;
    }

    public void setDateOfBirth3(String dateOfBirth3) {
        DateOfBirth3 = dateOfBirth3;
    }

    public String getNomineeShare3() {
        return NomineeShare3;
    }

    public void setNomineeShare3(String nomineeShare3) {
        NomineeShare3 = nomineeShare3;
    }

    public String getNomineeIsMinor3() {
        return NomineeIsMinor3;
    }

    public void setNomineeIsMinor3(String nomineeIsMinor3) {
        NomineeIsMinor3 = nomineeIsMinor3;
    }

    @SerializedName("DateOfBirth3")
    private String DateOfBirth3;

   @SerializedName("NomineeShare3")
    private String NomineeShare3;

   @SerializedName("NomineeIsMinor3")
    private String NomineeIsMinor3;

}
