package com.thoughtworks.galaxyconverter.rule;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.thoughtworks.galaxyconverter.grammar.Grammar;
import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.grammar.Type;
import com.thoughtworks.galaxyconverter.state.Token;

public class SpecialBeforeRuleTest {
	@Test
	public void test() throws Exception {
		InitialiseHelper.intialise();
		Grammar gm = InitialiseHelper.getGrammar();

		Token start = new Token();
		
		Token tok = new Token();
		start.next = tok;
		tok.prev = start;
		
		Token tok2 = new Token();
		tok2.prev = tok;
		tok.next = tok2;
		Rule rule = new SpecialBeforeRule(gm.getType("I"));
		testNegative(gm,start,rule);
		testPositive(gm,start,rule);
		rule = new SpecialBeforeRule(gm.getType("X"));
		testNegative2(gm,start,rule);
		testPositive2(gm,start,rule);
		rule = new SpecialBeforeRule(gm.getType("C"));
		testNegative3(gm,start,rule);
		testPositive3(gm,start,rule);
		
	}
	
	private void testPositive3(Grammar gm, Token start, Rule rule) {
		// TODO Auto-generated method stub
		
	}

	private void testNegative3(Grammar gm, Token start, Rule rule) {
		// TODO Auto-generated method stub
		
	}

	private void testPositive2(Grammar gm, Token start, Rule rule) {
		// TODO Auto-generated method stub
		
	}

	private void testNegative2(Grammar gm, Token start, Rule rule) {
		// TODO Auto-generated method stub
		
	}

	private void testPositive(Grammar gm, Token start, Rule rule) throws Exception 
	{
		//XIX should pass
		start.setType(gm.getType("X"));
		start.next.setType(gm.getType("I"));
		start.next.next.setType(gm.getType("X"));
		try
		{
			rule.isValid(start.next.next);
			
			
		}
		catch(RuleException e)
		{
			fail("Rule broken!!");	
		}
	}

	private void testNegative(Grammar gm, Token start, Rule rule) throws Exception {
		
		//IIX should fail
		start.setType(gm.getType("I"));
		start.next.setType(gm.getType("V"));
		start.next.next.setType(gm.getType("X"));
		try
		{
			rule.isValid(start.next.next);
			fail("Rule not broken!!");
			
		}
		catch(RuleException e)
		{
			
		}
	}


}
