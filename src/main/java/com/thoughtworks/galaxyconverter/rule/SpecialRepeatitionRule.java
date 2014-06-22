package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.grammar.Type;

/**
 * Created by ashwini on 20/06/14.
 */
public class SpecialRepeatitionRule implements Rule {


    public SpecialRepeatitionRule()
    {

    }
    @Override
    public void isValid(Token token) throws RuleException {

    	//TODO - Refractor
        Type currentType = token.getType();
    	
        int repeatCount  = 5;
        
        int count =repeatCount;
        
        
        Type[] elements = new Type[repeatCount];
        elements[count-1] = currentType;
        count--;

        //fill the last  elements in array
        while(token.hasPrevious())
        {
            
            elements[count-1] = token.prev.getType();
           
            count--;
            token = token.prev;
            
            
            if(count ==0)
            	break;
        }
        
        if(count != 0)
        	return;
        //if occurance is not 4 its valid else check 4th element in the array is different
        if(elements[repeatCount-2].equals(currentType))
        	throw new RuleException("Special Repeatition rule broken");

        
        
        
        
        
    }
}
