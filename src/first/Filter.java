package first;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * das den Benutzer erst nach der URL einer Text-Quelle im Internet und dann nach einem Text-String (dem Muster) fragt, 
 * beide Informationen einliest und dann genau nur diejenigen Zeilen der Quelle auf den Bildschirm ausgibt, 
 * in denen das Muster (unabhängig von Groß-Kleinschreibung) enthalten ist.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 11.10.2021
 */

public class Filter 
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader isr;
        BufferedReader keyboard;
        isr = new InputStreamReader (System.in);
        keyboard = new BufferedReader (isr);

        System.out.println("Zu durchsuchende URL im Internet:");
        String internet = keyboard.readLine();   // "https://www.whitehouse.gov/"

        URL u = new URL (internet);
        FilterInputStream ins = (FilterInputStream) u.openStream();
        InputStreamReader isr2 = new InputStreamReader(ins);
        BufferedReader webside = new BufferedReader(isr2);

        System.out.println("Zu suchendes Wort:");
        String muster = keyboard.readLine();    // "Jill"

        int a = 0;
        String line = webside.readLine();
        while (line != null) 
        {
            if ( line.toLowerCase().contains( muster.toLowerCase() ) ) 
            {
                System.out.println(line);
                a++;
            }
            line = webside.readLine();
        }

        System.out.println();
        System.out.println("Gefundene Zeilen: " + a);
    }
}