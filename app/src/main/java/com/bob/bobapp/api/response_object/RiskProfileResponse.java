package com.bob.bobapp.api.response_object;

import java.util.ArrayList;

public class RiskProfileResponse {

    private ArrayList<RiskProfileQuestionCollection>RiskProfileQuestionCollection;

    private String QuestionSetCode;

    public ArrayList<RiskProfileQuestionCollection> getRiskProfileQuestionCollection() {
        return RiskProfileQuestionCollection;
    }

    public void setRiskProfileQuestionCollection(ArrayList<RiskProfileQuestionCollection> riskProfileQuestionCollection) {
        RiskProfileQuestionCollection = riskProfileQuestionCollection;
    }

    public String getQuestionSetCode ()
    {
        return QuestionSetCode;
    }

    public void setQuestionSetCode (String QuestionSetCode)
    {
        this.QuestionSetCode = QuestionSetCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RiskProfileQuestionCollection = "+RiskProfileQuestionCollection+", QuestionSetCode = "+QuestionSetCode+"]";
    }
}
