package com.thoughtworks.galaxyconverter.evaluate;

import com.thoughtworks.galaxyconverter.state.Token;


public class DefaultEvaluator implements Evaluator {

	@Override
	public Float evaluate(Token token)
	{
		return token.getType().getValue();
	}

}
