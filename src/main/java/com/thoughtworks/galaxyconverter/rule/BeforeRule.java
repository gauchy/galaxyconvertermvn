package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.grammar.Type;

public class BeforeRule implements Rule {
	
	
	@Override
	public void isValid(Token token) throws RuleException {
		
		//if the prev  and prev to prev element is smaller then invalidate
		int currentOrder = token.getType().getOrder();
		int beforeOrder = Integer.MAX_VALUE;
		int count = 2;
		
		while(token.hasPrevious())
		{
			beforeOrder = token.prev.getType().getOrder();
			if(beforeOrder < currentOrder)
			{
				count --;
				
			}
			token = token.prev;

			
		}
		if(count == 0 )
			throw new RuleException("Before Rule broken");

		
		
		
	}

}
