package first;

/**
 * Das erst einen beliebigen (selbstgewählten, längeren) Text a, dann einen ebensolchen Text b ausgibt und anschließend 
 * den Text ausgibt, der dadurch entsteht, dass die Zeichen von a und b nach dem Reißverschluss-Prinzip zusammen gefügt werden.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 04.10.2021
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zip 
{
    public static String zipText(String textA, String textB)
    {
        return textA.length() <= 1 || textB.length() <= 1 ? letzterText(textA, textB) : 
            textA.substring(0, 1) + textB.substring(0, 1) + zipText(textA.substring(1), textB.substring(1));
    }

    public static String letzterText(String textA, String textB)
    {
        return textA.length() < textB.length() ? textA + textB :
            textA.substring(0, 1) + textB + textA.substring(1);
    }

    public static void main(String[] args) throws IOException 
    {
        InputStreamReader isr;
		BufferedReader keyboard;
		isr = new InputStreamReader(System.in);
		keyboard = new BufferedReader(isr);

        String inputLineA;
        System.out.println("Geben Sie ein Text A ein: ");
		inputLineA = keyboard.readLine();

        String inputLineB;
        System.out.println("Geben Sie ein Text B ein: ");
		inputLineB = keyboard.readLine();

        System.out.println( zipText(inputLineA, inputLineB) );
    }
}