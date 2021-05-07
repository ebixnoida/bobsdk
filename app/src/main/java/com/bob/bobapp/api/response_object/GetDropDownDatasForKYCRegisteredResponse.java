package com.bob.bobapp.api.response_object;

import java.util.ArrayList;

public class GetDropDownDatasForKYCRegisteredResponse {
    private ArrayList<Occupation>Occupation;


    private ArrayList<MaritalStatus>MaritalStatus;

    public ArrayList<Occupation> getOccupation() {
        return Occupation;
    }

    public void setOccupation(ArrayList<Occupation> occupation) {
        Occupation = occupation;
    }



    private ArrayList<SourceOFWealth>SourceOFWealth;

    public ArrayList<MaritalStatus> getMaritalStatus() {
        return MaritalStatus;
    }

    public ArrayList<SourceOFWealth> getSourceOFWealth() {
        return SourceOFWealth;
    }

    public void setSourceOFWealth(ArrayList<SourceOFWealth> sourceOFWealth) {
        SourceOFWealth = sourceOFWealth;
    }

    public void setMaritalStatus(ArrayList<MaritalStatus> maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    private ArrayList<PoliticalFigure>PoliticalFigure;

    public ArrayList<PoliticalFigure> getPoliticalFigure() {
        return PoliticalFigure;
    }

    public void setPoliticalFigure(ArrayList<PoliticalFigure> politicalFigure) {
        PoliticalFigure = politicalFigure;
    }

    private ArrayList<State>State;

    public ArrayList<State> getState() {
        return State;
    }

    public void setState(ArrayList<State> state) {
        State = state;
    }


    private ArrayList<Country>Country;

    public ArrayList<Country> getCountry() {
        return Country;
    }

    public void setCountry(ArrayList<Country> country) {
        Country = country;
    }

    private Title[] Title;

    private ArrayList<Gender>Gender;


    private ArrayList<City>City;

    public ArrayList<City> getCity() {
        return City;
    }

    public void setCity(ArrayList<City> city) {
        City = city;
    }


    public ArrayList<AddressType> getAddressType() {
        return AddressType;
    }

    public void setAddressType(ArrayList<AddressType> addressType) {
        AddressType = addressType;
    }

    private ArrayList<AddressType>AddressType;



    private ArrayList<GrossAnnIncome>GrossAnnIncome;

    public ArrayList<GrossAnnIncome> getGrossAnnIncome() {
        return GrossAnnIncome;
    }

    public void setGrossAnnIncome(ArrayList<GrossAnnIncome> grossAnnIncome) {
        GrossAnnIncome = grossAnnIncome;
    }

    public Title[] getTitle ()
    {
        return Title;
    }

    public ArrayList<Gender> getGender() {
        return Gender;
    }

    public void setGender(ArrayList<Gender> gender) {
        Gender = gender;
    }

    public void setTitle (Title[] Title)
    {
        this.Title = Title;
    }




    @Override
    public String toString()
    {
        return "ClassPojo [Occupation = "+Occupation+", MaritalStatus = "+MaritalStatus+", SourceOFWealth = "+SourceOFWealth+", PoliticalFigure = "+PoliticalFigure+", State = "+State+", Country = "+Country+", Title = "+Title+", Gender = "+Gender+", City = "+City+", AddressType = "+AddressType+", GrossAnnIncome = "+GrossAnnIncome+"]";
    }
}
