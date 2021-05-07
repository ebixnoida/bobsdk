package com.bob.bobapp.api.response_object;

public class RiskProfileSubmitResponse {

    private String ClientCode;

    private String ProfileWriteUp;

    private String ProfileName;

    private String ProfileScore;

    private String ProfileExpiryDate;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getProfileWriteUp() {
        return ProfileWriteUp;
    }

    public void setProfileWriteUp(String profileWriteUp) {
        ProfileWriteUp = profileWriteUp;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String profileName) {
        ProfileName = profileName;
    }

    public String getProfileScore() {
        return ProfileScore;
    }

    public void setProfileScore(String profileScore) {
        ProfileScore = profileScore;
    }

    public String getProfileExpiryDate() {
        return ProfileExpiryDate;
    }

    public void setProfileExpiryDate(String profileExpiryDate) {
        ProfileExpiryDate = profileExpiryDate;
    }
}
