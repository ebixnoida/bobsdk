package com.bob.bobapp.api.response_object;

public class Occupation
{
    private String Value;

    private String Name;

    public String getValue ()
    {
        return Value;
    }

    public void setValue (String Value)
    {
        this.Value = Value;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Value = "+Value+", Name = "+Name+"]";
    }
}
			
			