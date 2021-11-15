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
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Es werden Text-Zeilen von der Tastaur eingelesen, solange bis das Wort „potS“ eingegeben wird");
        String a = MyIO.promtAndRead("Soll Test auf sich selbst durchgeführt werden (y)?:   ");

        if( a.equals("y"))
        {
            BufferedReader fileInput = new BufferedReader(new InputStreamReader( new FileInputStream( 
                new File("first\\EsreverLister.java"))));

            System.out.println("Test wird durchgeführt:");

            List<String> WordList1 = new ArrayList<String>();
            while(true)
            {
                String s = fileInput.readLine();

                if( s == null || s.equalsIgnoreCase("potS"))
                {
                    break;
                }
                WordList1.add(invert(s));
            }

            ListIterator<String> x = WordList1.listIterator(WordList1.size());
            while(x.hasPrevious())
            {
                System.out.println(x.previous());
            }
        }

        System.out.println();
        System.out.println("Jetzt gehts los. Bitte Text-Zeile eingeben (Für Stop „potS“ eingeben):");
        List<String> WordList2 = new ArrayList<String>();
        while(true)
        {
            System.out.print("-> ");
            String s = keyboard.readLine();

            if( s == null || s.equalsIgnoreCase("potS"))
            {
                break;
            }
            WordList2.add(invert(s));
        }

        ListIterator<String> x2 = WordList2.listIterator(WordList2.size());
        while(x2.hasPrevious())
        {
            System.out.println(x2.previous());
        }

        System.out.println("Ende");
        keyboard.close();
    }
}
