package com.thoughtworks.galaxyconverter.rule;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.galaxyconverter.grammar.Grammar;
import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.state.Token;

public class SpecialRepeatitionRuleTest {

	@Test
	public void test() throws Exception {
		InitialiseHelper.intialise();
		Grammar gm = InitialiseHelper.getGrammar();
		Rule rule = new SpecialRepeatitionRule();
		Token start = new Token();
		
		Token tok = new Token();
		start.next = tok;
		tok.prev = start;
		
		Token tok2 = new Token();
		tok2.prev = tok;
		tok.next = tok2;
		
		Token tok3 = new Token();
		tok3.prev = tok2;
		tok2.next = tok3;
		
		Token tok4= new Token();
		tok4.prev = tok3;
		tok3.next = tok4;

		testNegative(gm,start,rule);
		testPositive(gm,start,rule);
	}
	private void testPositive(Grammar gm, Token start, Rule rule) throws Exception 
	{
		//XXIX should pass
		start.setType(gm.getType("X"));
		start.next.setType(gm.getType("X"));
		start.next.next.setType(gm.getType("X"));
		start.next.next.next.setType(gm.getType("I"));
		start.next.next.next.next.setType(gm.getType("X"));
		try
		{
			rule.isValid(start.next.next.next.next);
			
			
		}
		catch(RuleException e)
		{
			fail("Rule broken!!");	
		}
	}

	private void testNegative(Grammar gm, Token start, Rule rule) throws Exception {
		
		//XIXX should pass
		start.setType(gm.getType("X"));
		start.next.setType(gm.getType("I"));
		start.next.next.setType(gm.getType("X"));
		start.next.next.next.setType(gm.getType("X"));
		start.next.next.next.next.setType(gm.getType("X"));
		try
		{
			rule.isValid(start.next.next.next.next);
			fail("Rule not broken!!");
			
		}
		catch(RuleException e)
		{
			
		}
	}
}
