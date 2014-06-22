package com.thoughtworks.galaxyconverter.state;


import com.thoughtworks.galaxyconverter.grammar.Grammar;
import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.grammar.Type;

/**
 * Created by ashwini on 19/06/14.
 */
public class DefaultTokenBuilder implements TokenBuilder {

    String[] args;
    public DefaultTokenBuilder(String[] args)
    {
        this.args = args;
    }
    @Override
    public Token buildTokens() throws Exception {
        Grammar grammar = InitialiseHelper.getGrammar();
        Token start = null;
        Token prev = null;
        Token current =null;

        for(String arg : args)
        {

            Type type = grammar.getType(arg);
            current = new Token();
            current.setType(type);
            current.setParser(grammar.getParser(type));

            if(start == null)
                start = current;
            else
            {
                prev.next = current;
                current.prev = prev;

            }
            prev = current;


        }

        return start;
    }
    
    
    
}
