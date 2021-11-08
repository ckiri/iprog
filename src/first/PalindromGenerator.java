package first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * das vom Benutzer zwei Texte einliest und daraus fünf verschiedene Palindrome macht, die jeweils beide Texte enthalten. 
 * Die so erzeugten Palindrome sollen sowohl auf den Bildschirm als auch in die Datei "palindrom.txt" geschrieben werden.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 11.10.2021
 */

public class PalindromGenerator
{
    public static String invert (String x) 
	{
		return x.length() <= 1 ? x :
		invert( x.substring(1) ) + x.substring(0,1);
    }

    public static void main(String[] args) throws IOException
    {
        InputStreamReader isr;                      //Eingabe der Tastatur
        BufferedReader keyboard;
        isr = new InputStreamReader (System.in);
        keyboard = new BufferedReader (isr);

        System.out.println("Nennen Sie den Inhalt von Text 1:");
        String text1 = keyboard.readLine();
        System.out.println("Nennen Sie den Inhalt von Text 2:");
        String text2 = keyboard.readLine();

        String[] array = new String[7];
        array[0] = text1;
        array[1] = text2;

        array[2] = array[0] + array[1] + invert(array[1]) + invert(array[0]);
        array[3] = array[1] + array[0] + invert(array[0]) + invert(array[1]);
        array[4] = invert(array[0]) + invert(array[1]) + array[1] + array[0];
        array[5] = invert(array[1]) + invert(array[0]) + array[0] + array[1];
        array[6] = invert(array[0]) + array[1] + invert(array[1]) + array[0];
        
        for (int i = 2; i <= 6; i++) 
        {
            System.out.println(array[i]);
        }

        File f = new File("first/palindrom.txt");
        PrintStream target = new PrintStream( new FileOutputStream(f));
        for (int i = 2; i <= 6; i++) 
        {
            target.println(array[i]);
        }

        target.close();
    }
}