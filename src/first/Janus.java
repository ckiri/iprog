package first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * das seinen eigenen Programmtext auf den Bildschirm ausgibt.
 * @author DDeifel, DMaric, DAgres, CKiriakou
 * @version 1, 11.10.2021
 */

public class Janus 
{
    public static void main (String[] args) throws IOException
    {
        //File f = new File("first/Janus.java");
        //File f = new File("C:\\Users\\Denni\\Documents\\Interaktive Programme\\first\\Janus.java");
        File f = new File("C:/Users/Denni/Documents/Interaktive Programme/first/Janus.java");
        FileInputStream fStream = new FileInputStream(f);

        InputStreamReader isr;
        BufferedReader fileInput;
        isr = new InputStreamReader(fStream);
        fileInput = new BufferedReader(isr);
        
        String line = fileInput.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = fileInput.readLine();
        }

        fileInput.close();
    }
}