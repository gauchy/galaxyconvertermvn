package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.grammar.Type;

/**
 * Created by ashwini on 20/06/14.
 */
public class RepeatitionRule implements Rule {

    int repeatCount;
    public RepeatitionRule(int repeatCount)
    {
        this.repeatCount = repeatCount;
    }

    @Override
    public void isValid(Token token) throws RuleException
    {
        int count =1;
        while(token.hasPrevious())
        {

             if(token.getType().equals(token.prev.getType()))
                 count++;
             
             token = token.prev;

        }
        //if count is less or equal to allowed repeat count then return valid
        if( count > repeatCount)
        	throw new RuleException("Repetition rule broken");
    }


}
