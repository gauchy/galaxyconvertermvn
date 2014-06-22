package com.thoughtworks.galaxyconverter.parser;

import com.thoughtworks.galaxyconverter.rule.RuleException;
import com.thoughtworks.galaxyconverter.state.Token;

/**
 * Created by ashwini on 19/06/14.
 */
public interface Parser {
	boolean validate(Token token) throws RuleException;
	Float evaluate(Token token);

}
