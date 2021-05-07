package com.bob.bobapp.api.response_object;

public class AnswerCollection
{
    private String AnswerCode;

    private String AnswerDescription;

    private String Selected;

    public String getAnswerCode ()
    {
        return AnswerCode;
    }

    public void setAnswerCode (String AnswerCode)
    {
        this.AnswerCode = AnswerCode;
    }

    public String getAnswerDescription ()
    {
        return AnswerDescription;
    }

    public void setAnswerDescription (String AnswerDescription)
    {
        this.AnswerDescription = AnswerDescription;
    }

    public String getSelected ()
    {
        return Selected;
    }

    public void setSelected (String Selected)
    {
        this.Selected = Selected;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [AnswerCode = "+AnswerCode+", AnswerDescription = "+AnswerDescription+", Selected = "+Selected+"]";
    }
}
			
			