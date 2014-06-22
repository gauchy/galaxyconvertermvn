package com.thoughtworks.galaxyconverter.rule;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.galaxyconverter.grammar.Grammar;
import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.state.Token;

public class RepeatTest {

	@Test
	public void test() throws Exception {
		InitialiseHelper.intialise();
		Grammar gm = InitialiseHelper.getGrammar();
		Rule rule = new RepeatitionRule(1);
		Token start = new Token();
		
		Token tok = new Token();
		start.next = tok;
		tok.prev = start;
		
		Token tok2 = new Token();
		tok2.prev = tok;
		tok.next = tok2;
		testNegative(gm,start,rule);
		testPositive(gm,start,rule);
		
	}
	
	private void testPositive(Grammar gm, Token start, Rule rule) throws Exception 
	{
		//XIX should pass
		start.setType(gm.getType("X"));
		start.next.setType(gm.getType("I"));
		start.next.next.setType(gm.getType("X"));
		try
		{
			rule.isValid(start.next);
			
			
		}
		catch(RuleException e)
		{
			fail("Rule broken!!");	
		}
	}

	private void testNegative(Grammar gm, Token start, Rule rule) throws Exception {
		
		//IIX should fail
		start.setType(gm.getType("I"));
		start.next.setType(gm.getType("I"));
		start.next.next.setType(gm.getType("X"));
		try
		{
			rule.isValid(start.next);
			fail("Rule not broken!!");
			
		}
		catch(RuleException e)
		{
			
		}
	}

}
