package com.bob.bobapp.api.bean;

import com.bob.bobapp.api.response_object.RiskProfileQuestionCollection;

import java.util.ArrayList;

public class RiskProfileQuestionnaireBean {

    private String QuestionSetCode;

    private ArrayList<com.bob.bobapp.api.response_object.RiskProfileQuestionCollection> RiskProfileQuestionCollection;

    public String getQuestionSetCode() {
        return QuestionSetCode;
    }

    public void setQuestionSetCode(String questionSetCode) {
        QuestionSetCode = questionSetCode;
    }

    public ArrayList<com.bob.bobapp.api.response_object.RiskProfileQuestionCollection> getRiskProfileQuestionCollection() {
        return RiskProfileQuestionCollection;
    }

    public void setRiskProfileQuestionCollection(ArrayList<com.bob.bobapp.api.response_object.RiskProfileQuestionCollection> riskProfileQuestionCollection) {
        RiskProfileQuestionCollection = riskProfileQuestionCollection;
    }
}
