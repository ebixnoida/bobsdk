package com.bob.bobapp.api.bean;

public class FamilyMemberCollection {

    private String FamilyMemberCode;

    private String FamilyMemberName;

    private String Gender;

    private String date_of_birth;

    public void setFamilyMemberCode(String FamilyMemberCode){
        this.FamilyMemberCode = FamilyMemberCode;
    }
    public String getFamilyMemberCode(){
        return this.FamilyMemberCode;
    }
    public void setFamilyMemberName(String FamilyMemberName){
        this.FamilyMemberName = FamilyMemberName;
    }
    public String getFamilyMemberName(){
        return this.FamilyMemberName;
    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }
    public String getGender(){
        return this.Gender;
    }
    public void setDate_of_birth(String date_of_birth){
        this.date_of_birth = date_of_birth;
    }
    public String getDate_of_birth(){
        return this.date_of_birth;
    }
}
