package com.thoughtworks.galaxyconverter.grammar;

/**
 * Created by ashwini on 21/06/14.
 */
public class InitialiseHelper
{
    private static Grammar grammar;
    private static boolean initialised= false;
    public static void intialise()
    {
        if(initialised)
            return;

        grammar = new RomanStaticGrammar() ;
        grammar.buildGrammar();
        initialised = true;

    }

    public static Grammar getGrammar()
    {
        return grammar;
    }
}
