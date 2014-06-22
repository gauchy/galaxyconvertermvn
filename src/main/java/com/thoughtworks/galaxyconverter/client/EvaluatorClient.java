package com.thoughtworks.galaxyconverter.client;

import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.helper.ParserHelper;
import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.state.DefaultTokenBuilder;
import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.state.TokenBuilder;

/*
 * Test client for checking evaluation of Roman values
 */
public class EvaluatorClient {
	
	public static void main(String args[]) throws Exception
	{
		
		InitialiseHelper.intialise();

        String [] toks = new String[]{"C","C","I","X"};
        float val = ParserHelper.evaluate(toks);
        System.out.println(val);
        System.out.println("Done");
	}

}
