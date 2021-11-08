package first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * das beliebig viele Text-Zeilen von der Tastatur einliest, solange, bis das Wort „potS“ eingegeben wird, 
 * oder das Ende der Eingabe (^Z) erreicht ist (Abfrage auch auf null). 
 * Anschließend sollen alle gelesenen Zeilen invertiert und in umgekehrter Reihenfolge auf den Bildschirm ausgegeben werden.
 * Testen Sie das Programm, indem Sie es auf sich selbst anwenden.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 08.11.2021
 */

public class EsreverLister 
{
    public static String invert (String x)
    {
        return x.length() <= 1 ? x :
            invert( x.substring(1) ) + x.substring(0, 1);    
    }

    public static void main(String[] args) throws IOException 
    {
        System.out.println("Ende mit potS oder ^Z.");
        System.out.println();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileInput = new BufferedReader(new InputStreamReader( new FileInputStream( 
                new File("C:\\Users\\Denni\\Documents\\262003 Interaktive Programme\\first\\EsreverLister.java"))));

        List<String> WordList = new ArrayList<String>();
        while(true)
        {
            //System.out.print("-> ");
            //String s = keyboard.readLine();

            String s = fileInput.readLine();

            if( s == null || s.equalsIgnoreCase("potS"))
            {
                break;
            }
            WordList.add(invert(s));
        }

        ListIterator<String> x = WordList.listIterator(WordList.size());
        while(x.hasPrevious())
        {
            System.out.println(x.previous());
        }

        System.out.println("Ende");
        keyboard.close();
    }
}