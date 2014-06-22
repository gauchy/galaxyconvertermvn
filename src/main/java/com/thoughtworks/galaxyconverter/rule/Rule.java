package com.thoughtworks.galaxyconverter.rule;

import com.thoughtworks.galaxyconverter.state.Token;

/**
 * Created by ashwini on 19/06/14.
 */
public interface Rule {

    void isValid(Token token) throws RuleException;
}
