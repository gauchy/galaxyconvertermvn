package com.thoughtworks.galaxyconverter.helper;

import com.thoughtworks.galaxyconverter.parser.Parser;
import com.thoughtworks.galaxyconverter.state.DefaultTokenBuilder;
import com.thoughtworks.galaxyconverter.state.Token;
import com.thoughtworks.galaxyconverter.state.TokenBuilder;

public class ParserHelper {
	
	/**
	 * Helper method to parse the  input tokens
	 * @param toks
	 * @throws Exception
	 */
	public static void parse(String[] toks) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		try
		{
	        TokenBuilder tokenBuilder = new DefaultTokenBuilder(toks);
	        Token start = tokenBuilder.buildTokens();

	        Token current = start;
	        
	        while(true)
	        {
	            sb.append(current.getType().getName());
	            Parser parser = current.getParser();
	
	            parser.validate(current);
	            
	            if(!current.hasNext())
	                break;
	
	            current = current.next;
	        }
		}
		catch(Exception e)
		{
			System.out.println("Following exception occured at " + sb);
			throw e;
		}
		
	}
	/**
	 * Helper method , evaluates tokens without parsing
	 * @param toks
	 * @return
	 * @throws Exception
	 */
	public static Float evaluate(String[] toks) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		float val = 0;
		try
		{
	        TokenBuilder tokenBuilder = new DefaultTokenBuilder(toks);
	        Token start = tokenBuilder.buildTokens();

	        Token current = start;
	        
	        while(true)
	        {
	            sb.append(current.getType().getName());
	            Parser parser = current.getParser();
	
	            val += parser.evaluate(current);
	            if(!current.hasNext())
	                break;
	
	            current = current.next;
	        }
		}
		catch(Exception e)
		{
			System.out.println("Following exception occured at " + sb);
			throw e;
		}
		return val;
	}
	/**
	 * Helper method to parse and evaluate tokens
	 * @param toks
	 * @return
	 * @throws Exception
	 */
	public static float parseEvaluate(String[] toks) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		float val = 0;
		try
		{
	        TokenBuilder tokenBuilder = new DefaultTokenBuilder(toks);
	        Token start = tokenBuilder.buildTokens();

	        Token current = start;
	        
	        while(true)
	        {
	            sb.append(current.getType().getName());
	            Parser parser = current.getParser();
	            
	            parser.validate(current);
	            val += parser.evaluate(current);
	            
	            if(!current.hasNext())
	                break;
	
	            current = current.next;
	        }
		}
		catch(Exception e)
		{
			System.out.println("Following exception occured at " + sb);
			throw e;
		}
		return val;
	}

}
