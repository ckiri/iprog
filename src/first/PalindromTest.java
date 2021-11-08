/**
*
* @author Dennis Deifel, Denis Maric, Dominik Agres, Chris Kiriakou
* @version 1, 11.10.2021
**/

package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromTest {
	
	public static String invert (String h) {
		return h.length() <= 1 ? h :
			invert (h.substring(1)) + h.substring(0,1);
	}

	public static void main(String[] args) throws IOException  {
		InputStreamReader isr;
		BufferedReader keyboard;
		String inputLine;
		isr = new InputStreamReader(System.in);
		keyboard = new BufferedReader(isr);
		
		System.out.println("Geben Sie ein Text ein: ");
		inputLine = keyboard.readLine();
		
		
		String word = inputLine;
		String invertedWord = (invert (word));
		
		
		if(word.toLowerCase().equals(invertedWord.toLowerCase())) {
			System.out.println("Dieser Text ist ein Palindrom: " + invertedWord);
		} 
		else {
			System.out.println("Dieser Text ist kein Palindrom");
			
		}
			
		
	}

}
