package com.thoughtworks.galaxyconverter.evaluate;

import com.thoughtworks.galaxyconverter.state.Token;

public interface Evaluator {
	//evaluate token
	Float evaluate(Token token);

}
