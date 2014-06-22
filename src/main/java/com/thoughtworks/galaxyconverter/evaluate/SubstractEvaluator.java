package com.thoughtworks.galaxyconverter.evaluate;

import com.thoughtworks.galaxyconverter.state.Token;

/**
 * Created by ashwini on 21/06/14.
 */
public class SubstractEvaluator implements Evaluator {

    @Override
    /**
     * Substracts value if the preceeding token is smaller
     */
    public Float evaluate(Token token)
    {
    	if(token.hasPrevious())
    	{
    		Token previous = token.prev;
    		if(previous.getType().getOrder() < token.getType().getOrder())
    			return -2 * previous.getType().getValue();
    	}
        return 0F;
    }
}
