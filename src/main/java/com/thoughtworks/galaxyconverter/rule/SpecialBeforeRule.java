package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.grammar.Type;

public class SpecialBeforeRule implements Rule {

	Type validBefores ;
	
	public SpecialBeforeRule(Type validBefores)
	{
		this.validBefores = validBefores;
	}
	@Override
	public void isValid(Token token) throws RuleException
	{
		if(token.hasPrevious())
		{
			Type beforeType = token.prev.getType();
			if(beforeType.getOrder() < token.getType().getOrder())
			{
				if(!beforeType.equals(validBefores))
					throw new RuleException("Special Before Rule broken");
				
			}
		}
			
	}
}
