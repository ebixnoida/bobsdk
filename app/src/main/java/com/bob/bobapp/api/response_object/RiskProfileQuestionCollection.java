package com.bob.bobapp.api.response_object;

import java.util.ArrayList;

public class RiskProfileQuestionCollection
{
    private String QuestionCode;

    private ArrayList<AnswerCollection>AnswerCollection;

    private String QuestionDescription;

    public ArrayList<AnswerCollection> getAnswerCollection() {
        return AnswerCollection;
    }

    public void setAnswerCollection(ArrayList<AnswerCollection> answerCollection) {
        AnswerCollection = answerCollection;
    }

    public String getQuestionCode ()
    {
        return QuestionCode;
    }

    public void setQuestionCode (String QuestionCode)
    {
        this.QuestionCode = QuestionCode;
    }




    public String getQuestionDescription ()
    {
        return QuestionDescription;
    }

    public void setQuestionDescription (String QuestionDescription)
    {
        this.QuestionDescription = QuestionDescription;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [QuestionCode = "+QuestionCode+", AnswerCollection = "+AnswerCollection+", QuestionDescription = "+QuestionDescription+"]";
    }
}
			
			