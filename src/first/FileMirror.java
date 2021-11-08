package first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * das nach zwei Namen von Textdateien fragt und die erste Datei in die zweite Datei kopiert, 
 * wobei aber jede einzelne Zeile gespiegelt (invertiert) geschrieben wird.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 11.10.2021
 */

public class FileMirror 
{
    public static String invert (String x) 
	{
		return x.length() <= 1 ? x :
		invert( x.substring(1) ) + x.substring(0,1);
    }

    public static void main (String[] args) throws IOException
    {
        InputStreamReader isr;                      //Eingabe der Tastatur
        BufferedReader keyboard;
        isr = new InputStreamReader (System.in);
        keyboard = new BufferedReader (isr);

        System.out.println("Nennen Sie die zu kopierende Datei:");  // "first/FileMirror1.txt"
        String file1 = keyboard.readLine();                         //file1 muss vorhanden sein im Projektordner

        System.out.println("Nennen Sie die Klon Datei:");   // "first/FileMirror1_invert.txt"
        String file2 = keyboard.readLine();                 //file1_invert wird erstellt oder ersetzt wenn schon vorhanden im Projektordner

        isr = new InputStreamReader( new FileInputStream( new File(file1) ) );  //Eingabe der zu kopierenden Datei
        BufferedReader fileInput = new BufferedReader(isr);

        PrintStream target = new PrintStream( new FileOutputStream( new File(file2) ) ); //Ausgabe der Klon Datei
        
        String line = fileInput.readLine(); //Kopieren der Datei1 zu Datei1_invert
        while (line != null)
        {
            target.println( invert(line) ); //Einzelne Linie wird (invertiert) kopiert
            line = fileInput.readLine();
        }

        fileInput.close();
    }   
}