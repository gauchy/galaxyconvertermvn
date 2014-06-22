package com.thoughtworks.galaxyconverter.helper;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.galaxyconverter.state.RomanTokenConstant;

public class RomanGalacticHelper {
	
	private static Map<String,String> galacticVSRomanMap = new HashMap<String,String>();
	private static Map<String ,Float> valueStore = new HashMap<String , Float>();

	public static void addItem(String item, Float value)
	{

		valueStore.put(item, value);
	}

	public static Float getItemValue(String item) throws Exception
	{
		Float value = valueStore.get(item);
		if(value == null)
			throw new Exception(item + " not present in store");
		return value;
	}
	public static void addMapping(String galactic , String roman) throws Exception
	{
		//validate if the token provided is roman or not
		switch (roman) {
			case RomanTokenConstant.I:
				break;
			case RomanTokenConstant.X:
				break;
			case RomanTokenConstant.V:
				break;
			case RomanTokenConstant.L:
				break;
			case RomanTokenConstant.C:
				break;
			case RomanTokenConstant.D:
				break;
			case RomanTokenConstant.M:
				break;
	
			default:
				throw new Exception("Invalid Roman Type");
		}
		
		galacticVSRomanMap.put(galactic, roman);
	}
	private static String getMapping(String galactic) throws Exception
	{
		String roman = galacticVSRomanMap.get(galactic);
		if(roman == null)
			throw new Exception("No roman mapping for " + galactic);
		
		return roman;
	}
	
	public static Float getRomanValue(String galacticInput) throws Exception
	{
		String[] galacticArgs = galacticInput.split(" ");
		
		//get roman tokens
		String[] romanArgs = getMappings(galacticArgs);
		
		//parse and evaluate
		return ParserHelper.parseEvaluate(romanArgs);
		
		
		
	}

	private static String[] getMappings(String[] galacticArgs) throws Exception
	{
		String[] romans = new String[galacticArgs.length];
		for(int i = 0 ; i < galacticArgs.length ; i++)
		{
			romans[i] = getMapping(galacticArgs[i]);
		}
		return romans;
	}
	
	
	
	
	
	

}
