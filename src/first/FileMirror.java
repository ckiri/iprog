package first;
/**
 * Filter
 * @author DMaric, DDeifel, DAgres, CKirakou
 * @version 1, 11.10.2021
 **/
import java.io.*;

public class FileMirror {
    public static String invert(String h){

        return h.length()<= 1 ? h :
                invert(h.substring(1)) + h.substring(0, 1);

    }
    public static void main(String[] args) throws IOException{
        String inputLine;
        String file1;
        String file2;

        InputStreamReader isr2;
        BufferedReader keyboard;
        BufferedReader keyboard2;
        isr2 = new InputStreamReader(System.in);
        keyboard = new BufferedReader(isr2);
        keyboard2 = new BufferedReader(isr2);

        System.out.println("Write the file path for the first file below:");        //z.B. src/first/FileMirror1
        file1 = keyboard.readLine();
        System.out.println("Write the file path for the second file below:");       //z.B. src/first/FileMirror2
        file2 = keyboard2.readLine();

        File f = new File(file1);
        FileInputStream fs = new FileInputStream(f);

        InputStreamReader isr;
        BufferedReader fileInput;
        isr = new InputStreamReader(fs);
        fileInput = new BufferedReader(isr);
        inputLine = fileInput.readLine();

        File g = new File(file2);
        PrintStream target = new PrintStream(new FileOutputStream(g));

        while(inputLine != null) {
            target.println(invert(inputLine));
            inputLine = fileInput.readLine();
        }

    }
}
