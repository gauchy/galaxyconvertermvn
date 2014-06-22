package com.thoughtworks.galaxyconverter.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;

import com.thoughtworks.galaxyconverter.grammar.InitialiseHelper;
import com.thoughtworks.galaxyconverter.helper.RomanGalacticHelper;

public class Client {
	
	public static void main(String args[]) throws IOException
	{
		initialise();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	BufferedReader br = Files.newBufferedReader(new File("Inputs").toPath(), Charset.defaultCharset());
		
		
		String input ;
		while(!(input = br.readLine()).equals("exit"))
		//while((input = br.readLine() )!= null)
		{
			String[] inputs = input.split("=");
			inputs = trimSpaces(inputs);
			if(inputs.length ==2)
			{
				processMapping(inputs);
			}
			else if(inputs.length ==3)
			{
				processItemValue(inputs);
			}
			else
			{
				System.out.println("Invalid input");
			}
		}
		
	}
	//Trim the extra spaces in input
	private static String[] trimSpaces(String[] inputs) 
	{
		String[] trimmed = new String[inputs.length];
		for(int i=0;i < inputs.length ; i++ )
		{
			trimmed[i] = inputs[i].trim();
		}
		return trimmed;
	}

	private static void initialise() {
		InitialiseHelper.intialise();
		printWelcomeMessage();
		
	}

	private static void printWelcomeMessage()
	{
		System.out.println("Welcome to Galactic converter\n\n");
		System.out.println("Please follow these format");
		System.out.println("Input:To give mapping like 'glob is I' enter glob=I" );
		System.out.println("Question:To get value of a galactic number like 'how much is pish tegj glob glob' enter 'pish tegj glob glob=?' ");
		
		System.out.println("Input:To give item value input like 'glob glob Silver is 34 Credits' enter 'glob glob=Silver=34'");
		System.out.println("Question:To get value of an itme like 'how many Credits is glob prok Silver' enter 'glob prok=Silver=?'");
		System.out.println("Exit:exit");
		System.out.println();		
	}

	private static void processItemValue(String[] inputs) 
	{
		try
		{
			if(inputs[2].equals("?"))
			{
				float value = RomanGalacticHelper.getRomanValue(inputs[0]);
				float itemValue = RomanGalacticHelper.getItemValue(inputs[1]);
				System.out.println(inputs[0] + " = " + inputs[1] +" = " + itemValue*value);
			}
			else
			{
				float value = RomanGalacticHelper.getRomanValue(inputs[0]);
				float totalValue = Integer.parseInt(inputs[2]);
				RomanGalacticHelper.addItem(inputs[1], totalValue/value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception occured , please try again");
		}		
	}

	private static void processMapping(String[] inputs)
	{
		try
		{
			if(inputs[1].equals("?"))
			{
				float value = RomanGalacticHelper.getRomanValue(inputs[0]);
				System.out.println(inputs[0]+ " = " + value);
			}
			else
				RomanGalacticHelper.addMapping(inputs[0], inputs[1]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception occured , please try again");
		}
		
	}

}
