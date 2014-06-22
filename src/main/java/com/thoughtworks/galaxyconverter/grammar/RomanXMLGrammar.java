package com.thoughtworks.galaxyconverter.grammar;

import com.thoughtworks.galaxyconverter.evaluate.Evaluator;
import com.thoughtworks.galaxyconverter.parser.Parser;

public class RomanXMLGrammar implements Grammar {

	
	private String xmlFileName;

	RomanXMLGrammar(String xmlFileName)
	{
		
		this.xmlFileName = xmlFileName;
	}
	@Override
	public void buildGrammar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Parser getParser(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Parser getParser(String name) {
        return null;
    }

    @Override
    public Evaluator[] getEvaluators(String name) {
        return new Evaluator[0];
    }

    @Override
    public Evaluator[] getEvaluators(Type type) {
        return new Evaluator[0];
    }

    @Override
    public Type getType(String name) {
        return null;
    }

}
