package com.thoughtworks.galaxyconverter.parser;

import java.util.List;

import com.thoughtworks.galaxyconverter.rule.Rule;
import com.thoughtworks.galaxyconverter.rule.RuleException;
import com.thoughtworks.galaxyconverter.evaluate.Evaluator;
import com.thoughtworks.galaxyconverter.grammar.Type;
import com.thoughtworks.galaxyconverter.state.Token;

public class TypeParser implements Parser {

    List<Rule> rules;
    List<Evaluator> evaluators;
	
	public TypeParser( List<Rule> rules , List<Evaluator> evaluators)
	{
	    this.rules = rules;
	    this.evaluators = evaluators;
	}
	
	@Override
	public boolean validate(Token token) throws RuleException
	{
        for(Rule rule : rules)
        {
            rule.isValid(token);
        }
        return true;
	}

	@Override
	public Float evaluate(Token token) 
	{
		Float result = 0F;
		for(Evaluator evaluator : evaluators)
		{
			result += evaluator.evaluate(token);
		}
		return result;
	}

	

}
