package first;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;

public class Janus {
    public static void main (String[] a) throws IOException{
        String inputLine;
        // Vom Dateinamen zum FileInputStream
        File            f = new File("src/first/Janus.java");
        FileInputStream fs = new FileInputStream(f);
        // Vom FileInputStream zum BufferedReader
        InputStreamReader isr;
        BufferedReader    fileInput;
        isr = new InputStreamReader(fs);
        fileInput = new BufferedReader(isr);
        inputLine = fileInput.readLine();

        while(inputLine != null) {
            System.out.println(inputLine);
            inputLine = fileInput.readLine();
        }
    }
}
