package com.thoughtworks.galaxyconverter.grammar;

/**
 * Created by ashwini on 19/06/14.
 */
public class Type
{
    float value ;
    protected String name;
    protected int order;

    public String getName()
    {
        return name;
    }

    public int getOrder()
    {
        return order;
    }
    public Type(String name , Integer order)
    {
        this.name = name;
        this.order = order;
    }

    public float getValue()
    {
        return value;
    }
    public void setValue(float value)
    {
    	this.value = value;
    	
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Type)
           return this.name.equals(((Type)obj).name);
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
