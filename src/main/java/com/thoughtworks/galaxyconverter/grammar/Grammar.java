package com.thoughtworks.galaxyconverter.grammar;

import com.thoughtworks.galaxyconverter.evaluate.Evaluator;
import com.thoughtworks.galaxyconverter.parser.Parser;

public interface Grammar {
	
	void buildGrammar();
	Parser getParser(Type type);
    Parser getParser(String name);
    Evaluator[] getEvaluators(String name);
    Evaluator[] getEvaluators(Type type);
    Type getType(String name) throws Exception;

}
