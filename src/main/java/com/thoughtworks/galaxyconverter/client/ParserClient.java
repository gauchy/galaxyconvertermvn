package com.thoughtworks.galaxyconverter.client;

import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.helper.ParserHelper;
import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.state.DefaultTokenBuilder;
import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.state.TokenBuilder;

/**
 * Created by ashwini on 21/06/14.
 * Test client for checking parsing of roman values
 */
public class ParserClient{
    public static void main(String[] args) throws Exception {
        InitialiseHelper.intialise();

        String [] toks = new String[]{"C","C","C"};
        ParserHelper.parse(toks);
        System.out.println("Done");

    }
}
