package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * eine beliebige Textzeile einliest und dann ausgibt, ob dieser Text ein Palindrom ist oder nicht 
 * (unter Vernachlässigung der Groß-Kleinschreibung)
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 11.10.2021
 */

public class PalindromTest 
{
    public static String invert (String x) 
	{
		return x.length() <= 1 ? x :
		invert( x.substring(1) ) + x.substring(0,1);
    }

	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr;
		BufferedReader keyboard;
		String inputLine;
		isr = new InputStreamReader(System.in);
		keyboard = new BufferedReader(isr);
		
		System.out.println("Geben Sie ein Text ein: ");
		inputLine = keyboard.readLine();
		
		String invertedWord = ( invert(inputLine) );
        
		if( inputLine.toLowerCase().equals( invertedWord.toLowerCase() ) ) 
		{
			System.out.println("Dieser Text ist ein Palindrom: " + invertedWord);
		} 
		else 
		{ 
			System.out.println("Dieser Text ist kein Palindrom: " + invertedWord);	
		}
	}
}