package com.thoughtworks.galaxyconverter.state;

import com.thoughtworks.galaxyconverter.evaluate.Evaluator;
import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.grammar.Type;

/**
 * Created by ashwini on 19/06/14.
 */
public  class Token {

    public Token next;
    public Token prev;
    private Parser parser;
    private Evaluator evaluator;
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public boolean hasNext()
    {
        return next != null;
    }

    public boolean hasPrevious()
    {
        return prev !=null;
    }



}
